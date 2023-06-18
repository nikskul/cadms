"use client";

import { APIv1 } from "@/components/api";
import { LoginRequest, login } from "@/lib/getUser";
import Link from "next/link";
import { useRouter } from "next/navigation";
import { useState } from "react";

export default function Login() {
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const router = useRouter();

  const handleSubmit = async (event) => {
    event.preventDefault();
    setLoading(true);

    const data = new FormData(event.target);

    const email = data.get("email");
    const password = data.get("password");

    const credentials = {
      email,
      password,
    } as unknown as LoginRequest;

    try {
      const response = await login(credentials);
      localStorage.setItem("user", JSON.stringify(response));
      router.push("/");
    } catch (error) {
      setError("Пользователь не найден!"); // установка сообщения об ошибке
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="flex m-auto w-full min-h-screen">
      <form
        onSubmit={handleSubmit}
        action={APIv1 + "/login"}
        method="post"
        className=" flex flex-col justify-start gap-4 max-w-lg w-full m-auto border-black shadow p-8
        rounded-xl"
      >
        <h2>Авторизация</h2>
        {loading ? <>Загрузка</> : <></>}
        {error && <p>{error}</p>}
        <input
          className="border px-2 py-1"
          type="email"
          name="email"
          placeholder="email@mail.ru"
          required
        />
        <input
          className="border px-2 py-1"
          type="password"
          name="password"
          placeholder="*******"
          required
        />
        <Link href="/register" className="text-blue-600">
          Регистрация
        </Link>
        <input
          className="border px-2 py-1 hover:cursor-pointer hover:font-bold"
          type="submit"
          value="Авторизация"
        />
      </form>
    </div>
  );
}

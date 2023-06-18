'use client';

import { APIv1 } from "@/components/api";
import { RegisterRequest, register } from "@/lib/getUser";
import Link from "next/link";
import { useRouter } from "next/navigation";
import { useState } from "react";

export default function Register() {
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const router = useRouter();

  const handleSubmit = async (event) => {
    event.preventDefault();
    setLoading(true);

    const data = new FormData(event.target);

    const name = data.get("name");
    const email = data.get("email");
    const income = data.get("income");
    const password = data.get("password");
    const birthDate = data.get("birthDate");
    const lastWorkExperience = data.get("lastWorkExperience");

    const credentials = {
      name,
      email,
      income,
      password,
      birthDate,
      lastWorkExperience,
    } as unknown as RegisterRequest;

    try {
      const { status, message } = await register(credentials);
      if (status === "FAILED") {
        setError(message);
        return;
      }
      router.push('/login')
    } catch (error) {
      setError("Не удалось отправить запрос на сервер!"); // установка сообщения об ошибке
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
        <h2>Регистрация</h2>
        {loading ? <>Загрузка</> : <></>}
        {error && <p>{error}</p>} {/* отображение сообщения об ошибке */}
        <input
          className="border px-2 py-1"
          type="text"
          name="name"
          placeholder="Фамилия Имя Отчество"
          required
        />
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
        <input
          className="border px-2 py-1"
          type="number"
          name="income"
          placeholder="Доход (12 300)"
          required
        />
        <input
          className="border px-2 py-1"
          type="date"
          name="birthDate"
          placeholder="01.01.1980"
          required
        />
        <input
          className="border px-2 py-1"
          type="text"
          name="lastWorkExperience"
          placeholder="Стаж работы (1)"
          required
        />
        <Link href="/login" className="text-blue-600">
          Авторизация
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

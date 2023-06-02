"use client";

import { APIv1 } from "@/components/api";
import { LoginRequest, login } from "@/lib/getUser";
import { useState } from "react";

export default function Login() {
  const [error, setError] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault();

    const data = new FormData(event.target);

    const email = data.get("email");
    const password = data.get("password");

    const credentials = {
      email,
      password,
    } as unknown as LoginRequest;

    try {
      const response = await login(credentials);
      console.log(response);
      
      localStorage.setItem("user", JSON.stringify(response));

    } catch (error) {
      setError("User not found"); // установка сообщения об ошибке
    }   

  };

  return (
    <div className="flex m-auto w-full h-screen">
      <form
        onSubmit={handleSubmit}
        action={APIv1 + "/login"}
        method="post"
        className=" flex flex-col justify-start gap-4 max-w-lg w-full m-auto border-black "
      >
        {error && <p>{error}</p>} {/* отображение сообщения об ошибке */}
        <input type="email" name="email" placeholder="email@mail.ru" />
        <input type="password" name="password" placeholder="*******" />
        <input type="submit" value="Send Request" />
      </form>
    </div>
  );
}

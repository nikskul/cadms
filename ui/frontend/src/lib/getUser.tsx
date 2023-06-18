"use client";

import { APIv1 } from "@/components/api";
import { User } from "@/components/api/users/user";

export function getUser() {
  return JSON.parse(localStorage.getItem("user")) as unknown as User;
}

export interface LoginRequest {
  email: string;
  password: string;
}

export interface RegisterRequest {
  name: string;
  email: string;
  income: number;
  password: string;
  birthDate: string;
  lastWorkExperience: number;
}

export interface BaseOperationResponse {
  status: string;
  message: string;
}

export async function login(req: LoginRequest) {
  const { email, password } = req;

  const res = await fetch(APIv1 + "/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ email, password }),
  });

  if (!res.ok) throw new Error("failed to fetch data");

  const bodyText = await res.text();
  return JSON.parse(bodyText) as User;
}

export async function register(req: RegisterRequest) {
  const { name, email, income, password, birthDate, lastWorkExperience } = req;

  const res = await fetch(APIv1 + "/register", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      name,
      email,
      income,
      password,
      birthDate,
      lastWorkExperience,
    }),
  });

  if (!res.ok) throw new Error("failed to fetch data");

  const bodyText = await res.text();
  return JSON.parse(bodyText) as BaseOperationResponse;
}

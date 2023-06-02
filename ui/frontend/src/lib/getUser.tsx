"use client";

import { APIv1 } from "@/components/api";
import { User } from "@/components/api/users/user";

export function getUser() {
  return localStorage.getItem('user');
}

export interface LoginRequest {
  email: string;
  password: string;
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

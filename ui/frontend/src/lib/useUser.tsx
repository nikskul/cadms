"use client";

import { User } from "@/app/api/users/user";
import { APIv1 } from "@/app/components/api";
import { data } from "autoprefixer";
import useSWR from "swr";

const fetcher = (url: URL) => fetch(url).then((r) => r.json());

export default function useUser() {
  const { data: user, error: error } = useSWR(APIv1 + "/login", fetcher);

  return { user: user as User, error };
}

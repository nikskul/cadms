"use client";

import { getUser } from "../lib/getUser";
import { redirect, usePathname } from "next/navigation";

export default function ProtectedRoute({
  children,
}: {
  children: React.ReactNode;
}) {
  const pathname = usePathname();

  const user = getUser();

  console.log("User: " + user);

  if (!user) {
    redirect("/login");
  }

  return <>{children}</>;
}

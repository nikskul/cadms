"use client";

import Layout from "@/components/layout";
import "@styles/globals.css";
import { Raleway } from "next/font/google";
import ProtectedRoute from "./protected-root";
import { redirect, usePathname } from "next/navigation";
import { getUser } from "@/lib/getUser";

const raleway = Raleway({ subsets: ["latin"] });

export const metadata = {
  title: "Подсистема помощи принятия финансовых решений",
  description: "Контроль и управление финансами",
};

export default function RootLayout({ children }) {
  const pathname = usePathname();

  if (pathname === "/login" || pathname === "/register") {
    if (!getUser()) {
      return (
        <html lang="ru">
          <body className={raleway.className}>{children}</body>
        </html>
      );
    }
    redirect("/");
  }

  return (
    <html lang="ru">
      <body className={raleway.className}>
        <ProtectedRoute>
          <Layout>{children}</Layout>
        </ProtectedRoute>
      </body>
    </html>
  );
}

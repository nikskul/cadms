import "@styles/globals.css";
import { Raleway } from "next/font/google";

const raleway = Raleway({ subsets: ["latin"] });

export const metadata = {
  title: "Подсистема помощи принятия финансовых решений",
  description: "Контроль и управление финансами",
};

interface RootLayoutProps {
  children: React.ReactNode;
}

export default function RootLayout({ children }: RootLayoutProps) {
  return (
    <html lang="ru">
      <body className={raleway.className}>{children}</body>
    </html>
  );
}

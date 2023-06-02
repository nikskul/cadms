import "@styles/sidebar.css";

import MenuItem from "./menu-item";
import Image from "next/image";

export default function Sidebar() {
  const logoName = "ФинКонтроль" as string;
  const subText = "Финансы под контролем" as string;

  return (
    <section className="sidebar relative h-screen py-6">
      <div className="flex flex-row w-full px-6">
        <Image
          width={32}
          height={32}
          className="logo"
          src="logo.svg"
          alt="Логотип ФинКонтроль"
        />
        <div className="flex flex-col ml-6">
          <p className="font-bold text-sm">{logoName}</p>
          <p className="text-xs">{subText}</p>
        </div>
      </div>
      <nav className="flex flex-col justify-start mt-32 text-base gap-3 px-6 align-middle">
        <MenuItem linkName={"Главная"} url={"/"} iconFileName={"main.svg"} />
        <MenuItem
          linkName={"Личный кабинет"}
          url={"/user"}
          iconFileName={"profile.svg"}
        />
        <MenuItem
          linkName={"Кредиты"}
          url={"/loans"}
          iconFileName={"card.svg"}
        />
      </nav>
      <div
        className="absolute leaf 
        flex justify-end flex-col
       bg-white pb-3 px-2 cursor-grab active:cursor-grabbing
        w-10 h-16
        top-0 left-full
        rounded-br-2xl
        select-none"
      >
        <Image
          width={40}
          height={64}
          className="w-5 h-5 select-none pointer-events-none"
          src={"menu.svg"}
          alt="Иконка меню. Потяните"
        />
      </div>
    </section>
  );
}

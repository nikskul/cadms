"use client";

import { User } from "@/components/api/users/user";
import Card, { Row } from "@/components/card/card";
import { currencyFormatter, dateWithPostfix } from "@/components/util/util";
import { getUser } from "@/lib/getUser";

export default function UsersPage() {
  const user  = JSON.parse(getUser()) as User;

  if (!user) {
    return <>Loading user page...</>
  }

  const formatedDate = new Date(user.birthDate);

  const rows = [
    <Row key={"Почта"} left="Почта" right={user.email} />,
    <Row
      key={"Дата рождения"}
      left="Дата рождения"
      right={formatedDate.toLocaleDateString("ru-RU")}
    />,
    <Row
      key={"Доход в месяц"}
      left="Доход в месяц"
      right={currencyFormatter.format(user.income)}
    />,
    <Row
      key={"Стаж"}
      left="Стаж"
      right={dateWithPostfix(user.lastWorkExperience)}
    />,
  ];

  return (
    <>
      <div className="">
        <h1>Личный кабинет</h1>
        <div className="card mt-6">
          <Card header={user.name} rows={rows} />
        </div>
      </div>
    </>
  );
}


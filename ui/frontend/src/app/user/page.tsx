"use client";

import { APIv1 } from "@/components/api";
import { User } from "@/components/api/users/user";
import Card, { Row } from "@/components/card/card";
import { currencyFormatter, dateWithPostfix } from "@/components/util/util";
import { Transaction } from "@/lib/transactions";
import Image from "next/image";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";
import useSWR from "swr";

const fetcher = (url: RequestInfo | URL) => fetch(url).then((r) => r.json());

export default function UsersPage() {
  const router = useRouter();
  const value = localStorage.getItem("user");
  const user = !!value ? JSON.parse(value) : undefined;

  const { data: transactions, error: transactionError } = useSWR<Transaction[]>(
    `${APIv1}/transactions/user/${user.id}`,
    fetcher
  );

  if (transactionError) {
    return <>Ошибка загрузки...</>;
  }

  if (!user || !transactions) {
    return <>Loading user page...</>;
  }

  const list = transactions.map((transaction) => {
    const date = new Date(transaction.date);

    const symbol = transaction.type === "INCOME" ? "+" : "-";

    return (
      <Card
        key={transaction.id}
        header={symbol + currencyFormatter.format(transaction.amount)}
        rows={[
          <Row left={"Дата:"} right={date.toLocaleDateString("ru-RU")} />,
          <Row left={"Описание:"} right={transaction.description} />,
        ]}
      />
    );
  });

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
      <div className="flex flex-col">
        <h1 className="mb-6">Личный кабинет</h1>
        <div className="flex flex-row gap-24">
          <div className="">
            <Card header={user.name} rows={rows} />
          </div>
          <div className="flex flex-col gap-6">
            <h2>Транзакции</h2>
            {list}
            <button
              onClick={() => router.push("/transactions/create")}
              className="bg-black bg-opacity-10 w-80 text-white flex justify-center h-10 items-center transition-all duration-200 hover:bg-opacity-50 active:bg-opacity-75 active:duration-75"
            >
              <Image
                className="select-none pointer-events-none"
                width={15}
                height={15}
                src="plus.svg"
                alt="Добавить транзакцию"
              />
            </button>
          </div>
        </div>
      </div>
    </>
  );
}

"use client";

import { APIv1 } from "@/components/api";
import { Loan } from "@/components/api/users/loan";
import Card, { Row } from "@/components/card/card";
import { LoanInfo } from "@/components/loan/loan-card";
import { dateWithPostfix } from "@/components/util/util";
import { analyzeLoan } from "@/lib/loans";
import Link from "next/link";
import { useRouter } from "next/navigation";
import { useState } from "react";
import useSWR, { mutate } from "swr";

const fetcher = (url: RequestInfo | URL) => fetch(url).then((r) => r.json());

const worthinessMap = new Map([
  ["SOLVENT", "Высокая"],
  ["MEDIUM", "Средняя"],
  ["INSOLVENT", "Низкая"],
]);

const incomeLevelMap = new Map([
  ["HIGH", "Высокий"],
  ["MEDIUM", "Средний"],
  ["SMALL", "Низкий"],
]);

const creditRatingMap = new Map([
  ["EXCELLENT", "Отличный"],
  ["GOOD", "Высокий"],
  ["FAIR", "Нормальний"],
  ["POOR", "Низкий"],
  ["INFERIOR", "Ужасный"],
]);

export type Criteria = {
  incomeLevel: string;
  creditRating: string;
  personAge: number;
  workExperience: number;
  worthiness: string;
  loan: Loan;
};

export default function LoanPage({ params }) {
  const [error, setError] = useState("");

  const { data: criteria, error: criteriaError } = useSWR(
    `${APIv1}/loan-criteria/loan/${params.id}`,
    fetcher
  );

  if (criteriaError) return <div>Failed to load criteria</div>;
  if (!criteria) return <div>Loading criteria...</div>;

  let worthiness = "";
  if (worthinessMap.has(criteria.worthiness)) {
    worthiness = worthinessMap.get(criteria.worthiness);
  }
  let creditRating = "";
  if (creditRatingMap.has(criteria.creditRating)) {
    creditRating = creditRatingMap.get(criteria.creditRating);
  }
  let incomeLevel = "";
  if (incomeLevelMap.has(criteria.incomeLevel)) {
    incomeLevel = incomeLevelMap.get(criteria.incomeLevel);
  }

  const criteriaRows = [
    <Row
      key={"Возраст:"}
      left={"Возраст:"}
      right={dateWithPostfix(criteria.personAge)}
    />,
    <Row
      key={"Стаж работы:"}
      left={"Стаж работы:"}
      right={dateWithPostfix(criteria.workExperience)}
    />,
    <Row
      key={"Уровень дохода:"}
      left={"Уровень дохода:"}
      right={incomeLevel}
    />,
    <Row
      key={"Кредитный рейтинг:"}
      left={"Кредитный рейтинг:"}
      right={creditRating}
    />,
  ];

  const analyze = async (id: any) => {
    analyzeLoan(id).then((res) => {
      if (res.status === "OK") {
        mutate(`${APIv1}/loan-criteria/loan/${params.id}`);
        return;
      }
      setError(res.message);
    });
  };

  return (
    <div className="flex flex-col gap-6">
      <h1 className="mb-6">{criteria.loan.bankName}</h1>
      <LoanInfo loan={criteria.loan} />

      <Card header={"Критерии"} rows={criteriaRows} />
      <Card
        header={"Результат анализа"}
        rows={[
          <>{error && <p>{error}</p>}</>,
          <Row
            key={"Кредитоспособность:"}
            left={"Кредитоспособность:"}
            right={
              !worthiness ? (
                <button
                  className="text-blue-600 hover:font-bold"
                  onClick={() => analyze(params.id)}
                >
                  Определить
                </button>
              ) : (
                worthiness
              )
            }
          />,
        ]}
      />
    </div>
  );
}

import { Loan } from "@/app/api/users/loan";
import { APIv1 } from "@/app/components/api";
import Card, { Row } from "@/app/components/card/Card";
import { LoanInfo, LoanRow } from "@/app/components/loan/loan-card";
import { dateWithPostfix } from "@/app/components/util/util";
import { useRouter } from "next/router";
import useSWR from "swr";

const fetcher = (url: URL) => fetch(url).then((r) => r.json());

const worthinessMap = new Map<string, string>([
  ["SOLVENT", "Высокая"],
  ["MEDIUM", "Средняя"],
  ["INSOLVENT", "Низкая"],
]);

const incomeLevelMap = new Map<string, string>([
  ["HIGH", "Высокий"],
  ["MEDIUM", "Средний"],
  ["SMALL", "Низкий"],
]);

const creditRatingMap = new Map<string, string>([
  ["EXCELLENT", "Отличный"],
  ["GOOD", "Высокий"],
  ["FAIR", "Нормальний"],
  ["POOR", "Низкий"],
  ["INFERIOR", "Ужасный"],
]);

export interface Criteria {
  incomeLevel: string;
  creditRating: string;
  personAge: number;
  workExperience: number;
  worthiness: string;
  loan: Loan;
}

export default function LoanPage() {
  const router = useRouter();

  const {
    data: criteria,
    error: criteriaError,
  }: { data: Criteria; error: any } = useSWR(
    `${APIv1}/loan-criteria/loan/${router.query.id}`,
    fetcher
  );

  if (criteriaError) return <div>Failed to load criteria</div>;
  if (!criteria) return <div>Loading criteria...</div>;

  let worthiness = "";
  if (worthinessMap.has(criteria.worthiness)) {
    worthiness = worthinessMap.get(criteria.worthiness)!;
  }
  let creditRating = "";
  if (creditRatingMap.has(criteria.creditRating)) {
    creditRating = creditRatingMap.get(criteria.creditRating)!;
  }
  let incomeLevel = "";
  if (incomeLevelMap.has(criteria.incomeLevel)) {
    incomeLevel = incomeLevelMap.get(criteria.incomeLevel)!;
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
      key={"Кредитная история:"}
      left={"Кредитная история:"}
      right={creditRating}
    />,
  ];

  return (
    <div className="flex flex-col gap-6">
      <h1 className="mb-6">{criteria.loan.bankName}</h1>
      <LoanInfo loan={criteria.loan} />

      <Card header={"Критерии"} rows={criteriaRows} />
      <Card
        header={"Результат анализа"}
        rows={[
          <Row
            key={"Кредитоспособность:"}
            left={"Кредитоспособность:"}
            right={worthiness}
          />,
        ]}
      />
    </div>
  );
}

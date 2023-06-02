import { Loan } from "@/components/api/users/loan";
import Link from "next/link";
import React from "react";
import { currencyFormatter, dateWithPostfix } from "../util/util";

export function LoanRow({ left, right }: { left: string; right: string }) {
  return (
    <div className="w-80 flex justify-between">
      <div>{left}</div>
      <div>{right}</div>
    </div>
  );
}

export function LoanInfo({ loan }: { loan: Loan }) {
  return (
    <div className="flex flex-col w-full gap-2">
      <LoanRow left="Сумма кредита:" right={currencyFormatter.format(loan?.amount)} />
      <LoanRow left="Срок кредита:" right={dateWithPostfix(loan?.term)} />
      <LoanRow left="Процентная ставка:" right={loan?.interestRate + "%"} />
    </div>
  );
}

export default function LoanCard({ loan }: { loan: Loan }) {
  return (
      <div className="flex flex-col gap-2 transition-all duration-150">
        <h3 className="w-full hover:text-blue-400">
          <Link href={"/loans/" + loan?.id}>{loan.bankName}</Link>
        </h3>
        <LoanInfo loan={loan} />
      </div>
  );
}

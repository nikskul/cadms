"use client";

import { APIv1 } from "@/components/api";
import LoanCard from "@/components/loan/loan-card";
import Image from "next/image";
import { usePathname, useRouter } from "next/navigation";
import useSWR from "swr";

const fetcher = (url) => fetch(url).then((r) => r.json());

export default function LoansPage() {
  const value = localStorage.getItem("user");
  const user = !!value ? JSON.parse(value) : undefined;

  const { data, error } = useSWR(
    user ? `${APIv1}/loans/user/${user.id}` : null,
    fetcher
  );

  const router = useRouter();

  if (error) {
    return <>Failed to load</>;
  }

  if (!data) {
    return <>Loading loans...</>;
  }

  const list = data.map((loan) => <LoanCard key={loan.id} loan={loan} />);

  return (
    <section className="flex">
      <div className="flex flex-col">
        <h1>Кредиты</h1>
        <div className="flex mt-20 max-w-sm w-full">
          <div className="flex flex-col gap-8">
            <h2>Список кредитов</h2>
            {list}
            <button
            onClick={() => router.push('/loans/create')}
            className="bg-black bg-opacity-10 w-80 text-white flex justify-center h-10 items-center transition-all duration-200 hover:bg-opacity-50 active:bg-opacity-75 active:duration-75">
              <Image
                className="select-none pointer-events-none"
                width={15}
                height={15}
                src="plus.svg"
                alt="Добавить кредит"
              />
            </button>
          </div>
        </div>
      </div>
    </section>
  );
}

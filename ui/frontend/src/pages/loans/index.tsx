import { Loan } from "@/app/api/users/loan";
import { User } from "@/app/api/users/user";
import { APIv1 } from "@/app/components/api";
import LoanCard from "@/app/components/loan/loan-card";
import Image from "next/image";
import useSWR from "swr";

const fetcher = (url: URL) => fetch(url).then((r) => r.json());

export default function LoansPage({ user }: { user: User }) {
  const { data, error } = useSWR(`${APIv1}/loans/user/${user.id}`, fetcher);

  if (error) return <div>Failed to load</div>;
  if (!data) return <div>Loading...</div>;

  console.log(data);

  const list = data.map((loan: Loan) => <LoanCard key={loan.id} loan={loan} />);

  return (
    <section className="flex">
      <div className="flex flex-col">
        <h1>Кредиты</h1>
        <div className="flex mt-20 max-w-sm w-full">
          <div className="flex flex-col gap-8">
            <h2>Список кредитов</h2>
            {list}
            <button className="bg-black bg-opacity-10 text-white flex justify-center h-10 items-center transition-all duration-200 hover:bg-opacity-50 active:bg-opacity-75 active:duration-75">
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

import { NestedObject } from "@/lib/loans";

export type Loan = {
  id: string;
  bankName: string;
  amount: number;
  term: number;
  interestRate: number;
  status: string;
  startDate: string;
  user: NestedObject;
};

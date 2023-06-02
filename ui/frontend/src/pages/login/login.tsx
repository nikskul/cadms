import { User } from "@/app/api/users/user";
import { APIv1 } from "@/app/components/api";

export default function Login({ user }: { user: User | undefined }) {
  return (
    <div className="flex m-auto w-full h-screen">
      <form
        action={APIv1 + "/login"}
        method="post"
        className=" flex flex-col justify-start gap-4 max-w-lg w-full m-auto border-black "
      >
        <input type="email" placeholder="email@mail.ru" />
        <input type="password" placeholder="*******" />
      </form>
    </div>
  );
}

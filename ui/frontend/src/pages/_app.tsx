import Layout from "@/app/components/layout";
import useUser from "@/lib/useUser";
import { redirect } from "next/navigation";
import { useRouter } from "next/router";
import { useEffect } from "react";
import Login from "./login/login";

export default function MyApp({
  Component,
  pageProps,
}: {
  Component: any;
  pageProps: any;
}) {
  const {user, error} = useUser();

  console.log({ user });

  if (!user) {
    return <Login user={user} />
  }

  return (
    <Layout>
      <Component {...pageProps} user={user} />
    </Layout>
  );
}

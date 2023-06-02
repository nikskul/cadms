import SidebarWith from "./sidebar-with";

export default function Layout({ children }: { children: React.ReactNode }) {
  return (
    <SidebarWith>
      <main className="px-12 py-20 w-full">{children}</main>
    </SidebarWith>
  );
}

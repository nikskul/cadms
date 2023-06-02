import Sidebar from "./sidebar/sidebar";

export default function SidebarWith({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <main className="flex">
      <Sidebar />
      {children}
    </main>
  );
}

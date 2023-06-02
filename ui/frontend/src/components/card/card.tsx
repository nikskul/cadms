export function Row({ left, right }: { left: string; right: string }) {
  return (
    <div key={left} className="w-80 flex justify-between">
      <div>{left}</div>
      <div>{right}</div>
    </div>
  );
}

export default function Card({
  header,
  rows,
}: {
  header: string;
  rows: React.ReactElement[];
}) {
  return (
    <div className="flex flex-col w-full gap-2">
      <h3>{header}</h3>
      {rows}
    </div>
  );
}

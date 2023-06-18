import Link from "next/link";
import React from "react";

export function Row({
  left,
  right,
}: {
  left: string;
  right: string | React.ReactElement;
}) {
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
  header: string | React.ReactElement;
  rows: React.ReactElement[];
}) {
  return (
    <div className="flex flex-col gap-2">
      <h3>{header}</h3>
      {rows}
    </div>
  );
}

import Link from "next/link";
import Icon from "./menu-icon";

export default function MenuItem({
  linkName,
  url,
  iconFileName,
}: {
  linkName: string;
  url: string;
  iconFileName: string;
}) {
  return (
    <Link
      href={url}
      className="flex justify-between w-full align-middle transition-all duration-100 hover:font-bold"
    >
      <p className="menu-item__text h-full align-middle">{linkName}</p>
      <Icon fileName={iconFileName} />
    </Link>
  );
}

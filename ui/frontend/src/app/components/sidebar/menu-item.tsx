import Link from "next/link";
import Icon from './menu-icon';

export default function MenuItem(
    { linkName, url, iconFileName }:
        { linkName: string, url: string, iconFileName: string }
) {
    return (
        <div className="flex justify-between w-full align-middle">
            <Link className="menu-item__text h-full align-middle" href={url}>{linkName}</Link>
            <Icon fileName={iconFileName} />
        </div>
    )
}
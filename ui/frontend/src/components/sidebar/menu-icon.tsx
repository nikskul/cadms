import Image from 'next/image'

export default function Icon({ fileName }: { fileName: string }) {
    return (
        <div className="w-8 h-full">
            <Image
                width={32}
                height={32}
                src={"/" + fileName}
                alt={'Иконка '.concat(fileName)}
            />
        </div>
    )
}
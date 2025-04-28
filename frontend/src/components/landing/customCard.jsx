import { Card, CardHeader, CardBody, Image } from "@heroui/react";

export default function CustomCard({ image, title, description }) {
  return (
    <Card className="w-full max-w-[320px] h-[350px] shadow-md rounded-lg bg-white flex flex-col overflow-hidden">
      <CardHeader className="p-3">
        <div className="w-full h-[140px] rounded-lg overflow-hidden">
          <Image
            isZoomed
            alt="Imagen"
            src={image}
            className="w-full h-full object-cover rounded-lg"
          />
        </div>
      </CardHeader>
      <CardBody className="px-4 py-3 flex flex-col gap-2 h-full">
        <h4 className="text-xl font-bold mb-1 line-clamp-1">{title}</h4>
        <p className="text-gray-600 flex-grow">{description}</p>
      </CardBody>
    </Card>
  );
}

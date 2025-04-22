import { Chip } from "@heroui/react";
import React from "react";

function Etiquetas() {
  const generosMusicales = [
    "Rock",
    "Hard Rock",
    "Punk Rock",
  ];

  const menor = '50';
  const mayor = '90';

  const [tipos_de_eventos, set_tipo_de_eventos] =
    React.useState(generosMusicales);

  return (
    <div className="flex gap-4 flex-wrap w-full p-5 bg-[url('/images/background.jpg')] bg-cover bg-center justify-center">
      {tipos_de_eventos.map((tipo, index) => (
        <Chip key={index} variant="flat" className="bg-black text-white">
          {tipo}
        </Chip>
      ))}

      <div className="flex flex-wrap gap-4 text-black font-bold text-5xl">
        {menor} - {mayor}
      </div>
    </div>
  );
}

export default Etiquetas;

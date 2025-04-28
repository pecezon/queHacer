import { Chip } from "@heroui/react";
import React from "react";

function Etiquetas() {
  const titulo = "Milky Chance";
  const generosMusicales = ["Indie Pop", "Folk", "Electrónica", "Rock Alternativo"];
  const menor = '89.10';
  const mayor = '1,944.00';

  return (
    <div className="relative flex flex-col items-center w-full min-h-[300px] p-8 overflow-hidden bg-black/40">
      
      <div className="absolute inset-0 bg-[url('https://i.ytimg.com/vi/-J9DSj1Qkc8/maxresdefault.jpg')] bg-cover bg-center z-0" />
      
      
      <div className="z-10 w-full max-w-xs flex flex-col items-center gap-6">
      
        <h1 className="text-4xl font-bold text-white text-center">
          {titulo}
        </h1>
        
      
        <div className="grid grid-cols-2 gap-3 w-full">
          {generosMusicales.map((tipo, index) => (
            <div key={index} className="flex justify-center">
              <Chip 
                variant="flat" 
                className="bg-black text-white px-4 py-2 text-lg"
              >
                {tipo}
              </Chip>
            </div>
          ))}
        </div>

    
        <div className="text-white font-bold text-5xl text-center">
          ${menor} <span className="mx-1">-</span> ${mayor}
          <span className="text-sm "> USD</span>
        </div>
      </div>
    </div>
  );
}

export default Etiquetas;

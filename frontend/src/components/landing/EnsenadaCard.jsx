import React from 'react';
import { Card, CardBody, CardHeader, Image } from "@heroui/react";

function EnsenadaCard() {
  return (
    <Card className="w-full sm:w-9/12 mx-auto my-6 p-4 bg-white shadow-lg rounded-lg">
      <CardHeader className="flex justify-start">
        <h4 className="text-black font-bold text-xl">ENSENADA</h4>
      </CardHeader>
      <CardBody>
        <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
          <div className="relative p-2">
            <p className="text-gray-700 text-base">
              Ensenada, Baja California, es una ciudad portuaria en el
              noroeste de México, conocida por su gastronomía, rutas
              vinícolas, y paisajes costeros. Es un destino turístico
              clave con playas, surf, y el famoso bufadero.
            </p>
            <br />
            <p className="hidden sm:block text-gray-700 text-base">
              Ensenada, Baja California, es una vibrante ciudad portuaria
              en el noroeste de México, famosa por su gastronomía, vinos y
              paisajes costeros. Conocida como la "Cenicienta del
              Pacífico", ofrece una combinación única de belleza natural y
              desarrollo urbano. Sus principales atractivos incluyen la
              Ruta del Vino en el Valle de Guadalupe, reconocida
              internacionalmente, así como El Bufadoro, un espectacular
              géiser marino. Además, es un destino ideal para el
              ecoturismo, el surf y la pesca deportiva, atrayendo
              visitantes de todo el mundo. Su puerto es crucial para el
              comercio y la industria pesquera, además de recibir cruceros
              turísticos que enriquecen la economía local.
            </p>
          </div>

          <div className="flex justify-center items-center p-2">
            <Image
              alt="Cover"
              className="object-cover w-full sm:w-full h-auto rounded-lg shadow-md"
              src="https://web.didiglobal.com/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fn7hs0hadu6ro%2F7ga4fshNe680gD3iX6Q4a%2F947afc4c527f7bd63976c1c47c5b4252%2FiStock-159021515.jpg&w=640&q=75"
            />
          </div>
        </div>
      </CardBody>
    </Card>
  );
}

export default EnsenadaCard;

import React from "react";
import { useParams } from "react-router-dom";
import Nav from "../../components/all/Nav.jsx";
import Etiquetas from "../../components/event/Etiquetas.jsx";
import CardEventUbi from "../../components/event/CardEventUbi.jsx";
import CardTIckets from "./CardTIckets.jsx";
import Footer from "../../components/all/Footer"

const EventPage = () => {
  const { id } = useParams();
  const horaInicio = '20:00';
  const horaFin = '2:00'
  const descripcion = "Milky Chance es una banda alemana formada en 2012, originaria de Kassel, Alemania. El grupo está compuesto principalmente por Clemens Rehbein (vocalista y guitarrista) y Philipp Dausch (productor y DJ). Se conocieron en la escuela y comenzaron a hacer música juntos, mezclando una gran variedad de estilos de forma muy original. "

  return (
    <div className="flex flex-col w-full h-full">
      <Nav/>
      <Etiquetas/>
      
      <div className="w-full flex flex-col lg:flex-row justify-between items-start gap-32 p-6 max-w-6xl mx-auto">
        
        <div className="w-full lg:w-1/2">
          <h1 className="text-2xl font-bold mb-4">Descripcion</h1>
          <p className="text-md whitespace-pre-line mb-6">
            {descripcion}
          </p>
          
          <hr className="w-full border-t border-gray-300 my-4" />
          <h1 className="text-2xl font-bold mb-4">Compra de boletos</h1>
          
          <div className="w-full flex justify-center items-center gap-6 p-4 flex-wrap">
            <CardTIckets
              fecha="27 de marzo de 2025 · Ensenada, Baja California"
              logo="https://cdn.brandfetch.io/idVogTb1a1/w/800/h/800/theme/dark/icon.png"
            />
            <CardTIckets
              fecha="2 de Abril de 2025 · Ensenada, Baja California"
              logo="https://cdn.brandfetch.io/idVogTb1a1/w/800/h/800/theme/dark/icon.png"
            />
          </div>

          
      
        </div>

        <div className="w-full lg:w-1/2 flex justify-center lg:justify-end">
          <CardEventUbi />
        </div>
      </div>

      <Footer></Footer>

    </div>
  );
};

export default EventPage;

import React from "react";
import { useParams } from "react-router-dom";
import Nav from "../../components/all/Nav.jsx";
import Etiquetas from "../../components/event/Etiquetas.jsx";
import CardEventUbi from "../../components/event/CardEventUbi.jsx";
import CardTIckets from "./CardTIckets.jsx";

const EventPage = () => {
  const { id } = useParams();
  const horaInicio = '20:00';
  const horaFin = '2:00'
  const descripcion = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero, sint tenetur soluta saepe ratione, obcaecati voluptates reiciendis aliquid quidem ipsam harum aspernatur pariatur odit? Sed quidem consectetur et culpa dolorem."

  return (
    <div className="flex flex-col w-full h-full">
      <Nav/>
      <Etiquetas/>
      <div className="w-full flex flex-wrap flex-col justify-center items-center gap-2 p-10"> 
        <h3 className="text-2xl font-bold">CONCIERTO LUIS MIGUEL</h3>
        <h5 className="text-xl">{horaInicio} - {horaFin}</h5>
        <p className="flex text-md text-center">
          {descripcion}
        </p>
      </div>
      <div className="w-full flex flex-wrap flex-row items-center gap-2 p-4">
        <CardEventUbi/>
        <CardTIckets/>
        <CardTIckets/>
        <CardTIckets/>
        
      </div>
    </div>
  );
};

export default EventPage;

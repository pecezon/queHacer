import React from "react";
import { useNavigate, useParams } from "react-router-dom";
import Nav from "../../components/all/Nav.jsx";
import Etiquetas from "../../components/event/Etiquetas.jsx";
import CardEventUbi from "../../components/event/CardEventUbi.jsx";
import CardTIckets from "./CardTIckets.jsx";
import { useReviews } from "../../context/EventContext.jsx";
import { ArrowLeftIcon } from "@heroicons/react/24/solid";
import Footer from "../../components/all/Footer"

const EventPage = () => {
  const { id } = useParams();
  const { getEventById, loading, error } = useReviews();

  const eventData = getEventById(id);
  const navigate = useNavigate();

  if (loading) {
    return (
      <div className="flex flex-col w-full h-full">
        <Nav />
        <div className="flex justify-center items-center h-64">
          <p className="text-xl">Cargando...</p>
        </div>
      </div>
    );
  }

  if (error) {
    return (
      <div className="flex flex-col w-full h-full">
        <Nav />
        <div className="flex justify-center items-center h-64">
          <p className="text-xl text-red-500">{error}</p>
        </div>
      </div>
    );
  }

  if (!eventData) {
    return (
      <div className="flex flex-col w-full h-full">
        <Nav />
        <div className="flex justify-center items-center h-64">
          <p className="text-xl">Evento no encontrado</p>
        </div>
      </div>
    );
  }

  return (
    <div className="flex flex-col w-full h-full">
      <Nav />

      <div className="p-5">
        <button
          onClick={() => navigate(-1)}
          className="flex items-center gap-2 text-sm font-medium text-blue-600 hover:text-blue-800"
        >
          <ArrowLeftIcon className="h-5 w-5" />
          Regresar
        </button>
      </div>
      
      <Etiquetas eventData={eventData} />

      <div className="w-full flex flex-col lg:flex-row gap-8 p-6 max-w-6xl mx-auto">
        {/* Contenido principal (izquierda en desktop) */}
        <div className="w-full lg:w-1/2 lg:pr-8">
          <h1 className="text-2xl font-bold mb-4">Descripción</h1>
          <p className="text-md whitespace-pre-line mb-6">
            {eventData.description}
          </p>

          <hr className="w-full border-t border-gray-300 my-4" />

          <h1 className="text-2xl font-bold mb-4">Información</h1>
          <div className="grid grid-cols-2 gap-4 mb-6">
            <div>
              <p className="font-semibold">Precio:</p>
              <p>
                ${eventData.minPrice} - ${eventData.maxPrice}
              </p>
            </div>
            <div>
              <p className="font-semibold">Teléfono:</p>
              <p>{eventData.phoneNumber}</p>
            </div>
            <div>
              <p className="font-semibold">Dirección:</p>
              <p>
                {eventData.street} {eventData.streetNumber}, {eventData.county}
              </p>
            </div>
            <div>
              <p className="font-semibold">Calificación:</p>
              <p>
                {(eventData.reviewSum / eventData.reviewCount).toFixed(1)} (
                {eventData.reviewCount} reseñas)
              </p>
            </div>
          </div>

          <h1 className="text-2xl font-bold mb-4">Contacto</h1>
          <div className="flex flex-wrap gap-4 mb-6">
            {eventData.instagram && (
              <a
                href={`https://instagram.com/${eventData.instagram}`}
                target="_blank"
                rel="noopener noreferrer"
                className="flex items-center text-blue-600 hover:underline"
              >
                Instagram
              </a>
            )}
            {eventData.facebook && (
              <a
                href={
                  eventData.facebook.includes("http")
                    ? eventData.facebook
                    : `https://${eventData.facebook}`
                }
                target="_blank"
                rel="noopener noreferrer"
                className="flex items-center text-blue-600 hover:underline"
              >
                Facebook
              </a>
            )}
            {eventData.whatsapp && (
              <a
                href={`https://wa.me/${eventData.whatsapp}`}
                target="_blank"
                rel="noopener noreferrer"
                className="flex items-center text-green-600 hover:underline"
              >
                WhatsApp
              </a>
            )}
          </div>

          <h1 className="text-2xl font-bold mb-4">Compra de boletos</h1>
          <div className="w-full flex justify-center items-center gap-6 p-4 flex-wrap">
            <CardTIckets
              fecha="27 de marzo de 2025 · Ensenada, Baja California"
              logo="https://cdn.brandfetch.io/idVogTb1a1/w/800/h/800/theme/dark/icon.png"
              price={eventData.minPrice}
            />
          </div>
        </div>

        <div className="w-full lg:w-1/2 lg:sticky lg:top-4">
          <CardEventUbi
            street={eventData.street}
            streetNumber={eventData.streetNumber}
            county={eventData.county}
            city={eventData.city}
            country={eventData.country}
            cp={eventData.cp}
          />
        </div>
      </div>

      <Footer></Footer>

    </div>
  );
};

export default EventPage;
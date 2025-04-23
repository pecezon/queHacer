import React, { useState } from "react";
import Nav from "../../components/all/Nav.jsx";
import SearchBar from "../../components/all/SearchBar.jsx";
import "../../index.css";
import EnsenadaCard from "../../components/landing/EnsenadaCard.jsx";
import ReviewCard from "../../components/all/ReviewCard.jsx";
import Filtro from "../../components/event/Filtro.jsx";
import { Button, Drawer, useDisclosure } from "@heroui/react";
import { FunnelIcon } from "@heroicons/react/24/solid";
import FilterDrawer from "../../components/event/FilterDrawer.jsx";

function Events() {
  const { isOpen, onOpen, onOpenChange } = useDisclosure();

  // Datos de ejemplo con categorías añadidas
  const initialReviews = [
    {
      id: 1,
      title: "Tacos El Güero",
      description: "Los mejores tacos de Ensenada.",
      initialRating: 5,
      borderColor: "red-500",
      category: "food",
    },
    {
      id: 2,
      title: "La Cevichería",
      description: "Ceviche fresco y delicioso.",
      initialRating: 4,
      borderColor: "green-500",
      category: "food",
    },
    {
      id: 3,
      title: "Cafe Luna",
      description: "Café artesanal con ambiente tranquilo.",
      initialRating: 4,
      borderColor: "purple-500",
      category: "food",
    },
    {
      id: 4,
      title: "Mariscos El Puerto",
      description: "Excelente atención y sabor.",
      initialRating: 5,
      borderColor: "blue-500",
      category: "food",
    },
    {
      id: 5,
      title: "Concierto en el Malecón",
      description: "Gran ambiente musical frente al mar.",
      initialRating: 4,
      borderColor: "yellow-500",
      category: "music",
    },
    {
      id: 6,
      title: "Galería de Arte Local",
      description: "Exhibición de artistas regionales.",
      initialRating: 3,
      borderColor: "indigo-500",
      category: "art",
    },
  ];

  const [reviews, setReviews] = useState(initialReviews);
  const [filteredReviews, setFilteredReviews] = useState(initialReviews);

  // Manejar cambios en los filtros
  const handleFilterChange = (filters) => {
    const filtered = initialReviews.filter((review) => {
      // Si no hay categorías seleccionadas, mostrar todas (o puedes omitir este filtro)
      const categoryMatch =
        filters.categories.length === 0 ||
        filters.categories.includes(review.category);
      const ratingMatch = review.initialRating >= filters.minRating;
      return categoryMatch && ratingMatch;
    });
    setFilteredReviews(filtered);
  };

  const reviewCards = (
    <div className="flex flex-wrap gap-5 justify-center md:justify-start">
      {filteredReviews.map((r) => (
        <ReviewCard
          key={r.id}
          title={r.title}
          description={r.description}
          initialRating={r.initialRating}
          borderColor={r.borderColor}
          category={r.category}
        />
      ))}
    </div>
  );

  return (
    <div className="w-screen h-screen overflow-x-hidden">
      <Nav />
      <div className="flex justify-center items-center m-auto p-10 border-b-2 border-gray-500 w-3/4">
        <SearchBar />
      </div>

      {/* Botón de filtros visible en móvil */}
      <div className="flex justify-center md:hidden p-4">
        <Button
          onPress={onOpen}
          className="flex items-center gap-2 bg-blue-700 text-white"
        >
          <FunnelIcon className="w-5 h-5" />
          Filtros
        </Button>
      </div>

      {/* Drawer de filtros - Asegúrate de pasar handleFilterChange */}
      <FilterDrawer
        isOpen={isOpen}
        onOpenChange={onOpenChange}
        onFilterChange={handleFilterChange}
      />

      <div className="hidden md:flex flex-row w-11/12 m-auto justify-center">
        {/* Panel de filtros en desktop */}
        <div className="w-1/4 min-w-52">
          <Filtro onFilterChange={handleFilterChange} />
        </div>

        <div className="flex-1 p-4">
          {filteredReviews.length > 0 ? (
            reviewCards
          ) : (
            <div className="text-center py-10">
              <p className="text-gray-500">
                No hay reseñas que coincidan con los filtros seleccionados.
              </p>
              <Button
                onPress={() =>
                  handleFilterChange({
                    categories: ["food", "music", "art"],
                    minRating: 0,
                  })
                }
                className="mt-4 text-blue-600 hover:text-blue-800"
                variant="ghost"
              >
                Mostrar todas las reseñas
              </Button>
            </div>
          )}
        </div>
      </div>

      {/* Versión móvil */}
      <div className="md:hidden p-4">
        {filteredReviews.length > 0 ? (
          reviewCards
        ) : (
          <div className="text-center py-10">
            <p className="text-gray-500">
              No hay reseñas que coincidan con los filtros.
            </p>
            <Button
              onPress={() =>
                handleFilterChange({
                  categories: ["food", "music", "art"],
                  minRating: 0,
                })
              }
              className="mt-4"
              variant="ghost"
            >
              Mostrar todas
            </Button>
          </div>
        )}
      </div>
    </div>
  );
}

export default Events;

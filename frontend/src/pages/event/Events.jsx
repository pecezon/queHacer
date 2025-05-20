import Nav from "../../components/all/Nav.jsx";
import SearchBar from "../../components/all/SearchBar.jsx";
import "../../index.css";
import EnsenadaCard from "../../components/landing/EnsenadaCard.jsx";
import ReviewCard from "../../components/all/ReviewCard.jsx";
import Filtro from "../../components/event/Filtro.jsx";
import { Button, Drawer, useDisclosure } from "@heroui/react";
import { FunnelIcon } from "@heroicons/react/24/solid";
import FilterDrawer from "../../components/event/FilterDrawer.jsx";
import { useEvents } from "../../context/EventContext.jsx";

function Events() {
  const { isOpen, onOpen, onOpenChange } = useDisclosure();
  const { filteredEvents, loading, error, handleFilterChange } = useEvents();

const eventCards = (
  <div className="flex flex-wrap gap-5 justify-center md:justify-start">
    {filteredEvents.map((event) => (
      <ReviewCard
        key={event.id}
        id={event.id}
        title={event.name}
        description={event.description}
        reviewCount={event.cantReviews} 
        reviewSum={event.sumReviews}
        borderColor="blue-700"
        category={"event"} 
        imageUrl={event.mainImage || "https://via.placeholder.com/300"} 
        minPrice={event.minPrice}
        maxPrice={event.maxPrice}
        location={`${event.street || ''} ${event.streetNumber || ''}, ${event.county}`}
        phoneNumber={event.phone}
      />
    ))}
  </div>
);


  if (loading) {
    return <div>Cargando...</div>;
  }

  if (error) {
    return <div>ERROR</div>;
  }

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
          {filteredEvents.length > 0 ? (
            eventCards
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
        {filteredEvents.length > 0 ? (
          eventCards
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

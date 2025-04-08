import React from "react";
import Nav from "../../components/all/Nav.jsx";
import SearchBar from "../../components/all/SearchBar.jsx";
import "../../index.css";
import EnsenadaCard from "../../components/landing/EnsenadaCard.jsx";
import ReviewCard from "../../components/all/ReviewCard.jsx";
import Filtro from "../../components/event/Filtro.jsx";

function Events() {
  return (
    <div className="w-screen h-screen overflow-x-hidden justify-center">
      <Nav />
      <div className="w-full h-full grid grid-cols-5 grid-rows-5 gap-2 pt-5 pl-5 pr-5">
        <div className="row-span-1 row-start-1 col-span-5 md:row-span-5 md:row-start-1 md:col-span-1 border-cyan-900 border-8">
          <Filtro />
        </div>
        <div className="row-span-4 row-start-2 col-span-5 md:row-span-4  md:row-start-1 border-orange-600 border-8">
          <div className="flex flex-wrap flex-1 justify-center gap-5 pt-2.5">
            <ReviewCard
              title="Ramiro gei"
              description="Muy buena calidad de gei y frio sfdksjfksj sfjslkfsjlk sfsk jsjfs"
              initialRating={4.5}
              interactive={false}
            />
            <ReviewCard
              title="Reseña de ramiro gei"
              description="le encanta el ramiro gei"
              initialRating={1}
              interactive={false}
            />
          </div>
        </div>
      </div>
    </div>
  );
}

export default Events;

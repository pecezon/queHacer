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
      <div className="w-full h-full flex flex-wrap">
        <div className="border-orange-500 flex object-cover">
          <Filtro />
        </div>
        <div className="border-blue-600 flex object-cover">
          <div className="flex flex-wrap flex-1 gap-5 pt-2.5">
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
            <ReviewCard
              title="Reseña de ramiro gei"
              description="le encanta el ramiro gei"
              initialRating={1}
              interactive={false}
            />
            <ReviewCard
              title="Reseña de ramiro gei"
              description="le encanta el ramiro gei"
              initialRating={1}
              interactive={false}
            />
            <ReviewCard
              title="Reseña de ramiro gei"
              description="le encanta el ramiro gei"
              initialRating={1}
              interactive={false}
            />
            <ReviewCard
              title="Reseña de ramiro gei"
              description="le encanta el ramiro gei"
              initialRating={1}
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

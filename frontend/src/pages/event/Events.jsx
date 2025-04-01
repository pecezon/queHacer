import React from "react";
import Nav from "../../components/all/Nav.jsx";
import SearchBar from "../../components/all/SearchBar.jsx";
import "../../index.css";
import EnsenadaCard from "../../components/landing/EnsenadaCard.jsx";

function Events() {
  return (
    <div className="w-screen h-screen overflow-x-hidden justify-center">
      <Nav />
      <div className="w-full h-full grid grid-cols-5 grid-rows-5 gap-2 pt-10 pl-10 pr-10">
        <div className="row-span-4 row-start-1 border-cyan-900 border-8">
          2
        </div>
        <div className="col-span-4 row-span-4 row-start-1 border-orange-600 border-8">
          3
        </div>
      </div>
    </div>
  );
}

export default Events;

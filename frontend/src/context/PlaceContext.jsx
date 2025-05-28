import React, { createContext, useContext, useState, useEffect } from "react";

const PlaceContext = createContext();

export function PlaceProvider({ children }) {
  const [places, setPlaces] = useState([]);
  const [filteredPlaces, setFilteredPlaces] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchPlaces = async () => {
      try {
        const response = await fetch("./places.json", {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        const data = await response.json();
        setPlaces(data);
        setFilteredPlaces(data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchPlaces();
  }, []);

  const handleFilterChange = (filters) => {
    const filtered = places.filter((place) => {
      const cityMatch =
        !filters.city ||
        place.city.toLowerCase().includes(filters.city.toLowerCase());
      const nameMatch =
        !filters.name ||
        place.name.toLowerCase().includes(filters.name.toLowerCase());
      return cityMatch && nameMatch;
    });
    setFilteredPlaces(filtered);
  };

  const getPlaceById = (id) => {
    return places.find((place) => place.id === parseInt(id));
  };

  return (
    <PlaceContext.Provider
      value={{
        places,
        filteredPlaces,
        loading,
        error,
        handleFilterChange,
        getPlaceById,
      }}
    >
      {children}
    </PlaceContext.Provider>
  );
}

export function usePlaces() {
  return useContext(PlaceContext);
}

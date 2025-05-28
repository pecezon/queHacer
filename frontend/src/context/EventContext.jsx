import React, { createContext, useContext, useState, useEffect } from "react";

const EventContext = createContext();

export function EventProvider({ children }) {
  const [events, setEvents] = useState([]);
  const [filteredEvents, setFilteredEvents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchEvents = async () => {
      try {
        const response = await fetch("./events.json", {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        const data = await response.json();
        setEvents(data);
        setFilteredEvents(data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchEvents();
  }, []);

  const handleFilterChange = (filters) => {
    const filtered = events.filter((event) => {
      const cityMatch =
        !filters.city ||
        event.city.toLowerCase().includes(filters.city.toLowerCase());
      const nameMatch =
        !filters.name ||
        event.name.toLowerCase().includes(filters.name.toLowerCase());
      return cityMatch && nameMatch;
    });
    setFilteredEvents(filtered);
  };

  const getEventById = (id) => {
    return events.find((event) => event.id === parseInt(id));
  };

  return (
    <EventContext.Provider
      value={{
        events,
        filteredEvents,
        loading,
        error,
        handleFilterChange,
        getEventById,
      }}
    >
      {children}
    </EventContext.Provider>
  );
}

export function useEvents() {
  return useContext(EventContext);
}

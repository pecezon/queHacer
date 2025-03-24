import React from "react";
import { useParams } from "react-router-dom";

const EventPage = () => {
  const { id } = useParams();
  return (
    <div>
      <h1>Event Page number {id}</h1>
      <p>Welcome to the event page!</p>
    </div>
  );
};

export default EventPage;

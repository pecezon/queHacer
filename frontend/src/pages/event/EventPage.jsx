import React from "react";
import { useParams } from "react-router-dom";
import { Nav } from "../../components/all/Nav";

const EventPage = () => {
  const { id } = useParams();
  return (
    <div>
      <Nav></Nav>
      <div>
        <h1>Event Page number {id}</h1>
        <p>Welcome to the event page Ramiro gei!</p>
      </div>
    </div>
  );
};

export default EventPage;

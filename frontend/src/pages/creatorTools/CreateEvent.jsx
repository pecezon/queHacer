import React from "react";

const CreateEvent = () => {
  return (
    <div>
      <h1>Create Event</h1>
      <form>
        <div>
          <label htmlFor="eventName">Event Name:</label>
          <input type="text" id="eventName" name="eventName" />
        </div>
        <div>
          <label htmlFor="eventDate">Event Date:</label>
          <input type="date" id="eventDate" name="eventDate" />
        </div>
        <div>
          <label htmlFor="eventDescription">Event Description:</label>
          <textarea id="eventDescription" name="eventDescription"></textarea>
        </div>
        <button type="submit">Create Event</button>
      </form>
    </div>
  );
};

export default CreateEvent;

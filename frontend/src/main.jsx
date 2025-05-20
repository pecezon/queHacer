import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";

//Hero UI
import { HeroUIProvider } from "@heroui/react";

//Import the router
import { createBrowserRouter, RouterProvider } from "react-router-dom";

//Import the pages
import LogIn from "./pages/auth/LogIn.jsx";
import SignUp from "./pages/auth/SignUp.jsx";
import Validate from "./pages/auth/Validate.jsx";
import Landing from "./pages/landing/Landing.jsx";
import NotFound from "./pages/error/NotFound.jsx";
import EventPage from "./pages/event/EventPage.jsx";
import CreateEvent from "./pages/creatorTools/CreateEvent.jsx";
import EventDashboard from "./pages/admin/EventDashboard.jsx";
import Events from "./pages/event/Events.jsx";
import User from "./pages/user/User.jsx";
import { UserProvider } from "./pages/user/UserProvider.jsx";
import { AuthProvider } from "./context/AuthContext.jsx";
import { ReviewProvider } from "./context/EventContext.jsx";

const router = createBrowserRouter([
  //Main Page Route
  { path: "/", element: <Landing /> },

  //Routes for the auth process
  { path: "/login", element: <LogIn /> },
  { path: "/signup", element: <SignUp /> },
  { path: "/validate", element: <Validate /> },

  //Routes for the event process
  { path: "/event/:id", element: <EventPage /> },
  { path: "/events", element: <Events /> },

  //Routes for the creator tools
  { path: "/createEvent", element: <CreateEvent /> },

  //Routes for Admin
  { path: "/eventDashboard", element: <EventDashboard /> },

  //Routes for User
  { path: "/userPage", element: <User /> },

  //Routes to handle errors
  { path: "*", element: <NotFound /> },
]);

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <HeroUIProvider>
      <AuthProvider>
        <ReviewProvider>
          <RouterProvider
            router={router}
            className="light text-foreground bg-background"
          />          
        </ReviewProvider>
      </AuthProvider>
    </HeroUIProvider>
  </StrictMode>
);

import { useState } from "react";
import User from "./User";
import Nav from "./components/all/Nav";

function App() {
  const [userData, setUserData] = useState({
    name: "Ramiro Gei",
    email: "ramirogei@gmail.com",
    phone: "123456789",
    validID: "xxdfsdfsdf",
    address: "Calle 3, Ensenada",
    picture: "/images/cevicheria.png",
  });

  return (
    <>
      <Nav userData={userData} />
      <User userData={userData} setUserData={setUserData} />
    </>
  );
}

export default App;
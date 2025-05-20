import React, { createContext, useContext, useState } from 'react'

const UserContext = createContext();

export function UserProvider({children}) {

    const [ userData, setUserData ] = useState({
        name: "Ramiro Gei",
        email: "ramiro.gei@gmail.com",
        phone: "656-9089-9087",
        validID: "ret45353",
        address: "calle4, Ensenada",
        picture: "/images/cevicheria.png",
    });
  return (
    <UserContext.Provider value={{ userData, setUserData }}>
        {children}
    </UserContext.Provider>
  )
}

export function useUser(){
    return useContext(UserContext);
}
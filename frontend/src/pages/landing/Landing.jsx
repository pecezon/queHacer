import React from "react";
import { User } from "@heroui/react";
import { ThemeSwitcher } from "../../components/ThemeSwitcher";
import { Flex, Text } from "./../../utils/ChakraComponents";
import Nav from "../../components/all/Nav";
import SearchBar from "../../components/all/SearchBar";
import EnsenadaCard from "../../components/landing/EnsenadaCard";

const Landing = () => {
  return (
    <div>
      <div>
        <Nav />
      </div>
      <div className="pl-2 pr-2">
        {/* Search bar */}
        <div className="flex justify-center items-center pt-10 w-full">
          <SearchBar />
        </div>

        {/* Card de contenido */}
        <div className="flex justify-center items-center pt-10 w-full">
          <EnsenadaCard />
        </div>
      </div>
    </div>
  );
};

export default Landing;

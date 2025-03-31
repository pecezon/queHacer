import React from "react";
import { User } from "@heroui/react";
import { ThemeSwitcher } from "../../components/ThemeSwitcher";
import { Flex, Text } from "./../../utils/ChakraComponents";
import Nav from '../../components/all/Nav'

const Landing = () => {
  return (
    <>
    <Nav/>
      <User
        avatarProps={{
          src: "https://i.pravatar.cc/150?u=a04258114e29026702d",
        }}
        description="Product Designer"
        name="Jane Doe"
      />
      <ThemeSwitcher />
      <Flex
        align="center"
        justify="center"
        padding="40px"
        direction="column"
        className="border-4 border-black"
      >
        <Text>Arriba el america, el equipo más grande de México. 🦅</Text>
        <Text>Que chinguen a su madre las chivas. 🐐</Text>
      </Flex>
    </>
  );
};

export default Landing;

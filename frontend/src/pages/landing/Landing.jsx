import React from "react";
import { User } from "@heroui/react";
import { ThemeSwitcher } from "../../components/ThemeSwitcher";
import { Flex, Text } from "./../../utils/ChakraComponents";
import Nav from "../../components/all/Nav";
import SearchBar from "../../components/all/SearchBar";
import EnsenadaCard from "../../components/landing/EnsenadaCard";
import CustomCard from "../../components/landing/customCard";
import ReseniaCard from "../../components/landing/reseniaCard";
import Footer from "../../components/all/Footer";
import { useState } from "react";

import {
  Drawer,
  DrawerContent,
  DrawerHeader,
  DrawerBody,
  DrawerFooter,
  Button,
  useDisclosure,
} from "@heroui/react";

const Landing = () => {
  const { isOpen, onOpen, onOpenChange } = useDisclosure();

  const [ciudad, setCiudad] = useState("");
  const [loading, setLoading] = useState(false);
  const [respuesta, setRespuesta] = useState("");

  const askIA = async () => {
    if (!ciudad) return alert("Pon una ciudad, por favor");

    setLoading(true);

    try {
      const res = await fetch("http://localhost:8080/ai/get-recommendation", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ ciudad }), // objeto con la ciudad
      });

      if (!res.ok) throw new Error("Error en la respuesta de la API");

      const data = await res.text();
      setLoading(false); // o .json() si responde JSON
      setRespuesta(data);
      onOpen();
    } catch (error) {
      setRespuesta("Error al conectar con la API");
      console.error(error);
    }
  };

  const places = [
    {
      image:
        "https://scontent-lax3-2.xx.fbcdn.net/v/t39.30808-6/482201782_1036984315126739_4374448235872347733_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=127cfc&_nc_eui2=AeGcLv4a_Jzpe9Cq4Yakosw_zvJpJRgzIKbO8mklGDMgpiFrrtypYrKKeIRlMxOhvEunEFi2rI8-vPRF9B7m9Rdm&_nc_ohc=zELssXK-snkQ7kNvwFLyuj3&_nc_oc=AdmQygZj14vTQGWRWsqzw0mHArRgTLMw4X8_czKCAmRlxcJza8Px1UFwllrxIrVQVGg&_nc_zt=23&_nc_ht=scontent-lax3-2.xx&_nc_gid=kdd7OQKrlnOCpYKkwb6wGQ&oh=00_AfIiYaOyA7f5wm7HJQ-9qAbs4x0nz9kkiznmy2rZgtEehg&oe=68215EFF",
      title: "Parque Revolución",
      description:
        "Un espacio tranquilo en el centro de la ciudad con áreas verdes, bancas y una atmósfera relajada, ideal para pasear y observar la vida local.",
    },
    {
      image:
        "https://www.alltrails.com/_next/image?url=https%3A%2F%2Fimages.alltrails.com%2FeyJidWNrZXQiOiJhc3NldHMuYWxsdHJhaWxzLmNvbSIsImtleSI6InVwbG9hZHMvcGhvdG8vaW1hZ2UvNDQ4OTYxOTkvNDNjNzUyYzk4MWI5NTFhZjZjMmIyZjU0YjkxNjUzNmEuanBnIiwiZWRpdHMiOnsidG9Gb3JtYXQiOiJ3ZWJwIiwicmVzaXplIjp7IndpZHRoIjoxMDgwLCJoZWlnaHQiOjcwMCwiZml0IjoiY292ZXIifSwicm90YXRlIjpudWxsLCJqcGVnIjp7InRyZWxsaXNRdWFudGlzYXRpb24iOnRydWUsIm92ZXJzaG9vdERlcmluZ2luZyI6dHJ1ZSwib3B0aW1pc2VTY2FucyI6dHJ1ZSwicXVhbnRpc2F0aW9uVGFibGUiOjN9fX0%3D&w=3840&q=75",
      title: "Cañon de Doña Petra",
      description:
        "Un sendero natural en las afueras de la ciudad, perfecto para caminatas, ciclismo de montaña y contacto con la naturaleza sin multitudes.",
    },
    {
      image:
        "https://novarealtors.com.mx/wp-content/uploads/2020/02/83873288_121005716114469_2299719524015931392_n.jpg",
      title: "Playa Pacífica",
      description:
        "Una playa menos concurrida en comparación con otras, ideal para disfrutar del atardecer, caminar por la arena o simplemente relajarse con el sonido del mar.",
    },
  ];

  const reviews = [
    {
      restaurant: "Kulichi Roll",
      comment:
        "Excelente comida, mejor el restaurante de sushi de Ensenada, ya incluso me conocen de tanto que voy.",
      author: "Ramiro Cruz",
      date: "11/09/2001",
      avatar: "https://i.pravatar.cc/150?img=1",
      rating: 5,
    },
    {
      restaurant: "Mariscos La Ambar",
      comment:
        "Buenos mariscos, muy rico el chef, solo que me quisieron cobrar $300 pesos de propina, bien muertos de hambre.",
      author: "Juan Pablo",
      date: "02/04/2022",
      avatar: "https://i.pravatar.cc/150?img=2",
      rating: 2.5,
    },
    {
      restaurant: "Buffet de Alitas",
      comment:
        "Super barato, puedo comer todo lo que quiera por 2 horas, solo que mis amigos estaban vomitando.",
      author: "Cristobal Coronado",
      date: "10/04/2023",
      avatar: "https://i.pravatar.cc/150?img=3",
      rating: 4,
    },
  ];

  return (
    <>
      <Drawer isOpen={isOpen} onOpenChange={onOpenChange}>
        <DrawerContent>
          {(onClose) => (
            <>
              <DrawerHeader className="flex flex-col gap-1">
                {loading ? (
                  <Flex alignItems="center" justifyContent="center">
                    <Text>
                      La inteligencia artificial esta generando una respuesta...
                    </Text>
                  </Flex>
                ) : (
                  <Flex alignItems="center" justifyContent="space-between">
                    <Text>La inteligencia artificial sugiere</Text>
                  </Flex>
                )}
              </DrawerHeader>
              <DrawerBody>
                {loading ? (
                  <Flex alignItems="center" justifyContent="center">
                    <User className="animate-spin" />
                  </Flex>
                ) : (
                  <Text>{respuesta}</Text>
                )}
              </DrawerBody>
              <DrawerFooter>
                <Button color="danger" variant="light" onPress={onClose}>
                  Close
                </Button>
              </DrawerFooter>
            </>
          )}
        </DrawerContent>
      </Drawer>
      <div className="min-h-screen bg-gray-50">
        <Nav />

        <main className="container mx-auto px-4 sm:px-6 lg:px-8 py-8 flex flex-col items-center">
          <div className="flex justify-center items-start gap-2 mb-8 sm:mb-12 w-full">
            <SearchBar setCiudad={setCiudad} />
            <Button onPress={askIA} isLoading={loading}>
              Ask IA
            </Button>
          </div>

          <div className="mb-8 sm:mb-16 w-full flex justify-center">
            <EnsenadaCard />
          </div>

          <section className="mb-12 sm:mb-20 w-full">
            <h2 className="text-2xl font-bold mb-6 text-center">
              Lugares destacados
            </h2>
            <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-8 justify-items-center">
              {places.map((place, index) => (
                <CustomCard
                  key={index}
                  image={place.image}
                  title={place.title}
                  description={place.description}
                  className="mx-auto"
                />
              ))}
            </div>
          </section>

          <section className="mb-12 sm:mb-20 w-full">
            <h2 className="text-2xl font-bold mb-6 text-center">
              Últimas reseñas
            </h2>
            <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-8 place-items-center">
              {reviews.map((review, index) => (
                <ReseniaCard
                  key={index}
                  restaurant={review.restaurant}
                  comment={review.comment}
                  author={review.author}
                  date={review.date}
                  avatar={review.avatar}
                  rating={review.rating}
                  className="mx-auto"
                />
              ))}
            </div>
          </section>
        </main>
        <Footer></Footer>
      </div>
    </>
  );
};

export default Landing;

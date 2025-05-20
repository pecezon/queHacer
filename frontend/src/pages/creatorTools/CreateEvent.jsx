import React, { useState } from "react";
import Nav from "../../components/all/Nav";
import Footer from "../../components/all/Footer";
import { Input, Button, Textarea, Chip } from "@heroui/react";

const categoriasIniciales = [
  "Comida",
  "Música",
  "Arte",
  "Deporte",
  "Tecnología",
  "Moda",
  "Cultura",
  "Infantil",
];

const CreateEvent = () => {
  const [categorias, setCategorias] = useState(categoriasIniciales);

  const handleEliminarCategoria = (categoria) => {
    const nuevasCategorias = categorias.filter((c) => c !== categoria);
    setCategorias(
      nuevasCategorias.length > 0 ? nuevasCategorias : categoriasIniciales
    );
  };

  return (
    <div className="min-h-screen w-screen bg-gray-50 flex flex-col">
      <Nav />

      <main className="flex flex-1 justify-center items-center px-4 py-12">
        <div className="flex flex-col justify-center items-center bg-white p-8 rounded-lg shadow-2xl w-full max-w-lg gap-6">
          <Input
            isRequired
            label="Nombre del lugar"
            placeholder="Ej. Kulichi Roll"
            type="text"
          />

          <Input
            isRequired
            label="Dirección"
            placeholder="Ej. Padre Kino Norte 794"
            type="text"
          />

          <Input isRequired label="Imagen Banner (URL)" type="url" />

          <Input isRequired label="Imagen (URL)" type="url" />

          <div className="w-full flex flex-col gap-1">
            <div className="flex gap-4">
              <Input
                isRequired
                label="Mínimo"
                placeholder="Mínimo"
                type="number"
                min={0}
                className="w-1/2"
              />
              <Input
                isRequired
                label="Máximo"
                placeholder="Máximo"
                type="number"
                min={0}
                className="w-1/2"
              />
            </div>
          </div>

          <Textarea
            isRequired
            label="Descripción"
            placeholder="Escribe una breve descripción del lugar, tipo de comida, ambiente, etc."
            minRows={3}
          />

          <div className="w-full flex flex-col gap-1">
            <div className="w-full bg-zinc-100 rounded-xl px-3 pt-2 pb-1.5">
              <label className="text-xs font-normal text-gray-700">
                Categorías del evento
              </label>
              <div className="flex flex-wrap gap-2 mt-2 mb-2">
                {categorias.map((categoria, index) => (
                  <Chip
                    key={index}
                    variant="flat"
                    color="primary"
                    onClose={() => handleEliminarCategoria(categoria)}
                  >
                    {categoria}
                  </Chip>
                ))}
              </div>
            </div>
          </div>

          <Button color="primary" variant="flat" className="w-full mt-4">
            Enviar
          </Button>
        </div>
      </main>

      <Footer />
    </div>
  );
};

export default CreateEvent;

import {
  Button,
  Drawer,
  DrawerBody,
  DrawerContent,
  DrawerFooter,
  DrawerHeader,
} from "@heroui/react";
import React from "react";
import Filtro from "./Filtro";

function FilterDrawer({ isOpen, onOpenChange }) {
  return (
    <Drawer size={"xs"} isOpen={isOpen} onOpenChange={onOpenChange} placement="left" backdrop="blur"         
    motionProps={{
        variants: {
          enter: {
            opacity: 1,
            x: 0,
            duration: 0.3,
          },
          exit: {
            x: -100,
            opacity: 0,
            duration: 0.3,
          },
        },}}>
      <DrawerContent>
        {({ onClose }) => (
          <div>
            <DrawerHeader className="flex flex-col gap-1">
              <h2 className="text-lg font-semibold">Filtros</h2>
            </DrawerHeader>
            <DrawerBody>
              <Filtro />
            </DrawerBody>
          </div>
        )}
      </DrawerContent>
    </Drawer>
  );
}

export default FilterDrawer;

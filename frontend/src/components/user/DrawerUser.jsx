import React, { useState } from "react";
import {
  Drawer,
  DrawerContent,
  DrawerHeader,
  DrawerBody,
  DrawerFooter,
  Button,
  Input,
} from "@heroui/react";
import { useUser } from "../../pages/user/UserProvider";

function DrawerUser({ isOpen, onClose, onOpenChange}) {
  const [editingField, setEditingField] = useState(null);
  const [tempValue, setTempValue] = useState("");
  const { userData, setUserData } = useUser();

  const handleEdit = (field) => {
    setEditingField(field);
    setTempValue(userData[field]);
  };

  const handleChange = (e) => {
    setTempValue(e.target.value);
  };

  const handleSubmit = (field) => {
    setUserData({
      ...userData,
      [field]: tempValue,
    });
    setEditingField(null);
  };

  const fields = [
    { key: "name", label: "Nombre" },
    { key: "email", label: "Correo" },
    { key: "phone", label: "Telefono" },
    { key: "validID", label: "Identificacion" },
    { key: "address", label: "Direccion" },
  ];

  return (
    <Drawer
      isOpen={isOpen}
      onOpenChange={onOpenChange}
      motionProps={{
        variants: {
          enter: {
            opacity: 1,
            x: 0,
            duration: 1,
          },
          exit: {
            x: 100,
            opacity: 0,
            duration: 1,
          },
        },
      }}
    >
      <DrawerContent>
        <>
          <DrawerHeader className="flex flex-col gap-1">
            Información Personal
          </DrawerHeader>
          <DrawerBody>
            <div className="flex flex-col gap-5">
              {fields.map(({ key, label }) => (
                <div key={key} className="flex flex-row gap-5 justify-center items-center">
                  <Input
                    isDisabled={editingField !== key}
                    className="max-w-xs"
                    value={editingField === key ? tempValue : userData[key]}
                    onChange={editingField === key ? handleChange : undefined}
                    label={label}
                    type="text"
                  />
                  {editingField === key ? (
                    <Button onClick={() => handleSubmit(key)}>Submit</Button>
                  ) : (
                    <Button onClick={() => handleEdit(key)}>Edit</Button>
                  )}
                </div>
              ))}
            </div>
          </DrawerBody>
          <DrawerFooter>
            <Button color="danger" variant="light" onPress={onClose}>
              Close
            </Button>
          </DrawerFooter>
        </>
      </DrawerContent>
    </Drawer>
  );
}

export default DrawerUser;
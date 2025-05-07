import React from "react";
import Nav from "../../components/all/Nav.jsx";
import {
  Avatar,
  Divider,
  Textarea,
  Button,
  Input,
  useDisclosure,
  Drawer,
  DrawerContent,
  DrawerHeader,
  DrawerBody,
  DrawerFooter,
} from "@heroui/react";
import DrawerUser from "../../components/user/DrawerUser.jsx";
import { useUser } from "./UserProvider.jsx";

function User() {
  const { userData, setUserData } = useUser();
  const { isOpen, onOpen, onOpenChange, onClose } = useDisclosure();
  return (
    <div className="w-screen min-h-screen bg-gray-50 overflow-x-hidden">
      <Nav />
      <div className="w-11/12 max-w-4xl mx-auto py-8">
        <div className="w-full p-6 bg-white rounded-2xl shadow-2xl">
          <div className="flex flex-col md:flex-row items-center gap-6 mb-8">
            <Avatar
              className="w-32 h-32 md:w-40 md:h-40 transition-transform hover:scale-105 border-4 border-blue-100"
              src={userData.picture}
            />
            <div className="text-center md:text-left">
              <h1 className="text-2xl md:text-3xl font-bold text-gray-800 dark:text-white">
                {userData.name}
              </h1>
              <p className="text-gray-600 dark:text-gray-300 mt-2">
                {userData.email}
              </p>
              <Button className="mt-4 text-black" onPress={onOpen}>
                Editar Perfil
              </Button>
            </div>

            <div className="space-y-6">
              <Divider className="my-6 border-gray-200 dark:border-gray-700" />

              <h3 className="text-sm font-semibold text-gray-500 uppercase tracking-wider text-center">
                Información Personal
              </h3>

              <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                <div className="bg-white dark:bg-gray-800 p-6 rounded-lg shadow-sm border border-gray-100 dark:border-gray-700">
                  <div className="space-y-4">
                    <div>
                      <h3 className="text-lg font-semibold text-gray-800 dark:text-gray-200">
                        Teléfono
                      </h3>
                      <p className="text-gray-600 dark:text-gray-400 mt-1">
                        {userData.phone || "No especificado"}
                      </p>
                    </div>

                    <div>
                      <h3 className="text-lg font-semibold text-gray-800 dark:text-gray-200">
                        Dirección
                      </h3>
                      <p className="text-gray-600 dark:text-gray-400 mt-1">
                        {userData.address || "No especificada"}
                      </p>
                    </div>
                  </div>
                </div>

                <div className="bg-white dark:bg-gray-800 p-6 rounded-lg shadow-sm border border-gray-100 dark:border-gray-700">
                  <h3 className="text-lg font-semibold text-gray-800 dark:text-gray-200">
                    Identificación
                  </h3>
                  <p className="text-gray-600 dark:text-gray-400 mt-2">
                    {userData.validID || "No especificada"}
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <DrawerUser
        isOpen={isOpen}
        onClose={onClose}
        onOpenChange={onOpenChange}
        userData={userData}
        setUserData={setUserData}
      />
    </div>
  );
}

export default User;

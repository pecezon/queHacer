import React, { useState } from "react";
import Nav from "../../components/all/Nav.jsx";
import {
  Avatar,
  Divider,
  Button,
  Input,
  useDisclosure,
  Modal,
  ModalContent,
  ModalHeader,
  ModalBody,
  ModalFooter,
  Select,
  SelectItem
} from "@heroui/react";
import { useAuth } from "../../context/AuthContext.jsx";
import {
  PencilIcon,
  CameraIcon,
  UserCircleIcon,
  PhoneIcon,
  HomeIcon,
  IdentificationIcon,
  EnvelopeIcon,
  CheckIcon,
  XMarkIcon,
  ArrowLeftIcon
} from "@heroicons/react/24/outline";

function User() {
  const { user, logout, updateUser } = useAuth();
  const { isOpen, onOpen, onOpenChange, onClose } = useDisclosure();
  const [isEditing, setIsEditing] = useState(false);
  const [editedUser, setEditedUser] = useState({ ...user });
  const [isSaving, setIsSaving] = useState(false);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setEditedUser(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSave = async () => {
    setIsSaving(true);
    try {
      await updateUser(editedUser);
      setIsEditing(false);
    } catch (error) {
      console.error("Error updating user:", error);
    } finally {
      setIsSaving(false);
    }
  };

  const handleCancel = () => {
    setEditedUser({ ...user });
    setIsEditing(false);
  };

  return (
    <div className="w-screen min-h-screen bg-gray-50 overflow-x-hidden">
      <Nav />
      <div className="w-11/12 max-w-4xl mx-auto py-8">
        <div className="w-full p-6 bg-white rounded-2xl shadow-2xl">
          {/* Header section with avatar and basic info */}
          <div className="flex flex-col md:flex-row items-center gap-6 mb-8">
            <div className="relative group">
              <Avatar
                className="w-32 h-32 md:w-40 md:h-40 transition-transform hover:scale-105 border-4 border-blue-100"
                src={user.picture}
              />
              {isEditing && (
                <button 
                  className="absolute bottom-0 right-0 bg-blue-500 text-white p-2 rounded-full opacity-0 group-hover:opacity-100 transition-opacity"
                  onClick={() => document.getElementById('pictureInput').click()}
                >
                  <CameraIcon className="h-5 w-5" />
                  <input 
                    id="pictureInput" 
                    type="file" 
                    className="hidden" 
                    accept="image/*"
                    onChange={(e) => {
                      const file = e.target.files[0];
                      if (file) {
                        const reader = new FileReader();
                        reader.onload = (event) => {
                          setEditedUser(prev => ({
                            ...prev,
                            picture: event.target.result
                          }));
                        };
                        reader.readAsDataURL(file);
                      }
                    }}
                  />
                </button>
              )}
            </div>
            
            <div className="text-center md:text-left">
              {isEditing ? (
                <div className="space-y-4">
                  <div className="flex gap-4">
                    <Input
                      label="Nombre"
                      name="name"
                      value={editedUser.name}
                      onChange={handleInputChange}
                      startContent={<UserCircleIcon className="h-5 w-5 text-gray-400" />}
                    />
                    <Input
                      label="Apellido"
                      name="lastname"
                      value={editedUser.lastname}
                      onChange={handleInputChange}
                    />
                  </div>
                  <Input
                    label="Correo electrónico"
                    name="email"
                    type="email"
                    value={editedUser.email}
                    onChange={handleInputChange}
                    startContent={<EnvelopeIcon className="h-5 w-5 text-gray-400" />}
                  />
                </div>
              ) : (
                <>
                  <h1 className="text-2xl md:text-3xl font-bold text-gray-800">
                    {user.name} {user.lastname}
                  </h1>
                  <p className="text-gray-600 mt-2 flex items-center justify-center md:justify-start">
                    <EnvelopeIcon className="h-5 w-5 mr-2" />
                    {user.email}
                  </p>
                </>
              )}
              
              <div className="mt-4">
                {isEditing ? (
                  <div className="flex gap-2">
                    <Button 
                      color="success" 
                      onPress={handleSave}
                      isLoading={isSaving}
                      startContent={<CheckIcon className="h-5 w-5" />}
                    >
                      Guardar
                    </Button>
                    <Button 
                      color="danger" 
                      onPress={handleCancel}
                      startContent={<XMarkIcon className="h-5 w-5" />}
                    >
                      Cancelar
                    </Button>
                  </div>
                ) : (
                  <Button 
                    className="text-black" 
                    onPress={() => setIsEditing(true)}
                    startContent={<PencilIcon className="h-5 w-5" />}
                  >
                    Editar Perfil
                  </Button>
                )}
              </div>
            </div>
          </div>

          <Divider className="my-6 border-gray-200" />

          {/* Personal information section */}
          <div className="space-y-6">
            <h3 className="text-sm font-semibold text-gray-500 uppercase tracking-wider flex items-center">
              <UserCircleIcon className="h-4 w-4 mr-2" />
              Información Personal
            </h3>

            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
              <div className="bg-white p-6 rounded-lg shadow-sm border border-gray-100">
                <div className="space-y-4">
                  <div>
                    <h3 className="text-lg font-semibold text-gray-800 flex items-center">
                      <PhoneIcon className="h-5 w-5 mr-2 text-blue-500" />
                      Teléfono
                    </h3>
                    {isEditing ? (
                      <Input
                        className="mt-2"
                        name="phoneNumber"
                        value={editedUser.phoneNumber || ""}
                        onChange={handleInputChange}
                        placeholder="Ingresa tu teléfono"
                      />
                    ) : (
                      <p className="text-gray-600 mt-1">
                        {user.phoneNumber || "No especificado"}
                      </p>
                    )}
                  </div>

                  <div>
                    <h3 className="text-lg font-semibold text-gray-800 flex items-center">
                      <HomeIcon className="h-5 w-5 mr-2 text-green-500" />
                      Dirección
                    </h3>
                    {isEditing ? (
                      <Input
                        className="mt-2"
                        name="address"
                        value={editedUser.address || ""}
                        onChange={handleInputChange}
                        placeholder="Ingresa tu dirección"
                      />
                    ) : (
                      <p className="text-gray-600 mt-1">
                        {user.address || "No especificada"}
                      </p>
                    )}
                  </div>
                </div>
              </div>

              <div className="bg-white p-6 rounded-lg shadow-sm border border-gray-100">
                <h3 className="text-lg font-semibold text-gray-800 flex items-center">
                  <IdentificationIcon className="h-5 w-5 mr-2 text-purple-500" />
                  Identificación
                </h3>
                {isEditing ? (
                  <Input
                    className="mt-2"
                    name="validID"
                    value={editedUser.validID || ""}
                    onChange={handleInputChange}
                    placeholder="Ingresa tu identificación"
                  />
                ) : (
                  <p className="text-gray-600 mt-2">
                    {user.validID || "No especificada"}
                  </p>
                )}
              </div>
            </div>
          </div>

          {/* Additional sections can be added here */}
          <div className="mt-8 flex justify-end">
            <Button 
              color="danger" 
              variant="light" 
              onPress={onOpen}
              startContent={<ArrowLeftIcon className="h-5 w-5" />}
            >
              Cerrar Sesión
            </Button>
          </div>
        </div>
      </div>

      {/* Logout confirmation modal */}
      <Modal isOpen={isOpen} onOpenChange={onOpenChange}>
        <ModalContent>
          <ModalHeader className="flex flex-col gap-1">Confirmar Cierre de Sesión</ModalHeader>
          <ModalBody>
            <p>¿Estás seguro de que deseas cerrar tu sesión?</p>
          </ModalBody>
          <ModalFooter>
            <Button color="default" variant="light" onPress={onClose}>
              Cancelar
            </Button>
            <Button color="danger" onPress={logout }>
              Cerrar Sesión
            </Button>
          </ModalFooter>
        </ModalContent>
      </Modal>
    </div>
  );
}

export default User;
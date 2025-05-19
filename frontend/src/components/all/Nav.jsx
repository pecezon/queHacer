import {
  Navbar,
  NavbarBrand,
  NavbarContent,
  NavbarItem,
  NavbarMenu,
  NavbarMenuItem,
  NavbarMenuToggle,
  Link,
  DropdownItem,
  DropdownTrigger,
  Dropdown,
  DropdownMenu,
  Avatar,
  Button,
} from "@heroui/react";
import { useState } from "react";
import "../../index.css";
import { useAuth } from "../../context/AuthContext";
import { useNavigate } from "react-router-dom";
import { CogIcon } from "@heroicons/react/24/solid";
import { ArrowRightOnRectangleIcon } from "@heroicons/react/20/solid";

export default function App() {
  const { user, logout, isAuthenticated } = useAuth();
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const navigate = useNavigate();

  const menuItems = [
    { name: "Descubrir", href: "/", active: false },
    { name: "Eventos", href: "/events", active: false },
    { name: "Contacto", href: "#", active: false },
  ];

  const handleLogout = () => {
    logout();
    navigate("/");
  };

  // Avatar name fallbacks
  const getAvatarName = () => {
    if (isAuthenticated && user?.name) return user.name;
    return "Invitado";
  };

  // Avatar image fallback
  const getAvatarImage = () => {
    if (isAuthenticated && user?.picture) return user.picture;
    return undefined;
  };

  return (
    <Navbar
      className="bg-white dark:bg-gray-900 shadow-sm w-full flex justify-between items-center p-3"
      maxWidth="full"
      position="sticky"
      isMenuOpen={isMenuOpen}
      onMenuOpenChange={setIsMenuOpen}
    >
      {/* Contenido izquierdo */}
      <NavbarContent>
        <NavbarMenuToggle
          aria-label={isMenuOpen ? "Close menu" : "Open menu"}
          className="sm:hidden"
        />
        <NavbarBrand>
          <Link href="/">
            <img
              src="../images/logo-que-hacer.svg"
              alt="Logo"
              className="w-20 h-auto"
            />
          </Link>
        </NavbarBrand>
      </NavbarContent>

      {/* Menú principal */}
      <NavbarContent
        className="hidden sm:flex gap-4 justify-center"
        justify="center"
      >
        {menuItems.map((item, index) => (
          <NavbarItem key={index} isActive={item.active}>
            <Link
              color="foreground"
              href={item.href}
              className={
                item.active
                  ? "text-black font-medium"
                  : "text-gray-600 hover:text-blue-600 dark:text-gray-300 dark:hover:text-blue-400 transition-colors duration-200"
              }
            >
              {item.name}
            </Link>
          </NavbarItem>
        ))}
      </NavbarContent>

      {/* Avatar con menú desplegable */}
      <NavbarContent as="div" justify="end">
        <Dropdown placement="bottom-end">
          <DropdownTrigger>
            <Avatar
              isBordered
              as="button"
              className="transition-transform hover:scale-110 w-10 h-10 hover:shadow-md"
              color={isAuthenticated ? "primary" : "default"}
              name={getAvatarName()}
              size="sm"
              src={getAvatarImage()}
            />
          </DropdownTrigger>
          <DropdownMenu
            aria-label="User Actions"
            variant="flat"
            className="w-64 p-2"
          >
            {isAuthenticated ? (
              <>
                <DropdownItem
                  key="profile"
                  className="h-14 gap-2 px-4 py-3 border-b border-gray-100 dark:border-gray-700"
                >
                  <div className="flex flex-col">
                    <p className="font-semibold text-sm text-gray-500">
                      Sesión iniciada como
                    </p>
                    <p className="font-semibold text-blue-600 dark:text-blue-400 truncate">
                      {user.email}
                    </p>
                  </div>
                </DropdownItem>
                <DropdownItem
                  key="settings"
                  className="px-4 py-3 hover:bg-blue-50 dark:hover:bg-blue-900/20 rounded-md transition-colors"
                >
                  <Link
                    href="/userPage"
                    className="w-full flex items-center gap-2 text-gray-700 dark:text-gray-200"
                  >
                    <CogIcon className="h-5 w-5" />
                    Mi Cuenta
                  </Link>
                </DropdownItem>
                <DropdownItem
                  key="logout"
                  className="px-4 py-3 hover:bg-red-50 dark:hover:bg-red-900/20 rounded-md text-red-600 dark:text-red-400 transition-colors"
                  onClick={handleLogout}
                >
                  <Link className="w-full flex items-center gap-2 text-gray-700 dark:text-gray-200">
                    <ArrowRightOnRectangleIcon className="h-5 w-5" />
                    Cerrar Sesión
                  </Link>
                </DropdownItem>
              </>
            ) : (
              <>
                <DropdownItem
                  key="login"
                  className="px-4 py-3 hover:bg-blue-50 dark:hover:bg-blue-900/20 rounded-md transition-colors"
                >
                  <Link href="/login">
                  Iniciar Sesión
                  </Link>
                </DropdownItem>
                <DropdownItem
                  key="signup"
                  className="px-4 py-3 hover:bg-gray-50 dark:hover:bg-gray-800 rounded-md transition-colors"
                >
                  <Link href="/signup">
                  Registrarse
                  </Link>
                </DropdownItem>
              </>
            )}
          </DropdownMenu>
        </Dropdown>
      </NavbarContent>

      {/* Menú móvil */}
      <NavbarMenu className="bg-white dark:bg-gray-900 pt-8 sm:hidden">
        {menuItems.map((item, index) => (
          <NavbarMenuItem key={`${item.name}-${index}`}>
            <Link
              href={item.href}
              className={`w-full text-lg block px-4 py-2 ${
                item.active
                  ? "text-black font-medium"
                  : "text-gray-600 hover:text-blue-600 dark:text-gray-300 dark:hover:text-blue-400"
              }`}
              onClick={() => setIsMenuOpen(false)}
            >
              {item.name}
            </Link>
          </NavbarMenuItem>
        ))}
      </NavbarMenu>
    </Navbar>
  );
}

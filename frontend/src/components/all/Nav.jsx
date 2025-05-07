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
} from "@heroui/react";
import { useState } from "react";
import '../../index.css'
import { useUser } from "../../pages/user/UserProvider";

export const AcmeLogo = () => {
  return (
    <svg fill="none" height="36" viewBox="0 0 32 32" width="36">
      <path
        clipRule="evenodd"
        d="M17.6482 10.1305L15.8785 7.02583L7.02979 22.5499H10.5278L17.6482 10.1305ZM19.8798 14.0457L18.11 17.1983L19.394 19.4511H16.8453L15.1056 22.5499H24.7272L19.8798 14.0457Z"
        fill="currentColor"
        fillRule="evenodd"
      />
    </svg>
  );
};

export default function App() {
  const { userData } = useUser();
  const [isMenuOpen, setIsMenuOpen] = useState(false);

  const menuItems = [
    { name: "Descubrir", href: "/", active: false },
    { name: "Eventos", href: "/events", active: false },
    { name: "Contacto", href: "#", active: false },
  ];

  return (
    <Navbar
      className="bg-white dark:bg-gray shadow-sm w-full flex justify-between items-center p-3"
      maxWidth="full"
      position="sticky"
      isMenuOpen={isMenuOpen}
      onMenuOpenChange={setIsMenuOpen}
    >
      {/* Contenido izquierdo (logo + toggle SOLO en móvil) */}
      <NavbarContent>
        <NavbarMenuToggle
          aria-label={isMenuOpen ? "Close menu" : "Open menu"}
          className="sm:hidden" 
        />
        <NavbarBrand>
          <img src="../images/logoQueHacerEn.svg" alt="Logo" className="w-20 h-auto"/>
        </NavbarBrand>
      </NavbarContent>

      {/* Menú principal (visible en tablet y desktop - sm+) */}
      <NavbarContent className="hidden sm:flex gap-4 justify-center" justify="center">
        {menuItems.map((item, index) => (
          <NavbarItem key={index} isActive={item.active}>
            <Link
              color="foreground"
              href={item.href}
              className={
                item.active
                  ? "text-black font-medium"
                  : "text-gray-600 hover:text-secondary dark:text-gray-300 dark:hover:text-secondary transition-colors"
              }
            >
              {item.name}
            </Link>
          </NavbarItem>
        ))}
      </NavbarContent>

      {/* Contenido derecho (avatar dropdown) */}
      <NavbarContent as="div" justify="end">
        <Dropdown placement="bottom-end">
          <DropdownTrigger>
            <Avatar
              isBordered
              as="button"
              className="transition-transform hover:scale-110 w-10 h-10"
              color="secondary"
              name={userData.name}
              size="sm"
              src={userData.picture}
            />
          </DropdownTrigger>
          <DropdownMenu
            aria-label="Profile Actions"
            variant="flat"
            className="w-64"
          >
            <DropdownItem key="profile" className="h-14 gap-2">
              <p className="font-semibold">Signed in as</p>
              <p className="font-semibold text-secondary">{userData.email}</p>
            </DropdownItem>
            <DropdownItem
              key="settings"
              className="hover:bg-gray-100 dark:hover:bg-gray-800"
            >
              <Link href="/userPage">Cuenta</Link>
            </DropdownItem>
            <DropdownItem
              key="logout"
              color="danger"
              className="hover:bg-red-50 dark:hover:bg-red-900/20"
            >
              Log Out
            </DropdownItem>
          </DropdownMenu>
        </Dropdown>
      </NavbarContent>

      {/* Menú móvil (SOLO visible en móvil al hacer clic) */}
      <NavbarMenu className="bg-white dark:bg-gray pt-8 sm:hidden">
        {menuItems.map((item, index) => (
          <NavbarMenuItem key={`${item.name}-${index}`}>
            <Link
              href={item.href}
              className={`w-full text-lg ${
                item.active
                  ? "text-black font-medium"
                  : "text-gray-600 hover:text-secondary dark:text-gray-300"
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
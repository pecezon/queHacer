import React from "react";
import { Input, Button, Link } from "@heroui/react";

const LogIn = () => {
  return (
    <div className="flex justify-center items-center h-screen w-screen bg-gradient-to-r from-indigo-200 to-blue-900">
      <div className="flex flex-col justify-center items-center bg-white p-8 rounded-lg shadow-2xl w-3/4 gap-8 max-w-lg">
        <h1 className="text-4xl font-bold text-center text-black">Log In</h1>
        <Input label="Email" type="email"></Input>
        <Input label="Password" type="password"></Input>
        <Link href="/signup" className="text-xs text-right self-end">No tienes cuenta? Sign Up</Link>
        <Button color="primary" variant="flat">
          LogIn
        </Button>
      </div>
    </div>
  );
};

export default LogIn;

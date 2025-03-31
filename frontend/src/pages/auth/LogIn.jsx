import React from "react";
import { Input, Button, Form } from "@heroui/react";
import { Link } from "react-router-dom";

const LogIn = () => {
  return (
    <div className="flex justify-center items-center h-screen w-screen bg-gradient-to-r from-indigo-200 to-blue-900">
      <Form className="flex flex-col justify-center items-center bg-white p-8 rounded-3xl shadow-2xl w-3/4 gap-8 max-w-lg ">
        <h1 className="text-3xl font-bold text-center text-black md:text-4xl">
          LogIn
        </h1>
        <Input label="Email" type="email"></Input>
        <Input label="Password" type="password"></Input>
        <Button color="primary" variant="shadow" type="submit">
          LogIn
        </Button>
        <div className="text-xs text-left w-full underline">
          <Link to="/signup">
            <p>You don't have an account yet? Sign Up</p>
          </Link>
        </div>
      </Form>
    </div>
  );
};

export default LogIn;

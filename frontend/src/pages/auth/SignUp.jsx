import React from "react";
import { Input, Button, Form } from "@heroui/react";
import { Link } from "react-router-dom";

const SignUp = () => {
  return (
    <div className="flex justify-center items-center h-screen w-screen bg-gradient-to-r from-indigo-200 to-blue-900">
      <Form className="flex flex-col justify-center items-center bg-white p-8 rounded-3xl shadow-2xl w-3/4 gap-8 max-w-lg ">
        <h1 className="text-3xl font-bold text-center text-black md:text-4xl">
          SignUp
        </h1>
        <Input label="Email" type="email"></Input>
        <Input label="Name" type="text"></Input>
        <Input label="Lastname" type="text"></Input>
        <Input
          label="Phone Number"
          type="tel"
          pattern="/^\+?\d{1,3}[-.\s]?\(?\d{1,4}\)?[-.\s]?\d{3,4}[-.\s]?\d{3,4}$/"
          errorMessage="Please enter a valid phone number"
        ></Input>
        <Input label="Password" type="password"></Input>
        <Input label="Confirm your password" type="password"></Input>
        <Button color="primary" variant="shadow" type="submit">
          SignUp
        </Button>
        <div className="text-xs text-left w-full underline">
          <Link to="/login">
            <p>You already have an account? Log In</p>
          </Link>
        </div>
      </Form>
    </div>
  );
};

export default SignUp;

import { Button, Input, Link } from '@heroui/react'
import React from 'react'

function SignUp() {
  return (
    <div className="flex justify-center items-center h-screen w-screen bg-gradient-to-r from-indigo-200 to-blue-900">
    <div className="flex flex-col justify-center items-center bg-white p-8 rounded-lg shadow-2xl w-3/4 gap-8 max-w-lg">
      <h1 className="text-4xl font-bold text-center text-black">Sign Up</h1>
      <Input label="Name" placeholder="Enter your name" type='name'></Input>
      <Input label="Last Name" placeholder='Enter your last name' type='lastname'></Input>
      <Input label="Email" placeholder="Enter your email" type="email"></Input>
      <Input label="Password" placeholder="Enter your password" type="password"></Input>
      <Input label="Confirm Password" placeholder='Confirm Password' type='password'></Input>
      <Link href="/login" className="text-xs text-right self-end">Ya tienes cuenta?</Link>
      <Button color="primary" variant="flat">
        Sign Up
      </Button>
    </div>
  </div>
  )
}

export default SignUp

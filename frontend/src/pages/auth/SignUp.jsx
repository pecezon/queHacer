// SignUp.jsx
import { Button, Input, Link } from '@heroui/react';
import React, { useState } from 'react';
import { useAuth } from '../../context/AuthContext';
import { mockAuthApi } from '../../mocks/MockAuth';

function SignUp() {
  const [formData, setFormData] = useState({
    name: '',
    lastname: '',
    email: '',
    password: '',
    confirmPassword: '',
    phoneNumber: ''
  });
  const [error, setError] = useState('');
  const { login } = useAuth();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');
    
    if (formData.password !== formData.confirmPassword) {
      setError("Las contraseñas no coinciden");
      return;
    }

    try {
      const userData = {
        name: formData.name,
        lastname: formData.lastname,
        email: formData.email,
        password: formData.password,
        phoneNumber: formData.phoneNumber
      };
      
      const { user, token } = await mockAuthApi.signup(userData);
      login(user, token);
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <div className="flex justify-center items-center h-screen w-screen bg-gradient-to-r from-indigo-200 to-blue-900">
      <div className="flex flex-col justify-center items-center bg-white p-8 rounded-lg shadow-2xl w-3/4 gap-4 max-w-lg">
        <img src="../images/logoQueHacerEn.svg" alt="Logo" className="w-24 h-auto"/>
        
        {error && <div className="text-red-500 text-sm">{error}</div>}
        
        <form onSubmit={handleSubmit} className="w-full flex flex-col gap-4">
          <Input 
            label="Nombre" 
            placeholder="Ingresa tu nombre" 
            name="name"
            value={formData.name}
            onChange={handleChange}
            required
          />
          
          <Input 
            label="Apellidos" 
            placeholder="Ingresa tus apellidos" 
            name="lastname"
            value={formData.lastname}
            onChange={handleChange}
            required
          />
          
          <Input 
            label="Email" 
            placeholder="Ingresa tu email" 
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
          
          <Input 
            label="Teléfono" 
            placeholder="Ingresa tu teléfono" 
            type="tel"
            name="phoneNumber"
            value={formData.phoneNumber}
            onChange={handleChange}
            required
          />
          
          <Input 
            label="Contraseña" 
            placeholder="Ingresa tu contraseña" 
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
          
          <Input 
            label="Confirma Contraseña" 
            placeholder="Confirma tu contraseña" 
            type="password"
            name="confirmPassword"
            value={formData.confirmPassword}
            onChange={handleChange}
            required
          />
          
          <Link href="/login" className="text-xs text-right self-end">Ya tienes cuenta?</Link>
          
          <Button color="primary" variant="flat" type="submit">
            Registrarse
          </Button>
        </form>
      </div>
    </div>
  );
}

export default SignUp;
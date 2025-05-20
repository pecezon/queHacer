import React, { useState } from 'react';
import { Button, Input } from '@heroui/react';
import { Link } from '@heroui/react';
import { useAuth } from '../../context/AuthContext';
import { mockAuthApi } from '../../mocks/MockAuth';
import { useNavigate } from 'react-router-dom';

function LogIn() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const { login } = useAuth();
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');
    
    try {
      const { user, token } = await mockAuthApi.login(email, password);
      login(user, token);
      navigate('/')
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <div className="flex justify-center items-center h-screen w-screen bg-gradient-to-r from-indigo-200 to-blue-900">
      <div className="flex flex-col justify-center items-center bg-white p-8 rounded-lg shadow-2xl w-3/4 gap-8 max-w-lg">
        <img src="../images/logoQueHacerEn.svg" alt="Logo" className="w-24 h-auto"/>
        
        {error && <div className="text-red-500 text-sm">{error}</div>}
        
        <form onSubmit={handleSubmit} className="w-full flex flex-col gap-4">
          <Input 
            label="Email" 
            placeholder="Ingresa tu email" 
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
          
          <Input 
            label="Contraseña" 
            placeholder="Ingresa tu contraseña" 
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
          
          <Link href="/signup" className="text-xs text-right self-end">No tienes cuenta?</Link>
          
          <Button color="primary" variant="flat" type="submit">
            Iniciar Sesión
          </Button>
        </form>
      </div>
    </div>
  );
}

export default LogIn;
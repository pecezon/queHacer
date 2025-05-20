import React, { useState } from 'react';
import { 
  Button, 
  Input, 
  Textarea, 
  Upload,
  Message 
} from '@heroui/react';

const EditProfileDrawer = ({ userData, onSave, onClose }) => {
  const [formData, setFormData] = useState({
    name: userData.name || '',
    email: userData.email || '',
    phone: userData.phone || '',
    validID: userData.validID || '',
    address: userData.address || '',
    picture: userData.picture || null
  });

  const [isSubmitting, setIsSubmitting] = useState(false);
  const [successMessage, setSuccessMessage] = useState('');

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleFileChange = (file) => {
    setFormData(prev => ({
      ...prev,
      picture: file
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsSubmitting(true);
    
    try {
      await onSave(formData);
      setSuccessMessage('Perfil actualizado correctamente');
      setTimeout(() => setSuccessMessage(''), 3000);
    } catch (error) {
      console.error('Error al guardar:', error);
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
    <div className="p-6 w-full max-w-md mx-auto">
      <h2 className="text-2xl font-bold mb-6 text-gray-800">Editar Perfil</h2>
      
      <form onSubmit={handleSubmit} className="space-y-4">
        <div className="flex flex-col items-center mb-6">
          <Upload
            accept="image/*"
            onChange={handleFileChange}
            className="mb-3"
          >
            <div className="w-24 h-24 rounded-full bg-gray-200 flex items-center justify-center overflow-hidden border-2 border-dashed border-gray-300 hover:border-blue-500 cursor-pointer">
              {formData.picture ? (
                typeof formData.picture === 'string' ? (
                  <img 
                    src={formData.picture} 
                    alt="Profile" 
                    className="w-full h-full object-cover"
                  />
                ) : (
                  <span className="text-gray-500">Previsualización</span>
                )
              ) : (
                <span className="text-gray-500">Subir foto</span>
              )}
            </div>
          </Upload>
          <span className="text-sm text-gray-500">Haz clic para cambiar la foto</span>
        </div>

        <Input
          label="Nombre completo"
          name="name"
          value={formData.name}
          onChange={handleChange}
          required
        />

        <Input
          label="Correo electrónico"
          name="email"
          type="email"
          value={formData.email}
          onChange={handleChange}
          required
        />

        <Input
          label="Teléfono"
          name="phone"
          value={formData.phone}
          onChange={handleChange}
        />

        <Input
          label="Identificación oficial"
          name="validID"
          value={formData.validID}
          onChange={handleChange}
        />

        <Textarea
          label="Dirección"
          name="address"
          value={formData.address}
          onChange={handleChange}
          rows={3}
        />

        {successMessage && (
          <Message type="success" className="mb-4">
            {successMessage}
          </Message>
        )}

        <div className="flex justify-end space-x-3 pt-4">
          <Button 
            type="button" 
            variant="outline" 
            onClick={onClose}
            disabled={isSubmitting}
          >
            Cancelar
          </Button>
          <Button 
            type="submit" 
            loading={isSubmitting}
          >
            Guardar cambios
          </Button>
        </div>
      </form>
    </div>
  );
};

export default EditProfileDrawer;
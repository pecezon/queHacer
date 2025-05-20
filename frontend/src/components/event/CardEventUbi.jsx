import { Card, CardBody, CardHeader } from '@heroui/react'
import React from 'react'

function CardEventUbi({ street, streetNumber, county, city, country, cp }) {
  const fullAddress = `${street} ${streetNumber}, ${county}, ${city}, ${country}`;
  const encodedAddress = encodeURIComponent(fullAddress);

  const mapUrl = `https://www.google.com/maps?q=${encodedAddress}&output=embed`;

  return (
    <div className="w-full">
      <Card className="py-4">
        <CardHeader className='pb-0 pt-2 px-4 flex-col items-start'>
          <p className='text-tiny uppercase font-bold'>Ubicación</p>
          <small className='text-default-500'>Dirección completa</small>
          <h4 className='font-bold text-medium mt-2'>
            {street} {streetNumber}<br />
            Col. {county}<br />
            {city}, {country}<br />
            C.P. {cp}
          </h4>
        </CardHeader>
        <CardBody className="flex overflow-visible py-2 justify-center items-center">
          <iframe 
            src={mapUrl}
            width="100%" 
            height="400" 
            style={{ border: 0, borderRadius: '8px' }}
            allowFullScreen
            loading="lazy" 
            referrerPolicy="no-referrer-when-downgrade"
            title="Mapa de ubicación del evento"
          ></iframe>
        </CardBody>
      </Card>
    </div>
  );
}

export default CardEventUbi;

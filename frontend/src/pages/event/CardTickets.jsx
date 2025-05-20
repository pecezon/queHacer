import { Button, Card, CardBody } from '@heroui/react';
import React from 'react';

function CardTickets({ fecha, logo }) {
  return (
    <div className="w-full p-1 md:w-2/3 lg:w-2/3">
      <Card className="w-full h-full">
        <CardBody className="p-4 flex flex-col gap-4">
          <h3>{fecha}</h3>
          <Button className="w-full flex items-center gap-3 bg-white rounded-md shadow-md hover:bg-gray-100 transition px-4 py-3">
            <img
              src={logo}
              alt="Logo"
              className="w-auto h-6 rounded-full shrink-0"
            />
            <span className="text-black font-medium whitespace-nowrap">Comprar Boletos</span>
          </Button>
        </CardBody>
      </Card>
    </div>
  );
}

export default CardTickets;

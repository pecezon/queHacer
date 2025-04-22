import { Button, Card, CardBody } from '@heroui/react'
import React from 'react'

function CardTIckets() {
  return (
    <div>
      <Card>
        <CardBody>
          <h3>22 de marzo de 2025 · Ensenada, Baja California</h3>
          <Button className="flex items-center gap-2 p-2 bg-white rounded-md shadow-md hover:bg-gray-100 transition">
            <img
              src="https://cdn.brandfetch.io/idVogTb1a1/w/800/h/800/theme/dark/icon.png?c=1dxbfHSJFAPEGdCLU4o5B"
              alt="Ticketmaster Logo"
              className="w-6 h-6 rounded-full"
            />
            <span className="text-black font-medium">Comprar boletos</span>
          </Button>
        </CardBody>
      </Card>
    </div>
  )
}

export default CardTIckets

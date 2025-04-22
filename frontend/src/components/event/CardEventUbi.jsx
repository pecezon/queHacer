import { Card, CardBody, CardHeader } from '@heroui/react'
import React from 'react'

function CardEventUbi() {
  return (
    <div>
        <Card className = "py-4">
            <CardHeader className='pb-0 pt-2 px-4 flex-col items-start'>
                <p className='text-tiny uppercase font-bold'> Ubicacion</p>
                <small className='text-default-500'>Direccion</small>
                <h4 className='font-bold text-large'>Circonia 1281, Fracc. Los Encinos C.P.22819 Ensenada, Baja California</h4>
            </CardHeader>
            <CardBody className=" flex overflow-visible py-2 justify-center items-center">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3386.744224348934!2d-116.6001745!3d31.913546199999995!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80d88d53d84e4d75%3A0x7f27faf582dd51e0!2sZirconia%201281%2C%20Fraccionamiento%20Los%20Encinos%2C%2022819%20Ensenada%2C%20B.C.!5e0!3m2!1sen!2smx!4v1745280738209!5m2!1sen!2smx" width="90%" height="450" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </CardBody>
        </Card>
    </div>
  )
}

export default CardEventUbi
const Footer = () => {
  return (
    <footer className="w-full bg-blue-800 text-white font-sans text-sm px-6 py-10">
      <div className="flex flex-col md:flex-row justify-between items-start text-center md:text-left gap-8">

        <div className="w-full md:w-1/3 flex flex-col items-center md:items-start space-y-2">
          <p className="text-lg font-semibold">¿Qué hacer en...</p>
          <p className="text-gray-300">
            Explora sitios de interés, eventos y actividades destacadas de manera sencilla y eficiente.
          </p>
        </div>

        <div className="w-full md:w-1/3 flex flex-col items-center space-y-3">
          <p className="text-lg font-semibold">Síguenos en redes</p>
          <div className="flex gap-5">
            <a href="https://www.instagram.com" target="_blank" rel="noopener noreferrer">
              <img src="../images/instagram.svg" alt="Instagram" className="w-6 h-6 hover:opacity-80" />
            </a>
            <a href="https://www.youtube.com" target="_blank" rel="noopener noreferrer">
              <img src="../images/youtube.svg" alt="YouTube" className="w-6 h-6 hover:opacity-80" />
            </a>
            <a href="https://www.x.com" target="_blank" rel="noopener noreferrer">
              <img src="../images/twitter-alt.svg" alt="X" className="w-6 h-6 hover:opacity-80" />
            </a>
          </div>
        </div>

        <div className="w-full md:w-1/3 flex flex-col items-center md:items-end space-y-2">
          <p className="text-lg font-semibold">Enlaces útiles</p>
          <a href="/" className="text-gray-300 hover:text-white hover:underline transition-colors">Descubrir</a>
          <a href="/events" className="text-gray-300 hover:text-white hover:underline transition-colors">Eventos</a>
          <a href="/#" className="text-gray-300 hover:text-white hover:underline transition-colors">Contacto</a>
        </div>
      </div>
    </footer>
  );
};

export default Footer;

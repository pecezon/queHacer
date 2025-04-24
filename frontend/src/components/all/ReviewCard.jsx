import React, { useState } from "react";
import { StarIcon } from "@heroicons/react/24/solid";
import { StarIcon as StarOutline } from "@heroicons/react/24/outline";

function ReviewCard({
  id,
  title = "Helados Ramiro",
  description = "Body text for whatever you'd like to say. Add main takeaway points, quotes, anecdotes, or even a very very short story.",
  initialRating = 4,
  onRatingChange = () => {},
  showRatingNumber = true,
  borderColor = "blue-700",
  cardSize = "w-72 h-96", 
  interactive = false,
  category = "food",
  imageUrl = "https://images.unsplash.com/photo-1501443762994-82bd5dace89a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=500&q=80" 
}) {
  const [rating, setRating] = useState(initialRating);

  const handleRatingChange = (newRating) => {
    if (interactive) {
      setRating(newRating);
      onRatingChange(newRating);
    }
  };

  return (
    <div 
      className={`relative flex flex-col ${cardSize} border-4 border-${borderColor} rounded-3xl p-4 bg-white shadow-lg overflow-hidden`}
      data-category={category} 
    >
      {/* Sección de Imagen (arriba) */}
      <div className="w-full h-40 mb-3 rounded-xl overflow-hidden">
        <img 
          src={imageUrl} 
          alt={title}
          className="w-full h-full object-cover"
        />
      </div>

      {/* Sección de Texto (centro) */}
      <div className="flex-1 flex flex-col px-2 overflow-y-auto">
        <h2 className="text-xl font-bold text-gray-800 mb-2">
          {title}
        </h2>
        <p className="text-xs text-gray-600 pr-2">
          {description}
        </p>
      </div>

      {/* Sección de Rating (derecha) */}
      <div className="absolute right-3 bottom-3 flex flex-col-reverse space-y-1">
        {[1, 2, 3, 4, 5].map((star) => (
          <button
            key={star}
            onClick={() => handleRatingChange(star)}
            className={`focus:outline-none ${!interactive ? 'cursor-default' : ''}`}
            disabled={!interactive}
          >
            {star <= rating ? (
              <StarIcon className="h-6 w-6 text-yellow-400" />
            ) : (
              <StarOutline className="h-6 w-6 text-gray-300" />
            )}
          </button>
        ))}
      </div>

      {/* Puntuación numérica (opcional) */}
      {showRatingNumber && (
        <div className={`absolute bottom-3 left-3 bg-${borderColor.replace("border-", "")} bg-opacity-20 text-${borderColor.replace("border-", "")} px-2 py-1 rounded-full text-xs font-bold`}>
          {rating}.0
        </div>
      )}
    </div>
  );
}

export default ReviewCard;
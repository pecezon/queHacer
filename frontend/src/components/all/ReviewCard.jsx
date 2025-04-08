import React, { useState } from "react";
import { StarIcon } from "@heroicons/react/24/solid";
import { StarIcon as StarOutline } from "@heroicons/react/24/outline";

function ReviewCard({
  title = "Título predeterminado",
  description = "Descripción predeterminada",
  initialRating = 3,
  onRatingChange = () => {},
  showRatingNumber = true,
  borderColor = "blue-700",
  cardSize = "w-64 h-64",
  interactive = true
}) {
  const [rating, setRating] = useState(initialRating);

  const handleRatingChange = (newRating) => {
    if (interactive) {
      setRating(newRating);
      onRatingChange(newRating);
    }
  };

  return (
    <div className={`relative flex ${cardSize} border-4 border-${borderColor} rounded-3xl p-4 bg-white shadow-lg`}>
      <div className="flex-1 flex flex-col justify-center items-center text-center space-y-2">
        <p className="text-lg font-medium text-gray-800">
          {title}
        </p>

        <p className="text-sm text-gray-500 px-2">
          {description}
        </p>
      </div>

      <div className="absolute right-3 top-1/2 transform -translate-y-1/2 flex flex-col space-y-1">
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

      {showRatingNumber && (
        <div className={`absolute bottom-3 right-3 bg-${borderColor.replace("border-", "")} bg-opacity-20 text-${borderColor.replace("border-", "")} px-2 py-1 rounded-full text-xs font-bold`}>
          {rating}.0
        </div>
      )}
    </div>
  );
}

export default ReviewCard;
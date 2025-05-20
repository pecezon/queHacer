import React, { useState } from "react";
import { StarIcon } from "@heroicons/react/24/solid";
import { StarIcon as StarOutline } from "@heroicons/react/24/outline";
import { useNavigate } from "react-router-dom";

function ReviewCard({
  id,
  title,
  description,
  initialRating,
  reviewCount,
  reviewSum,
  borderColor,
  category,
  imageUrl = "https://via.placeholder.com/300",
  minPrice,
  maxPrice,
  location,
  phoneNumber,
}) {
  const navigate = useNavigate();
  const ratingAverage = reviewCount > 0 ? reviewSum / reviewCount : 0;

  const handleClick = () => {
    navigate(`/event/${id}`);
  };

  return (
    <div
      onClick={handleClick}
      className={`relative flex flex-col w-72 h-96 border-4 border-${borderColor} rounded-3xl p-4 bg-white shadow-lg overflow-hidden cursor-pointer`}
      data-category={category}
    >
      {/* Imagen */}
      <div className="w-full h-40 mb-3 rounded-xl overflow-hidden">
        <img
          src={imageUrl}
          alt={title}
          className="w-full h-full object-cover"
        />
      </div>

      {/* Contenido */}
      <div className="flex-1 flex flex-col px-2 overflow-y-auto">
        <h2 className="text-xl font-bold text-gray-800 mb-2">{title}</h2>

        <p className="text-sm text-gray-600 mb-2 line-clamp-5 pr-2">
          {description}
        </p>
      </div>

      {/* Rating */}
      <div className="absolute right-3 bottom-3 flex flex-col-reverse space-y-1">
        {[1, 2, 3, 4, 5].map((star) =>
          star <= Math.round(ratingAverage) ? (
            <StarIcon key={star} className="h-6 w-6 text-yellow-400" />
          ) : (
            <StarOutline key={star} className="h-6 w-6 text-gray-300" />
          )
        )}
      </div>

      {/* Contador de reviews */}
      {reviewCount > 0 && (
        <div
          className={`absolute bottom-3 left-3 bg-${borderColor} bg-opacity-20 text-${borderColor} px-2 py-1 rounded-full text-xs font-bold`}
        >
          {ratingAverage.toFixed(1)} ({reviewCount})
        </div>
      )}
    </div>
  );
}

export default ReviewCard;

import React, { useState } from "react";
import { Checkbox, Button } from "@heroui/react";
import { StarIcon } from "@heroicons/react/24/solid";

function Filtro({ onFilterChange }) {
  const categories = [
    { id: "music", name: "Musica", checked: true },
    { id: "art", name: "Arte", checked: true },
    { id: "food", name: "Comida", checked: true },
    { id: "tech", name: "Tecnologia", checked: true },
    { id: "sports", name: "Deporte", checked: true },
    { id: "parks", name: "Parques y Outdoor", checked: true }
  ];

  const [categoryState, setCategoryState] = useState(categories);
  const [minRating, setMinRating] = useState(0);

  const handleCategoryChange = (id) => {
    const newState = categoryState.map(cat => 
      cat.id !== id ? {...cat, checked: !cat.checked} : cat
    );
    setCategoryState(newState);
    applyFilters(newState, minRating);
  };

  const handleRatingChange = (rating) => {
    setMinRating(rating);
    applyFilters(categoryState, rating);
  };

  const applyFilters = (categories, rating) => {
    const selectedCategories = categories
      .filter(cat => cat.checked)
      .map(cat => cat.id);
    
    onFilterChange({
      categories: selectedCategories,
      minRating: rating
    });
  };

  const resetFilters = () => {
    const resetCategories = categoryState.map(cat => ({...cat, checked: true}));
    setCategoryState(resetCategories);
    setMinRating(0);
    applyFilters(resetCategories, 0);
  };

  return (
    <div className="w-full bg-white p-4 rounded-lg shadow-md">
      <div className="flex justify-between items-center mb-4">
        <h2 className="text-xl font-bold">Filters</h2>
        <Button 
          onClick={resetFilters}
          size="sm"
          variant="ghost"
          className="text-blue-600 hover:text-blue-800"
        >
          Reset All
        </Button>
      </div>
      
      <div className="mb-6">
        <h3 className="font-semibold mb-2">Minimum Rating</h3>
        <div className="flex space-x-1">
          {[1, 2, 3, 4, 5].map((star) => (
            <button
              key={star}
              onClick={() => handleRatingChange(star)}
              className={`p-1 rounded ${minRating >= star ? 'bg-yellow-100' : ''}`}
            >
              <StarIcon className={`h-5 w-5 ${minRating >= star ? 'text-yellow-400' : 'text-gray-300'}`} />
            </button>
          ))}
          {minRating > 0 && (
            <button 
              onClick={() => handleRatingChange(0)}
              className="ml-2 text-xs text-gray-500 hover:text-gray-700"
            >
              Clear
            </button>
          )}
        </div>
      </div>
      
      <div className="mb-6">
        <h3 className="font-semibold mb-2">Event Categories</h3>
        <div className="space-y-2">
          {categoryState.map(cat => (
            <div key={cat.id} className="flex items-center">
              <Checkbox
                id={cat.id}
                checked={cat.checked}
                onChange={() => handleCategoryChange(cat.id)}
                className="mr-2"
              />
              <label htmlFor={cat.id} className="text-sm font-medium text-gray-700">
                {cat.name}
              </label>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default Filtro;
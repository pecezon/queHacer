import React from "react";
import {
  Checkbox,
  Radio,
  RadioGroup,
  Select,
  DatePicker,
  Button
} from "@heroui/react";

function Filtro() {
  const categories = [
    { id: "music", name: "Music Events", checked: false },
    { id: "art", name: "Art Exhibitions", checked: false },
    { id: "food", name: "Food & Gastronomy", checked: false },
    { id: "tech", name: "Technology Conferences", checked: false },
    { id: "sports", name: "Sports Activities", checked: false },
    { id: "parks", name: "Parks & Outdoor", checked: false }
  ];

  const [categoryState, setCategoryState] = React.useState(categories);

  const handleCategoryChange = (id) => {
    setCategoryState(prev => prev.map(cat => 
      cat.id === id ? {...cat, checked: !cat.checked} : cat
    ));
  };

  const locations = [
    { value: "", label: "All Locations" },
    { value: "Downtown", label: "Downtown" },
    { value: "Museum District", label: "Museum District" },
    { value: "Waterfront", label: "Waterfront" },
    { value: "Convention Center", label: "Convention Center" },
    { value: "City Park", label: "City Park" },
  ];

  return (
    <div className="w-full bg-white p-4 rounded-lg shadow-md">
      <h2 className="text-xl font-bold mb-4">Filters</h2>
      
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
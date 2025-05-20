import React, { createContext, useContext, useState, useEffect } from 'react';

const ReviewContext = createContext();

export function ReviewProvider({ children }) {
  const [reviews, setReviews] = useState([]);
  const [filteredReviews, setFilteredReviews] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchReviews = async () => {
      try {
        const response = await fetch('http://localhost:8080/events');
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const data = await response.json();
        setReviews(data);
        setFilteredReviews(data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchReviews();
  }, []);

  const handleFilterChange = (filters) => {
    const filtered = reviews.filter((review) => {
      const categoryMatch =
        filters.categories.length === 0 ||
        filters.categories.includes(review.category);
      const ratingMatch = review.initialRating >= filters.minRating;
      return categoryMatch && ratingMatch;
    });
    setFilteredReviews(filtered);
  };

  const getEventById = (id) => {
    return reviews.find(event => event.id === parseInt(id));
  };

  return (
    <ReviewContext.Provider 
      value={{ 
        reviews, 
        filteredReviews, 
        loading, 
        error, 
        handleFilterChange,
        getEventById 
      }}
    >
      {children}
    </ReviewContext.Provider>
  );
}

export function useReviews() {
  return useContext(ReviewContext);
}
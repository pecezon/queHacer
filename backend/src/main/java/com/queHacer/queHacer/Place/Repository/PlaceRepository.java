package com.queHacer.queHacer.Place.Repository;

import com.queHacer.queHacer.Place.Model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query("SELECT p FROM Place p WHERE p.name LIKE CONCAT('%', :keyword, '%') OR p.description LIKE CONCAT('%', :keyword, '%')")
    List<Place> findPlaceByNameOrDescriptionContaining(@Param("keyword")String name);

    @Query("SELECT p FROM Place p WHERE p.creator.id = :creatorId")
    List<Place> findPlaceByCreatorId(@Param("creatorId") Integer creatorId);

    @Query("SELECT p FROM Place p WHERE LOWER(p.city) = LOWER(:city) AND LOWER(p.country) = LOWER(:country)")
    List<Place> findByCityAndCountryIgnoreCase(@Param("city") String city, @Param("country") String country);

    //First I made it for values exclusively between the range, but I decided to include values that may overlap
    @Query("SELECT p FROM Place p WHERE " +
            "(p.maxPrice >= :minPrice OR :minPrice IS NULL) " +
            "AND (p.minPrice <= :maxPrice OR :maxPrice IS NULL)")
    List<Place> findPlacesByPriceRange(@Param("minPrice") Float minPrice, @Param("maxPrice") Float maxPrice);


}

package com.queHacer.queHacer.Event.Repository;

import com.queHacer.queHacer.Event.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("SELECT e from Event e WHERE e.name LIKE CONCAT('%', :keyword, '%') OR e.description LIKE %:keyword%")
    List<Event> findByName(@Param("keyword") String name);

    @Query("SELECT e from Event e WHERE e.id_creator = :keyword")
    List<Event> findByCreatorId(@Param("keyword") Integer idCreator);

    @Query("SELECT e from Event e WHERE LOWER(e.city) = LOWER(:city) AND LOWER(e.country) = LOWER(:country)")
    List<Event> findByCityAndCountry(@Param("city") String city, @Param("country") String country);

    @Query("SELECT e FROM Event e WHERE e.startDate BETWEEN :start AND :end")
    List<Event> findByStartDate(@Param("start") LocalDateTime start, @Param("end")LocalDateTime end);

    @Query("SELECT e from Event e WHERE LOWER(e.city) = LOWER(:city) AND LOWER(e.country) = LOWER(:country) AND (e.startDate BETWEEN :start AND :end)")
    List<Event> findByStartDateBetween(@Param("start") LocalDateTime start, @Param("end")LocalDateTime end, @Param("city") String city, @Param("country") String country);

    @Query("SELECT e from Event e WHERE (e.minPrice BETWEEN :min AND :max) AND (e.maxPrice BETWEEN :min AND :max) AND (LOWER(e.city) = LOWER(:city) AND LOWER(e.country) = LOWER(:country) )")
    List<Event> findByPriceBetween(@Param("min") Float minPrice, @Param("max") Float maxPrice, @Param("city") String city, @Param("country") String country);
}

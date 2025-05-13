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
    List<Event> findByStartDateBetween(@Param("start") LocalDateTime start, @Param("end")LocalDateTime end);
}

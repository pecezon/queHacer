package com.queHacer.queHacer.Event.Repository;

import com.queHacer.queHacer.Event.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("SELECT e from Event e WHERE e.name LIKE CONCAT('%', :keyword, '%')")
    List<Event> findByName(@Param("keyword") String name);

}

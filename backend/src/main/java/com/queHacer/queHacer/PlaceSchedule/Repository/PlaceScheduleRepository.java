package com.queHacer.queHacer.PlaceSchedule.Repository;

import com.queHacer.queHacer.PlaceSchedule.Model.PlaceSchedule;
import com.queHacer.queHacer.PlaceSchedule.Model.PlaceScheduleDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceScheduleRepository extends JpaRepository<PlaceSchedule,Long> {


    List<PlaceSchedule> findByPlaceId(Long placeId);

    @Modifying
    @Transactional
    @Query("DELETE FROM PlaceSchedule ps WHERE ps.place.id = :placeId")
    void deleteAllByPlaceId(@Param("placeId") Long placeId);
}

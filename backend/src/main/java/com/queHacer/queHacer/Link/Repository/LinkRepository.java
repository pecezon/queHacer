package com.queHacer.queHacer.Link.Repository;

import com.queHacer.queHacer.Link.Model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link,Long> {

    List<Link> findByEvent_Id(Integer eventId);
}

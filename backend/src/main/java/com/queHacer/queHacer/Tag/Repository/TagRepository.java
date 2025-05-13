package com.queHacer.queHacer.Tag.Repository;

import com.queHacer.queHacer.Tag.Model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
}

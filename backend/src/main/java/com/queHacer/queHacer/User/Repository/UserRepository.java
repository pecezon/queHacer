package com.queHacer.queHacer.User.Repository;

import com.queHacer.queHacer.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //Spring data jpa
    boolean existsByEmail(String email);
    List<User> findByNameContaining(String input);

    //JPQL
    @Query("SELECT p FROM User p WHERE p.name LIKE %:keyword% OR p.lastname LIKE %:keyword%")
    List<User> findByNameOrLastnameContaining(@Param("keyword") String name);

}

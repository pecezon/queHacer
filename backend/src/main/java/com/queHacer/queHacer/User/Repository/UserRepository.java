package com.queHacer.queHacer.User.Repository;

import com.queHacer.queHacer.User.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

    //Spring data jpa
    AppUser findByEmail(String email);
    boolean existsByEmail(String email);
    List<AppUser> findByNameContaining(String input);

    //JPQL
    @Query("SELECT p FROM AppUser p WHERE p.name LIKE %:keyword% OR p.lastname LIKE %:keyword%")
    List<AppUser> findByNameOrLastnameContaining(@Param("keyword") String name);

}

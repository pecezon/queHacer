package com.queHacer.queHacer.User.Model;

import com.queHacer.queHacer.User.Rol;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Random;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "passwordHash")
    private String passwordHash;

    //use libphonenumber for validation later.
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Column(nullable = false, updatable = false, name = "createdAt")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "verificationCode")
    private Integer verificationCode;

    @Column(name = "expirationVerificationCode")
    private LocalDateTime expirationVerificationCode;

    @Column(name = "isVerified")
    private Boolean isVerified;


    //Utility Functions for the entity instance creation
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = updatedAt = now;

        //Generates da verification code
        verificationCode = generateVerificationCode();

        //Gives the verification code an expiration date
        expirationVerificationCode = now.plusHours(24);

        //verified = false
        isVerified = false;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    //Verification code generator
    private Integer generateVerificationCode() {
        return 100000 + new Random().nextInt(900000);
    }

}

package com.queHacer.queHacer.User.Model;

import com.queHacer.queHacer.User.Rol;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private Integer id;

    private String email;

    private String passwordHash;

    private String phoneNumber;

    private String name;

    private String lastname;

    private Rol rol;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer verificationCode;

    private LocalDateTime expirationVerificationCode;

    private Boolean isVerified;

    public UserDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.passwordHash = user.getPasswordHash();
        this.phoneNumber = user.getPhoneNumber();
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.rol = user.getRol();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.verificationCode = user.getVerificationCode();
        this.expirationVerificationCode = user.getExpirationVerificationCode();
        this.isVerified = user.getIsVerified();
    }

}

package com.queHacer.queHacer.User.Model;

import com.queHacer.queHacer.User.Rol;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public UserDTO(AppUser appUser) {
        this.id = appUser.getId();
        this.email = appUser.getEmail();
        this.passwordHash = appUser.getPasswordHash();
        this.phoneNumber = appUser.getPhoneNumber();
        this.name = appUser.getName();
        this.lastname = appUser.getLastname();
        this.rol = appUser.getRol();
        this.createdAt = appUser.getCreatedAt();
        this.updatedAt = appUser.getUpdatedAt();
        this.verificationCode = appUser.getVerificationCode();
        this.expirationVerificationCode = appUser.getExpirationVerificationCode();
        this.isVerified = appUser.getIsVerified();
    }

}

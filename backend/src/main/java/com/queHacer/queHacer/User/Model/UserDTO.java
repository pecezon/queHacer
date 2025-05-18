package com.queHacer.queHacer.User.Model;

import com.queHacer.queHacer.User.Role;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private Integer id;

    private String email;

    private String phoneNumber;

    private String name;

    private String lastname;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime expirationVerificationCode;

    private Boolean isVerified;

    public UserDTO(AppUser appUser) {
        this.id = appUser.getId();
        this.email = appUser.getEmail();

        this.phoneNumber = appUser.getPhoneNumber();
        this.name = appUser.getName();
        this.lastname = appUser.getLastname();
        this.createdAt = appUser.getCreatedAt();
        this.updatedAt = appUser.getUpdatedAt();
        this.expirationVerificationCode = appUser.getExpirationVerificationCode();
        this.isVerified = appUser.getIsVerified();
    }

}

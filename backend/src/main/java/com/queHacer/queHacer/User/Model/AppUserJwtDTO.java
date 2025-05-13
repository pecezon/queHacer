package com.queHacer.queHacer.User.Model;

import lombok.Data;

@Data
public class AppUserJwtDTO {
    private String email;
    private String password;

    public AppUserJwtDTO(AppUser user){
        this.email = user.getEmail();
        this.password = user.getPasswordHash();
    }
}

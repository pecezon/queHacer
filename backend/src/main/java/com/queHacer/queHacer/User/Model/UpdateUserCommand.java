package com.queHacer.queHacer.User.Model;

import lombok.Getter;

@Getter
public class UpdateUserCommand {
    private Integer id;
    private AppUser appUser;

    public UpdateUserCommand(Integer id, AppUser appUser) {
        this.id = id;
        this.appUser = appUser;
    }
}

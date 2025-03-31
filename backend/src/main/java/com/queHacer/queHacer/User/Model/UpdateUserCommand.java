package com.queHacer.queHacer.User.Model;

import lombok.Getter;

@Getter
public class UpdateUserCommand {
    private Integer id;
    private User user;

    public UpdateUserCommand(Integer id, User user) {
        this.id = id;
        this.user = user;
    }
}

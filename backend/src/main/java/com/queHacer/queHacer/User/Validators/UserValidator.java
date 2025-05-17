package com.queHacer.queHacer.User.Validators;

import com.queHacer.queHacer.Exceptions.ErrorMessages;
import com.queHacer.queHacer.Exceptions.UserNotValidException;
import com.queHacer.queHacer.User.Model.AppUser;
import org.springframework.util.StringUtils;

public class UserValidator {

    private UserValidator() {
    }

    public static void execute(AppUser appUser){
        if(StringUtils.isEmpty(appUser.getName())){
            throw new UserNotValidException(ErrorMessages.NAME_REQUIRED.getMessage());
        }
        if(StringUtils.isEmpty(appUser.getLastname())){
            throw new UserNotValidException(ErrorMessages.LASTNAME_REQUIRED.getMessage());
        }
        if (StringUtils.isEmpty(appUser.getEmail())) {
            throw new UserNotValidException(ErrorMessages.EMAIL_REQUIRED.getMessage());
        }
        if (StringUtils.isEmpty(appUser.getPhoneNumber())){
            throw new UserNotValidException(ErrorMessages.PHONE_REQUIRED.getMessage());
        }
        if (appUser.getPhoneNumber().length() < 10){
            throw new UserNotValidException(ErrorMessages.PHONE_LENGTH_NOT_VALID.getMessage());
        }
    }
}

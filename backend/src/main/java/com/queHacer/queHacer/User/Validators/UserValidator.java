package com.queHacer.queHacer.User.Validators;

import com.queHacer.queHacer.Exceptions.ErrorMessages;
import com.queHacer.queHacer.Exceptions.UserNotValidException;
import com.queHacer.queHacer.User.Model.User;
import org.springframework.util.StringUtils;

public class UserValidator {

    private UserValidator() {
    }

    public static void execute(User user){
        if(StringUtils.isEmpty(user.getName())){
            throw new UserNotValidException(ErrorMessages.NAME_REQUIRED.getMessage());
        }
        if(StringUtils.isEmpty(user.getLastname())){
            throw new UserNotValidException(ErrorMessages.LASTNAME_REQUIRED.getMessage());
        }
        if (StringUtils.isEmpty(user.getEmail())) {
            throw new UserNotValidException(ErrorMessages.EMAIL_REQUIRED.getMessage());
        }
        if (StringUtils.isEmpty(user.getPhoneNumber())){
            throw new UserNotValidException(ErrorMessages.PHONE_REQUIRED.getMessage());
        }
        if (user.getPhoneNumber().length() < 10){
            throw new UserNotValidException(ErrorMessages.PHONE_LENGTH_NOT_VALID.getMessage());
        }
    }
}

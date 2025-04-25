package com.queHacer.queHacer.User.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Exceptions.ErrorMessages;
import com.queHacer.queHacer.Exceptions.UserNotValidException;
import com.queHacer.queHacer.User.Model.User;
import com.queHacer.queHacer.User.Model.UserDTO;
import com.queHacer.queHacer.User.Repository.UserRepository;
import com.queHacer.queHacer.User.Validators.UserValidator;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

 @Service
public class CreateUserService implements Command<User, UserDTO> {

    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(User user) {

        //Validate the input data
        validateUser(user);

        User savedUser = userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(savedUser));
    }

     private void validateUser(User user) {
         if (userRepository.existsByEmail(user.getEmail())) {
             throw new UserNotValidException(ErrorMessages.EMAIL_EXISTS.getMessage());
         }
         UserValidator.execute(user);
     }
 }

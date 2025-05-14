package com.queHacer.queHacer.User.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Exceptions.ErrorMessages;
import com.queHacer.queHacer.Exceptions.UserNotValidException;
import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Model.UserDTO;
import com.queHacer.queHacer.User.Repository.UserRepository;
import com.queHacer.queHacer.User.Validators.UserValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements Command<AppUser, UserDTO> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<UserDTO> execute(AppUser appUser){

        //Validate the input data
        validateUser(appUser);

        appUser.setPasswordHash(passwordEncoder.encode(appUser.getPasswordHash()));

        AppUser savedAppUser = userRepository.save(appUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(savedAppUser));
    }

     private void validateUser(AppUser appUser) {
         if (userRepository.existsByEmail(appUser.getEmail())) {
             throw new UserNotValidException(ErrorMessages.EMAIL_EXISTS.getMessage());
         }
         UserValidator.execute(appUser);
     }
 }

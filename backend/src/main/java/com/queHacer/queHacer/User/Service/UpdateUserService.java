package com.queHacer.queHacer.User.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Exceptions.UserNotFoundException;
import com.queHacer.queHacer.User.Model.UpdateUserCommand;
import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Model.UserDTO;
import com.queHacer.queHacer.User.Repository.UserRepository;
import com.queHacer.queHacer.User.Validators.UserValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService implements Command<UpdateUserCommand, UserDTO> {

    private final UserRepository userRepository;

    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(UpdateUserCommand command) {
        Optional<AppUser> userOptional = userRepository.findById(command.getId());

        if(userOptional.isPresent()){
            AppUser appUser = userOptional.get();

            if (command.getAppUser().getEmail() != null) {
                appUser.setEmail(command.getAppUser().getEmail());
            }
            if (command.getAppUser().getPhoneNumber() != null) {
                appUser.setPhoneNumber(command.getAppUser().getPhoneNumber());
            }
            if (command.getAppUser().getName() != null) {
                appUser.setName(command.getAppUser().getName());
            }
            if (command.getAppUser().getLastname() != null) {
                appUser.setLastname(command.getAppUser().getLastname());
            }
            if (command.getAppUser().getRol() != null) {
                appUser.setRol(command.getAppUser().getRol());
            }
            if (command.getAppUser().getPasswordHash() != null) {
                appUser.setPasswordHash(command.getAppUser().getPasswordHash());
            }

            UserValidator.execute(appUser);

            userRepository.save(appUser);
            return ResponseEntity.ok(new UserDTO(appUser));
        }

        throw new UserNotFoundException();
    }
}

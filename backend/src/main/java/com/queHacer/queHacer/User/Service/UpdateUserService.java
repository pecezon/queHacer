package com.queHacer.queHacer.User.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.User.Model.UpdateUserCommand;
import com.queHacer.queHacer.User.Model.User;
import com.queHacer.queHacer.User.Model.UserDTO;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.http.HttpStatus;
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
        Optional<User> userOptional = userRepository.findById(command.getId());

        if(userOptional.isPresent()){
            User user = userOptional.get();

            if (command.getUser().getEmail() != null) {
                user.setEmail(command.getUser().getEmail());
            }
            if (command.getUser().getPhoneNumber() != null) {
                user.setPhoneNumber(command.getUser().getPhoneNumber());
            }
            if (command.getUser().getName() != null) {
                user.setName(command.getUser().getName());
            }
            if (command.getUser().getLastname() != null) {
                user.setLastname(command.getUser().getLastname());
            }
            if (command.getUser().getRol() != null) {
                user.setRol(command.getUser().getRol());
            }
            if (command.getUser().getPasswordHash() != null) {
                user.setPasswordHash(command.getUser().getPasswordHash());
            }


            userRepository.save(user);
            return ResponseEntity.ok(new UserDTO(user));
        }

        //TODO exception handling
        return null;
    }
}

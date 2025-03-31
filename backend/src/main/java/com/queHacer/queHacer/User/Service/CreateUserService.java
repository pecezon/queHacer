package com.queHacer.queHacer.User.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.User.Model.User;
import com.queHacer.queHacer.User.Model.UserDTO;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements Command<User, UserDTO> {

    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(User user) {
        User savedUser = userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(savedUser));
    }
}

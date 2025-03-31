package com.queHacer.queHacer.User.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.User.Model.User;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserService implements Command<Integer, Void> {

    private final UserRepository userRepository;

    public DeleteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer input) {

        Optional<User> optionalUser = userRepository.findById(input);

        if (optionalUser.isPresent()){
            userRepository.deleteById(input);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        //TODO handle exceptions


        return null;
    }
}

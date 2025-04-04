package com.queHacer.queHacer.User.Service;

import com.queHacer.queHacer.Query;
import com.queHacer.queHacer.User.Model.User;
import com.queHacer.queHacer.User.Model.UserDTO;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserService implements Query<Integer, UserDTO> {

    private UserRepository userRepository;

    public GetUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(Integer input) {
        Optional<User> userOptional = userRepository.findById(input);

        if(userOptional.isPresent()){
            return ResponseEntity.ok(new UserDTO(userOptional.get()));
        }

        //TODO exception if not found
        return null;
    }
}

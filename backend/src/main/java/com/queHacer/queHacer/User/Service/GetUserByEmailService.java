package com.queHacer.queHacer.User.Service;

import com.queHacer.queHacer.Exceptions.UserNotFoundException;
import com.queHacer.queHacer.Query;
import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Model.UserDTO;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserByEmailService implements Query<String, UserDTO> {

    private UserRepository userRepository;

    public GetUserByEmailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public ResponseEntity<UserDTO> execute(String input) {
        Optional<AppUser> userOptional = userRepository.findByEmail(input);

        if(userOptional.isPresent()){
            return ResponseEntity.ok(new UserDTO(userOptional.get()));
        }

        throw new UserNotFoundException();
    }
}

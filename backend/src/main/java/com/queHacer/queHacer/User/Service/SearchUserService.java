package com.queHacer.queHacer.User.Service;

import com.queHacer.queHacer.Query;
import com.queHacer.queHacer.User.Model.UserDTO;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchUserService implements Query<String, List<UserDTO>> {

    private final UserRepository userRepository;

    public SearchUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<UserDTO>> execute(String input) {
        return ResponseEntity.ok(userRepository.findByNameOrLastnameContaining(input)
                .stream()
                .map(UserDTO::new)
                .toList());
    }
}

package com.queHacer.queHacer.User.Service;

import com.queHacer.queHacer.Query;
import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Model.UserDTO;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersService implements Query<Void, List<UserDTO>> {

    private final UserRepository userRepository;

    public GetUsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<UserDTO>> execute(Void input) {
        List<AppUser> appUsers = userRepository.findAll();
        List<UserDTO> userDTOs = appUsers.stream().map(UserDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(userDTOs);
    }
}

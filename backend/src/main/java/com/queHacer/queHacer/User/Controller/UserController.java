package com.queHacer.queHacer.User.Controller;

import com.queHacer.queHacer.User.Model.UpdateUserCommand;
import com.queHacer.queHacer.User.Model.User;
import com.queHacer.queHacer.User.Model.UserDTO;
import com.queHacer.queHacer.User.Service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final CreateUserService createUserService;

    private final GetUsersService getUsersService;

    private final UpdateUserService updateUserService;

    private final DeleteUserService deleteUserService;

    private final GetUserService getUserService;

    private final SearchUserService searchUserService;

    public UserController(CreateUserService createUserService,
                          GetUsersService getUsersService,
                          UpdateUserService updateUserService,
                          DeleteUserService deleteUserService, GetUserService getUserService, SearchUserService searchUserService) {
        this.createUserService = createUserService;
        this.getUsersService = getUsersService;
        this.updateUserService = updateUserService;
        this.deleteUserService = deleteUserService;
        this.getUserService = getUserService;
        this.searchUserService = searchUserService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        return createUserService.execute(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return getUsersService.execute(null);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id){
        return getUserService.execute(id);
    }

    @GetMapping("/user/search")
    public ResponseEntity<List<UserDTO>> searchUserByName(@RequestParam String name){
        return searchUserService.execute(name);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody User user){
        return updateUserService.execute(new UpdateUserCommand(id, user));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        return deleteUserService.execute(id);
    }


}

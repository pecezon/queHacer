package com.queHacer.queHacer.User.Controller;

import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Model.UpdateUserCommand;
import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Model.UserDTO;
import com.queHacer.queHacer.User.Service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    private final GetUsersService getUsersService;

    private final UpdateUserService updateUserService;

    private final DeleteUserService deleteUserService;

    private final GetUserService getUserService;

    private final SearchUserService searchUserService;
    private final GetUserByEmailService getUserByEmailService;

    public UserController(
            GetUsersService getUsersService,
            UpdateUserService updateUserService,
            DeleteUserService deleteUserService, GetUserService getUserService, SearchUserService searchUserService, GetUserByEmailService getUserByEmailService) {
        this.getUsersService = getUsersService;
        this.updateUserService = updateUserService;
        this.deleteUserService = deleteUserService;
        this.getUserService = getUserService;
        this.searchUserService = searchUserService;
        this.getUserByEmailService = getUserByEmailService;
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get-all-users")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return getUsersService.execute(null);
    }

    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id){
        return getUserService.execute(id);
    }

    @PreAuthorize("hasRole('ADMIN') or #email == authentication.principal.email")
    @GetMapping("/user/get-by-email")
    public ResponseEntity<UserDTO> getUserByEmail(@RequestParam String email){
        return getUserByEmailService.execute(email);
    }

    @GetMapping("/user/search")
    public ResponseEntity<List<UserDTO>> searchUserByName(@RequestParam String name){
        return searchUserService.execute(name);
    }

    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody AppUser appUser){
        return updateUserService.execute(new UpdateUserCommand(id, appUser));
    }

    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        return deleteUserService.execute(id);
    }


}

package com.queHacer.queHacer.User.Controller;

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

    @PostMapping("/createnewuser")
    public ResponseEntity<UserDTO> createUser(@RequestBody AppUser appUser){
        return createUserService.execute(appUser);
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return getUsersService.execute(null);
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id){
        return getUserService.execute(id);
    }

    @GetMapping("/user/search")
    public ResponseEntity<List<UserDTO>> searchUserByName(@RequestParam String name){
        return searchUserService.execute(name);
    }

    //@PreAuthorize("hasRole('admin') or #id == authentication.principal.id")
    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody AppUser appUser){
        return updateUserService.execute(new UpdateUserCommand(id, appUser));
    }

    //@PreAuthorize("hasRole('admin') or #id == authentication.principal.id")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        return deleteUserService.execute(id);
    }


}

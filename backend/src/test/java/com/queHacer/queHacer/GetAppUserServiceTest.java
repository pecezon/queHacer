package com.queHacer.queHacer;

import com.queHacer.queHacer.Exceptions.UserNotFoundException;
import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Model.UserDTO;
import com.queHacer.queHacer.User.Repository.UserRepository;
import com.queHacer.queHacer.User.Rol;
import com.queHacer.queHacer.User.Service.GetUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GetAppUserServiceTest {

    @Mock //
    private UserRepository userRepository;

    @InjectMocks //What we are testing
    private GetUserService getUserService;

    @BeforeEach //Set up before running the test
    public void setup(){
        //Initializes repo and service
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_user_exists_when_get_user_service_return_user_dto(){
        //Given
        AppUser appUser = new AppUser();
        appUser.setId(1);
        appUser.setName("User Name");
        appUser.setEmail("mock.email@gmail.com");
        appUser.setRol(Rol.USER);
        appUser.setLastname("User Lastname");
        appUser.setPasswordHash("sdfghjk");
        appUser.setPhoneNumber("123456789");

        when(userRepository.findById(1)).thenReturn(Optional.of(appUser));

        //When
        ResponseEntity<UserDTO> response = getUserService.execute(1);

        //Then
        assertEquals(ResponseEntity.ok(new UserDTO(appUser)), response);
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    public void given_user_does_not_exist_when_get_user_service_throw_user_not_found_exception(){
        //Given
        when(userRepository.findById(1)).thenReturn(Optional.empty());

        //When & Then are the same thing because of the exception
        assertThrows(UserNotFoundException.class, () -> getUserService.execute(1));
        verify(userRepository, times(1)).findById(1);
    }
}

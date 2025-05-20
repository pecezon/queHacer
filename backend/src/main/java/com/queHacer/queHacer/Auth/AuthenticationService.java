package com.queHacer.queHacer.Auth;

import com.queHacer.queHacer.Exceptions.ErrorMessages;
import com.queHacer.queHacer.Exceptions.UserNotValidException;
import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Repository.UserRepository;
import com.queHacer.queHacer.User.Role;
import com.queHacer.queHacer.security.jwt.JwtService;
import com.queHacer.queHacer.User.Validators.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(AppUser request) {
        validateUser(request);

        request.setPasswordHash(passwordEncoder.encode(request.getPasswordHash()));

        ArrayList<String> admins = new ArrayList<>();
        admins.add("juanp.cardenas@cetys.edu.mx");
        admins.add("lopez.diego@cetys.edu.mx");
        admins.add("linette.acosta@cetys.edu.mx");
        admins.add("carlosmiguel.ibarra@cetys.edu.mx");

        if(admins.contains(request.getEmail())) {
            request.setRole(Role.ADMIN);
        }else{
            request.setRole(Role.USER);
        }

        userRepository.save(request);

        var jwtToken = jwtService.generateToken(request);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotValidException("User not found"));

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void validateUser(AppUser appUser) {
        if (userRepository.existsByEmail(appUser.getEmail())) {
            throw new UserNotValidException(ErrorMessages.EMAIL_EXISTS.getMessage());
        }
        UserValidator.execute(appUser);
    }


}

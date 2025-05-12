package com.queHacer.queHacer.User.Service;

import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CUserDetailsService implements UserDetailsService {

    public final UserRepository userRepository;

    public CUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByEmail(username);

        return org.springframework.security.core.userdetails.User
                .withUsername(appUser.getEmail())
                .password(appUser.getPasswordHash())
                .build();
    }
}

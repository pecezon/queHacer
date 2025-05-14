package com.queHacer.queHacer.User.Service;

import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Model.UserDetailsImpl;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CUserDetailsService implements UserDetailsService {

    public final UserRepository userRepository;

    public CUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByEmail(username);

        if (appUser == null) throw new UsernameNotFoundException("No se encontro el user wei");

        return User
                .withUsername(appUser.getEmail())
                .password(appUser.getPasswordHash())
                .roles("basicUser")
                .build();
    }
}

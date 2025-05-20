package com.queHacer.queHacer.User.Model;

import com.queHacer.queHacer.User.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Random;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "users")
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Password is required")
    @Column(name = "passwordHash")
    private String passwordHash;

    //use libphonenumber for validation later.
    @NotNull(message = "Phone is required")
    @Size(min = 10, message = "Phone number must be 10 digits long at least")
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NotNull(message = "Name is required")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Lastname is required")
    @Column(name = "lastname")
    private String lastname;

    @NotNull(message = "Rol is required")
    @Column(name = "rol")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false, updatable = false, name = "createdAt")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "verificationCode")
    private Integer verificationCode;

    @Column(name = "expirationVerificationCode")
    private LocalDateTime expirationVerificationCode;

    @Column(name = "isVerified")
    private Boolean isVerified;


    //Utility Functions for the entity instance creation
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = updatedAt = now;

        //Generates da verification code
        verificationCode = generateVerificationCode();

        //Gives the verification code an expiration date
        expirationVerificationCode = now.plusHours(24);

        //verified = false
        isVerified = false;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    //Verification code generator
    private Integer generateVerificationCode() {
        return 100000 + new Random().nextInt(900000);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.queHacer.queHacer.User.Headers;

import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Rol;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {

    @GetMapping("/header")
    public String getRegionalResponse(@RequestHeader(required = false, defaultValue = "MEX") String region){
        if(region.equals("US")) return "FREEDOM RAAAH";

        if(region.equals("MEX")) return "ARRIBA LAS AGUILAS LUPE";

        return "Country not supported";
    }

    @GetMapping(value = "/header/user", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<AppUser> getUser(){
        AppUser appUser = new AppUser();
        appUser.setId(1);
        appUser.setName("User Name");
        appUser.setEmail("mock.email@gmail.com");
        appUser.setRol(Rol.USER);
        appUser.setLastname("User Lastname");
        appUser.setPasswordHash("sdfghjk");
        appUser.setPhoneNumber("123456789");

        return ResponseEntity.ok(appUser);
    }

}

package suthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import suthentication.entity.UserEntity;
import suthentication.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class GetUserDetails {

    @Autowired
    UserService userService;

    @GetMapping("/getuser/{username}")
    public Optional<UserEntity> getUserDetails(@PathVariable  String username){
        System.out.println("in services");
        return userService.getUserDetails(username);
    }


}

package suthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import suthentication.DTO.JwtResponse;
import suthentication.DTO.LoginRequest;
import suthentication.entity.UserEntity;
import suthentication.service.AuthService;
import suthentication.service.JwtService;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class Login {

    @Autowired
    AuthService authService;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("login")
    public JwtResponse authLogin(@RequestBody LoginRequest request){
        String jwtToken="";
        UserDetails userDetails = authService.loadUserByUsername(request.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword())
        );

        String token = jwtService.generateToken((org.springframework.security.core.userdetails.UserDetails) userDetails,
                new HashMap<String,Object>());
        return new JwtResponse(token);
    }

}

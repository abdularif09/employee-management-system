package suthentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import suthentication.entity.UserEntity;
import suthentication.repository.UserRepository;
//import io.jsonwebtoken.security.Keys;

import java.util.*;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = null;

        Optional<UserEntity> optionalUser = userRepository.findByUsername(userName);

        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            System.out.println("user not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), List.of());
    }




}

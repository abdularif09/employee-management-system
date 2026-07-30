package suthentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suthentication.entity.UserEntity;
import suthentication.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Optional<UserEntity> getUserDetails(String userName){
        return userRepository.findByUsername(userName);
    }
}

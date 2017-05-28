package com.simongk.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Szymon Gasienica-Kotelnicki on 21.05.17.
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id){
        return userRepository.getOne(id);
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public User getUserByName(String name){
        return userRepository.findByName(name);
    }

    public Collection<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(RegistrationForm form){
        User user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setCarts(new ArrayList<>());
        return userRepository.save(user);
    }

}

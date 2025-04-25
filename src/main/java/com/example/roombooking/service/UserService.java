package com.example.roombooking.service;

import com.example.roombooking.entity.User;
import com.example.roombooking.exception.ResourceNotFoundException;
import com.example.roombooking.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserService(UserRepository r, PasswordEncoder e){this.repo=r;this.encoder=e;}
    public User createUser(User u){
        u.setPassword(encoder.encode(u.getPassword()));
        return repo.save(u);
    }
    public User findByUsername(String name){
        return repo.findByUsername(name)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}

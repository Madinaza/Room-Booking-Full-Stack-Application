package com.example.roombooking.service;

import com.example.roombooking.dto.AuthRequest;
import com.example.roombooking.dto.AuthResponse;
import com.example.roombooking.dto.UserDto;
import com.example.roombooking.entity.Role;
import com.example.roombooking.entity.User;
import com.example.roombooking.security.JwtTokenProvider;
import com.example.roombooking.util.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final EntityDtoMapper mapper;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager,
                       JwtTokenProvider jwtTokenProvider,
                       UserService userService,
                       EntityDtoMapper mapper) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider     = jwtTokenProvider;
        this.userService          = userService;
        this.mapper               = mapper;
    }

    public AuthResponse authenticate(AuthRequest req) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        String token = jwtTokenProvider.generateToken(auth);
        return new AuthResponse(token);
    }

    public UserDto register(AuthRequest req) {
        User u = new User();
        u.setUsername(req.getUsername());
        u.setPassword(req.getPassword());
        u.setRoles(Set.of(Role.ROLE_USER));

        User saved = userService.createUser(u);
        return mapper.userToDto(saved);
    }
}

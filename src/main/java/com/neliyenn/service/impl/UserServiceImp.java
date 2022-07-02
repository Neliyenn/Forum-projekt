package com.neliyenn.service.impl;

import com.neliyenn.model.User;
import com.neliyenn.repository.RoleRepository;
import com.neliyenn.repository.UserRepository;
import com.neliyenn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static final String USER_ROLE = "ROLE_USER";

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        //kodowanie hasla
        user.setPassword(passwordEncoder.encode((user.getPassword())));
        user.setActive(1);
        //nadanie roli USER_ROLE
        user.setRoles(Arrays.asList(roleRepository.findByRole(USER_ROLE)));
        return userRepository.saveAndFlush(user);
    }
}

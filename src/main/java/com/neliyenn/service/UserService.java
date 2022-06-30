package com.neliyenn.service;

import com.neliyenn.model.User;

public interface UserService {

    User findByUsername(String username);

    User findByEmail(String email);

    User saveUser(User user);
}

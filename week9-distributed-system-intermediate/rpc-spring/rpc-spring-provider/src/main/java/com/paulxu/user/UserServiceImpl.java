package com.paulxu.user;

import com.paulxu.user.domain.entity.User;
import com.paulxu.user.domain.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User getById(int id) {
        return new User(id, "paulxu");
    }
}

package com.ease.arch.service.impl;

import com.ease.arch.entity.User;
import com.ease.arch.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User createUser() {
        User user=new User();
        user.setId(1);
        user.setName("fff");
        user.setAge(11);
        user.setPassword("ggg");
        return user;
    }
}

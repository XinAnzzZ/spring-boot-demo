package com.java.myh.service.impl;

import com.java.myh.model.User;
import com.java.myh.repository.UserRepository;
import com.java.myh.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 心安
 * @date 2018/5/30 17:19
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

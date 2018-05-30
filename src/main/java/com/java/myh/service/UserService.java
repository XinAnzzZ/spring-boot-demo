package com.java.myh.service;

import com.java.myh.model.User;

/**
 * @author 心安
 * @date 2018/5/30 17:18
 */
public interface UserService {
    User findByUsername(String username);
}

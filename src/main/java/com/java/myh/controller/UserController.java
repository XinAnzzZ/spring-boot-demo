package com.java.myh.controller;


import com.java.myh.model.User;
import com.java.myh.repository.UserRepository;
import com.java.myh.util.ResponseJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 心安
 * @date 2018/5/29 17:00
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping("/hello")
    public ResponseJson hello() {
        User user = userRepository.findByUsername("xinan");
        return new ResponseJson("ok", Boolean.TRUE, user);
    }
}

package com.java.myh.controller;


import com.java.myh.model.User;
import com.java.myh.service.UserService;
import com.java.myh.util.MailUtils;
import com.java.myh.util.ResponseJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @author 心安
 * @date 2018/5/29 17:00
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping("/hello")
    public ResponseJson hello() {
        User user = userService.findByUsername("xinan");
        return new ResponseJson("ok", Boolean.TRUE, user);
    }

    @RequestMapping("/send/mail")
    public void sendMail() throws MessagingException {
        MailUtils.sendMail();
    }
}

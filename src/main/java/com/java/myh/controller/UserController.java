package com.java.myh.controller;


import com.java.myh.model.User;
import com.java.myh.service.UserService;
import com.java.myh.util.MailUtils;
import com.java.myh.util.ResponseJson;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping("/hello")
    public ResponseJson hello() {
        User user = userService.findByUsername("xinan");
        return ResponseJson.success(user);
    }

    @RequestMapping("/send/mail/{sendTo}/{content}")
    public ResponseJson sendMail(@PathVariable("sendTo") String sendTo,
                                 @PathVariable("content") String content) throws MessagingException {
        MailUtils.sendMail(sendTo, content);
        return ResponseJson.success("发送成功");
    }
}

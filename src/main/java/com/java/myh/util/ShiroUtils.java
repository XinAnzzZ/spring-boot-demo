package com.java.myh.util;

import com.java.myh.model.User;
import org.apache.shiro.SecurityUtils;

/**
 * @author 心安
 * @date 2018/5/31 17:35
 */
public class ShiroUtils extends SecurityUtils {

    public static User getUser() {
        return (User) getSubject().getPrincipal();
    }

    public static Integer getUserId() {
        return getUser().getId();
    }
}

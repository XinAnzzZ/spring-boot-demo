package com.java.myh.controller;

import com.java.myh.model.User;
import com.java.myh.security.ShiroUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.beans.PropertyEditorSupport;

/**
 * @author 心安
 * @date 2018/5/31 17:37
 */
public class BaseController {

    private User loginUser;

    protected Model model;

    protected User getUser() {
        return loginUser;
    }

    @ModelAttribute
    public void pushWebConfig(Model model) {
        loginUser = ShiroUtils.getUser();
        model.addAttribute("user", getUser());
        this.model = model;
    }

    /**
     * 将传递的参数进行数据绑定
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }

            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? getValue().toString() : "";
            }
        });
    }
}

package com.java.myh.security;

import com.java.myh.model.User;
import com.java.myh.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @author 心安
 * @date 2018/5/31 16:26
 */
public class CustomShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 用户认证
     *
     * @param authenticationToken authenticationToken
     * @return AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String username = authenticationToken.getPrincipal().toString();
        User user = userService.findByUsername(username);
        //用户不存在
        if (user == null) {
            throw new UnknownAccountException();
        }
        //这里验证authenticationToken和simpleAuthenticationInfo的信息 第三个参数为盐
        return new SimpleAuthenticationInfo(username, user.getPassword(), ByteSource.Util.bytes(""), getName());
    }

    /**
     * 角色权限和对应权限添加
     *
     * @param principalCollection PrincipalCollection
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        //查询用户名称
        User user = userService.findByUsername(username);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        for (Role role : user.getRoles()) {
//            //添加角色
//            simpleAuthorizationInfo.addRole(role.getRoleName());
//            for (Permission permission : role.getPermissions()) {
//                //添加权限
//                simpleAuthorizationInfo.addStringPermission(permission.getPermission());
//            }
//        }
        return simpleAuthorizationInfo;
    }
}

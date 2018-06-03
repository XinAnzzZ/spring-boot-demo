//package com.java.myh.model;
//
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
///**
// * @author 心安
// * @date 2018/6/1 15:02
// *
// * 其实我个人认为 一般来说一个用户对应一个角色
// * but 为了扩展性 所以加了这么一张中间表  用来保存用户和角色的对应关系
// * 谁能保证我这个黑心的 Coder 以后不会在自己的系统中加入一个付费才有的角色呢 （手动滑稽）
// */
////@Entity
////@Table(name = "user_role")
////@DynamicInsert
////@DynamicUpdate
//public class UserRole {
//
//    @Column(name = "user_id")
//    private Integer userId;
//
//    @Column(name = "role_id")
//    private Integer roleId;
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public Integer getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(Integer roleId) {
//        this.roleId = roleId;
//    }
//
//    @Override
//    public String toString() {
//        return "UserRole{" +
//                "userId=" + userId +
//                ", roleId=" + roleId +
//                '}';
//    }
//}

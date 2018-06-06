//package com.java.myh.model;
//
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import java.io.Serializable;
//import java.util.Objects;
//
///**
// * @author 心安
// * @date 2018/6/1 15:03
// */
//@Table
//@Entity(name = "role_permission")
//@DynamicUpdate
//@DynamicInsert
//public class RolePermission implements Serializable {
//
//    private static final long serialVersionUID = -345964525164973716L;
//
//    @Column(name = "role_id")
//    private Role role;
//
//    @Column(name = "permission_id")
//    private Permission permission;
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public Permission getPermission() {
//        return permission;
//    }
//
//    public void setPermission(Permission permission) {
//        this.permission = permission;
//    }
//
//    @Override
//    public int hashCode() {
//        //参考 HashMap 源码
//        return Objects.hashCode(this.role) ^ Objects.hashCode(this.permission);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) {
//            return true;
//        }
//        if (obj instanceof RolePermission) {
//            RolePermission r = (RolePermission) obj;
//            return (Objects.equals(r.role, this.role)
//                    && Objects.equals(r.permission, this.permission));
//        }
//        return false;
//    }
//}

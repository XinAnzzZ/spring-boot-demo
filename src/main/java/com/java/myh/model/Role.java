//package com.java.myh.model;
//
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Set;
//
///**
// * @author 心安
// * @date 2018/5/31 16:21
// * 我们可能需要查询拥有某角色的全部用户，所以这里做了双向关联
// */
//@Entity
//@Table(name = "role")
//@DynamicUpdate
//@DynamicInsert
//public class Role implements Serializable {
//
//    private static final long serialVersionUID = -904112445677395644L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column
//    private Integer id;
//
//    @Column(name = "role_name")
//    private String roleName;
//
//    @ManyToMany
//    @JoinTable(name = "user_role",
//            joinColumns = {@JoinColumn(name = "role_id")},
//            inverseJoinColumns = {@JoinColumn(name = "user_id")})
//    private Set<UserRole> userRoles;
//
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Set<RolePermission> rolePermissions;
//
//    public Role() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }
//
//    public Set<UserRole> getUserRoles() {
//        return userRoles;
//    }
//
//    public void setUserRoles(Set<UserRole> userRoles) {
//        this.userRoles = userRoles;
//    }
//}

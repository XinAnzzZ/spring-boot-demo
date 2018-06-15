package com.java.myh.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 心安
 * @date 2018/5/31 16:24
 * 我们不会做通过权限查询哪些角色拥有该权限，只会查询某角色具有哪些权限，
 * 所以只做单向关联。
 */
@Entity
@Table(name = "permission")
@DynamicInsert
@DynamicUpdate
public class Permission implements Serializable {

    private static final long serialVersionUID = 292058624890906301L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "permission_name")
    private String permissionName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}

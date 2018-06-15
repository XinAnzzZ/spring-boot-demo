package com.java.myh.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author 心安
 * @date 2018/6/1 15:02
 * <p>
 * 其实我个人认为 一般来说一个用户对应一个角色
 * but 为了扩展性 所以加了这么一张中间表  用来保存用户和角色的对应关系
 * 谁能保证我这个黑心的 Coder 以后不会在自己的系统中加入一个付费才有的角色呢 （手动滑稽）
 * </p>
 */
@Entity
@Table(name = "user_role")
@DynamicInsert
@DynamicUpdate
@IdClass(UserRole.class)
public class UserRole implements Serializable {

    private static final long serialVersionUID = 97876277223498825L;

    @Id
    @Column(name = "user_id")
    @OneToMany
    private User user;

    @Id
    @Column(name = "role_id")
    private Role role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.role.getId()) ^ Objects.hashCode(this.user.getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UserRole) {
            UserRole u = (UserRole) obj;
            return (Objects.equals(u.user, this.user)
                    && Objects.equals(u.role, this.role));
        }
        return false;
    }
}

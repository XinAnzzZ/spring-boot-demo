package com.java.myh.repository;

import com.java.myh.model.User;

/**
 * @author 心安
 * @date 2018/5/29 17:42
 */
public interface UserRepository extends BaseRepository<User, Integer> {
    /**
     * findByUsername
     *
     * @param username the username
     * @return User
     */
    User findByUsername(String username);
}

package com.wg.japdemo.service;

import com.wg.japdemo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/13 8:51
 * @todo
 */

public interface UserService {
    User saveUser(User user);
    void deleteUser(User user);
    void deleteUser(Long id);
    User updateUser(User user);
    User findUser(Long id);
    List<User> findByNameLike(String name);
    int updateUserBySql(String name ,String phone);
}

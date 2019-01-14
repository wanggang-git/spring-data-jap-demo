package com.wg.japdemo.service;

import com.wg.japdemo.domain.User;
import com.wg.japdemo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.PartTreeJpaQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/13 8:56
 * @todo
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        User user1 =  userRepository.save(user);
        return user1;
    }

    @Override
    public void deleteUser(User user) {
      userRepository.delete(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        //PartTreeJpaQuery.class
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User findUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List findByNameLike(String name) {
        return userRepository.findbySql(name);
    }

    @Override
    public int updateUserBySql(String name, String phone) {
        return userRepository.setNickName(name,phone);
    }
}

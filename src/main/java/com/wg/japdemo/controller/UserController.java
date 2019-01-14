package com.wg.japdemo.controller;

import com.wg.japdemo.domain.User;
import com.wg.japdemo.domain.Wallet;
import com.wg.japdemo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/13 9:03
 * @todo
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;
    @GetMapping("add")
    private User addUser(String nickName,String telNum){
        User user = new User();
        user.setNickname(nickName);
        user.setTelnum(telNum);
        user.setWallet(new Wallet(new BigDecimal(0.5)));
        user.setSignDate(new Date());
        userServiceImpl.saveUser(user);
        return user;
    }
    @GetMapping("del")
    private String delUser(Long id){
        userServiceImpl.deleteUser(id);
        return "SUCCESS";
    }
    @GetMapping("update")
    private User updateUser(Long id,String nickName){
        User user = userServiceImpl.findUser(id);
        user.setNickname(nickName);
        userServiceImpl.updateUser(user);
        return user;
    }
    @GetMapping("find")
    private User findUser(Long id){
        return userServiceImpl.findUser(id);
    }

    @GetMapping("like")
    private List<User> findByNameLike(String name){return  userServiceImpl.findByNameLike(name);}

    @GetMapping("setname")
    private int updateName(String name,String phone){
        System.out.println("name: " + name + " phone: "+ phone);
        return userServiceImpl.updateUserBySql(name,phone);
    }
}

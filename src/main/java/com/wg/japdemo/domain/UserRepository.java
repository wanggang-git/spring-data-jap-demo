package com.wg.japdemo.domain;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/6 14:08
 * @todo
 */
public interface UserRepository extends JpaRepository<User,Long> {
    List<User>findByNickname(String nickName);
    List<User> findByTelnumAndNickname(String phone, String nickName);

    //List<Author> findDistinctByNickNameIgnoreCaseOrPhoneOrderBySignDateDesc(String nickName, String phone);
    List<User> findDistinctByNicknameIgnoreCaseOrTelnumOrderBySignDate(String nickName, String telnum);


    @Query("select a from User a where a.nickname like %:name%")
    List<User> findByNameLike(@Param("name") String name);

    @Query("select a.nickname,length(a.nickname) from User a where a.nickname like %?1%")
    List<Object[]> findArry(String nickName);

    @Query(value = "select * from user where sign_date like %?1%", nativeQuery = true)
    List<User> findbySql(String nickName);

    @Transactional //开启事务
    @Modifying
    @Query("update User a set a.nickname = ?1 where a.telnum = ?2")
    int setNickName(String nickName,String phone);
}

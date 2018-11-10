package com.example.demo.dao;

import com.example.demo.base.BaseDao;
import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseDao<User, Integer> {
    User findByOpenId(String openId);
}

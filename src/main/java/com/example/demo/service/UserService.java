package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User save(User user) {
        return userDao.save(user);
    }

    public User findByOpenId(String openId) {
        return userDao.findByOpenId(openId);
    }

    public User find(Integer id) {
        return userDao.getOne(id);
    }
}

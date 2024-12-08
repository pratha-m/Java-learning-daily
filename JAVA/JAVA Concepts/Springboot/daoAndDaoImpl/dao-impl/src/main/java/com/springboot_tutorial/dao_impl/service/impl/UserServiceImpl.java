package com.springboot_tutorial.dao_impl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot_tutorial.dao_impl.dao.UserDao;
import com.springboot_tutorial.dao_impl.entity.UserEntity;
import com.springboot_tutorial.dao_impl.service.UserService;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity getUserById(Long id) {
        return userDao.getUserById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userDao.createUser(user);
    }
}

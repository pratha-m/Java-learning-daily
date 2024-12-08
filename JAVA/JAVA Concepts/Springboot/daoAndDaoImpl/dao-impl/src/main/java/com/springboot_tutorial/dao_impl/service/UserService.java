package com.springboot_tutorial.dao_impl.service;

import java.util.List;

import com.springboot_tutorial.dao_impl.entity.UserEntity;

public interface UserService {
    UserEntity getUserById(Long id);
    List<UserEntity> getAllUsers();
    UserEntity createUser(UserEntity user);
}

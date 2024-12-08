package com.springboot_tutorial.dao_impl.dao;
import java.util.List;
import java.util.Optional;

import com.springboot_tutorial.dao_impl.entity.UserEntity;

public interface UserDao {
    Optional<UserEntity> getUserById(Long id);
    List<UserEntity> getAllUsers();
    UserEntity createUser(UserEntity user);   
}

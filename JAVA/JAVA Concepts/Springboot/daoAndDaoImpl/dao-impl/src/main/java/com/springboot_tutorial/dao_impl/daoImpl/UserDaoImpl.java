package com.springboot_tutorial.dao_impl.daoImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot_tutorial.dao_impl.dao.UserDao;
import com.springboot_tutorial.dao_impl.entity.UserEntity;
import com.springboot_tutorial.dao_impl.repository.UserRepostory;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepostory userRepository;

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }
}

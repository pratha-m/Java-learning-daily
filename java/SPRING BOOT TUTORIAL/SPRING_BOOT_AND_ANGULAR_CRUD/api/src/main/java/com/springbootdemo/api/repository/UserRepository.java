package com.springbootdemo.api.repository;

import com.springbootdemo.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}

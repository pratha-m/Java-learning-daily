package com.springboot_tutorial.dao_impl.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot_tutorial.dao_impl.entity.UserEntity;

@Repository
public interface UserRepostory extends JpaRepository<UserEntity,Long>{}
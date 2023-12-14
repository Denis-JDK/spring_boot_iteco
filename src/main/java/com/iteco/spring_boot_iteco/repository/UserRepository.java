package com.iteco.spring_boot_iteco.repository;

import com.iteco.spring_boot_iteco.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}

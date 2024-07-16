package com.duan.foodwaste.repository;

import com.duan.foodwaste.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

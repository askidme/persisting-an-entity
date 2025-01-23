package com.codergm.sdj.repository;

import com.codergm.sdj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

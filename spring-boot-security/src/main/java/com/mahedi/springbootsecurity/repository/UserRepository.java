package com.mahedi.springbootsecurity.repository;

import com.mahedi.springbootsecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}

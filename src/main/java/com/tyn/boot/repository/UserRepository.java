package com.tyn.boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyn.boot.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByName(String name);
}

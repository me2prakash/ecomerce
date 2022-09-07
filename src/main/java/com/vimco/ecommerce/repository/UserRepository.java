package com.vimco.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vimco.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findAll();

	User findByEmail(String email);

	User findUserByEmail(String email);
}

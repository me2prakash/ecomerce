package com.vimco.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vimco.ecommerce.model.AuthenticationToken;
import com.vimco.ecommerce.model.User;

public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
	AuthenticationToken findTokenByUser(User user);

	AuthenticationToken findTokenByToken(String token);
}

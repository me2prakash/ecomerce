package com.vimco.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vimco.ecommerce.dto.ResponseDto;
import com.vimco.ecommerce.dto.user.SignInDto;
import com.vimco.ecommerce.dto.user.SignInResponseDto;
import com.vimco.ecommerce.dto.user.SignUpDto;
import com.vimco.ecommerce.exceptions.AuthenticationFailException;
import com.vimco.ecommerce.exceptions.CustomException;
import com.vimco.ecommerce.model.User;
import com.vimco.ecommerce.repository.UserRepository;
import com.vimco.ecommerce.service.AuthenticationService;
import com.vimco.ecommerce.service.UserService;

@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	UserService userService;
	//localhost:8081/test
	@GetMapping("/test")
	public void test() {
		System.out.println("1");
	}
//localhost:8081/all
	@GetMapping("/all")
	public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
		authenticationService.authenticate(token);
		return userRepository.findAll();
	}

    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody SignUpDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
	}

	// TODO token should be updated
	@PostMapping("/signIn")
	public SignInResponseDto SignUp(@RequestBody SignInDto signInDto) throws CustomException {
		return userService.signIn(signInDto);
	}
}


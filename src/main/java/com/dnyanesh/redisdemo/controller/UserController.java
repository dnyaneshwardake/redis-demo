package com.dnyanesh.redisdemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnyanesh.redisdemo.model.User;
import com.dnyanesh.redisdemo.repository.UserJpaRepository;
import com.dnyanesh.redisdemo.repository.UserRedisRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRedisRepository userRedisRepository;

	@Autowired
	private UserJpaRepository userJpaRepository;

	@GetMapping("{id}")
	private User getUser(@PathVariable Integer id) {
		return userRedisRepository.findById(id);
	}

	@GetMapping
	private Map<Integer, User> getAll() {
		return userRedisRepository.findAll();
	}

	@PostMapping
	private List<User> addUser(@RequestBody User user) {
		userRedisRepository.save(user);
		userJpaRepository.save(user);
		return userJpaRepository.findAll();
	}
}

package com.dnyanesh.redisdemo.repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.dnyanesh.redisdemo.model.User;

@Repository
public class UserRedisRepository {

	private HashOperations<String, Integer, User> hashOperations;

	public UserRedisRepository(RedisTemplate<String, User> redisTemplate) {
		this.hashOperations = redisTemplate.opsForHash();
	}

	public String save(User user) {
		hashOperations.put("USER", user.getId(), user);
		return "success";
	}

	public String update(User user) {
		return save(user);
	}

	public String delete(String id) {
		hashOperations.delete("USER", id);
		return "success";
	}

	public User findById(Integer id) {
		return (User) hashOperations.get("USER", id);
	}

	public Map<Integer, User> findAll() {
		return hashOperations.entries("USER");
	}

}

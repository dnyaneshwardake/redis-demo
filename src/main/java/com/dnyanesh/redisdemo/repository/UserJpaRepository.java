package com.dnyanesh.redisdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnyanesh.redisdemo.model.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {

}

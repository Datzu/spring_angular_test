package com.example.demo.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.api.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}
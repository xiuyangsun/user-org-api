package com.user.org.demo.userorgapp.repository;

import com.user.org.demo.userorgapp.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

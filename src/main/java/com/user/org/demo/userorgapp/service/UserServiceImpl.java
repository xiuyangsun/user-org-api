package com.user.org.demo.userorgapp.service;

import com.user.org.demo.userorgapp.entity.User;
import com.user.org.demo.userorgapp.repository.UserRepository;
import com.user.org.demo.userorgapp.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {

        Iterable<User> usersI = userRepository.findAll();
        List<User> users = Mapper.mapAll(usersI, User.class);
        return users;
    }

    @Override
    public User findUserById(int theId) {
        User user = userRepository.findById(theId).orElse(null);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User id not found -" + theId);
        }
        return user;
    }

    @Override
    public void saveUser(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public void deleteUserById(int theId) {
        userRepository.deleteById(theId);
    }

}

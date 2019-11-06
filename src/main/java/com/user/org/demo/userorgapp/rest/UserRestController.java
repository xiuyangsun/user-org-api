package com.user.org.demo.userorgapp.rest;

import com.user.org.demo.userorgapp.DTO.request.UserReq;
import com.user.org.demo.userorgapp.DTO.response.SuccessRes;
import com.user.org.demo.userorgapp.DTO.response.UserRes;
import com.user.org.demo.userorgapp.entity.User;
import com.user.org.demo.userorgapp.service.UserService;
import com.user.org.demo.userorgapp.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    private UserService userService;

    /*
     * CRUD function end points for users
     */

    // expose "/users" and return list of users

    @GetMapping
    public ResponseEntity<List<UserRes>> findAllUsers() {

        List<User> users = userService.findAllUsers();
        List<UserRes> res = Mapper.mapAll(users, UserRes.class);

        return ResponseEntity.ok(res);
    }

    // expose "/users/{userId} and return single user using Id

    @GetMapping("/{userId}")
    public ResponseEntity<UserRes> getUser(@PathVariable @Positive int userId) {
        User theUser = userService.findUserById(userId);

        UserRes res = Mapper.map(theUser, UserRes.class);

        return ResponseEntity.ok(res);
    }

    // expose "/users" for POST to add new user;

    @PostMapping
    public ResponseEntity<UserRes> addUser(@RequestBody @Valid UserReq userReq) {
        User user = Mapper.map(userReq, User.class);
        userService.saveUser(user);

        UserRes res = Mapper.map(user, UserRes.class);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(res);
    }

    // expose "/users" for PUT to update user;

    @PutMapping("/{userId}")
    public ResponseEntity<UserRes> updateUser(@RequestBody @Valid UserReq userReq, @PathVariable @Positive int userId) {

        User user = userService.findUserById(userId);

        user.setFirstName(userReq.getFirstName());
        user.setLastName(userReq.getLastName());
        user.setAddress(userReq.getAddress());
        user.setEmail(userReq.getEmail());
        user.setAddress(userReq.getAddress());

        userService.saveUser(user);

        UserRes userRes = Mapper.map(user, UserRes.class);

        return ResponseEntity.ok(userRes);
    }

    // expose "/users/{userId}" to delete an existing user;

    @DeleteMapping("/{userId}")
    public ResponseEntity<SuccessRes> deleteUser(@PathVariable @Positive int userId) {
        //Validate user existence
        userService.findUserById(userId);

        userService.deleteUserById(userId);

        SuccessRes successRes = new SuccessRes();
        successRes.setMessage(String.format("User with id - %s deleted successfully!", userId));

        return ResponseEntity.ok(successRes);
    }
}

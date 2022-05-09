package io.myweb.travelclub.controller;

import io.myweb.travelclub.entity.club.User;
import io.myweb.travelclub.service.UserService;
import io.myweb.travelclub.service.sdo.UserCdo;
import io.myweb.travelclub.shared.NameValueList;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public String register(@RequestBody UserCdo userCdo){
        return userService.registerUser(userCdo);
    }

    @GetMapping("/users/{userId}")
    public User find(@PathVariable String userId){
        return userService.findUserById(userId);
    }

    @GetMapping("/users")
    public User findByEmail(@RequestParam("email") String email){
        return userService.findUserByEmail(email);
    }

//    @GetMapping("/user")
//    public List<User> findByName(@RequestParam("name") String name){
//        return userService.findUsersByName(name);
//    }

    @PutMapping("/users/{userId}")
    public void modify(@PathVariable String userId, @RequestBody NameValueList nameValueList){
        userService.modifyUser(userId, nameValueList);
    }

    @DeleteMapping("/users/{userId}")
    public void delete(@PathVariable String userId){
        userService.removeUser(userId);
    }
}

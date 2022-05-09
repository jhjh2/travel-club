package io.myweb.travelclub.service;

import io.myweb.travelclub.entity.club.User;
import io.myweb.travelclub.service.sdo.UserCdo;
import io.myweb.travelclub.shared.NameValueList;

import java.util.List;

public interface UserService {

    String registerUser(UserCdo userCdo);
    User findUserById(String userId);
    User findUserByEmail(String userEmail);
    List<User> findUsersByName(String name);
    void modifyUser(String userId, NameValueList nameValueList);
    void removeUser(String userId);
}

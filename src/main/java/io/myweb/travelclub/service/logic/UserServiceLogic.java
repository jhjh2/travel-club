package io.myweb.travelclub.service.logic;

import io.myweb.travelclub.entity.club.User;
import io.myweb.travelclub.service.UserService;
import io.myweb.travelclub.service.sdo.UserCdo;
import io.myweb.travelclub.shared.NameValueList;
import io.myweb.travelclub.store.UserStore;
import io.myweb.travelclub.util.exception.NoSuchUserException;
import io.myweb.travelclub.util.exception.UserDuplicationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceLogic implements UserService {

    private final UserStore userStore;

    public UserServiceLogic(UserStore userStore){
        this.userStore = userStore;
    }

    @Override
    public String registerUser(UserCdo userCdo) {
        String email = userCdo.getEmail();
        User foundUser = userStore.retrieveByEmail(email);
        if(foundUser != null){
            throw new UserDuplicationException("User already exists with email : " + email);
        }
        foundUser = new User(userCdo.getEmail(), userCdo.getName(), userCdo.getPhoneNumber());
        foundUser.setNickName(userCdo.getNickName());
        foundUser.setBirthDay(userCdo.getBirthDay());

        foundUser.checkValidation();

        return userStore.create(foundUser);
    }

    @Override
    public User findUserById(String userId) {
        return userStore.retrieve(userId);
    }

    @Override
    public User findUserByEmail(String userEmail) {
        return userStore.retrieveByEmail(userEmail);
    }

    @Override
    public List<User> findUsersByName(String name) {
        return userStore.retrieveByName(name);
    }

    @Override
    public void modifyUser(String userId, NameValueList nameValueList) {
        User targetUser = userStore.retrieve(userId);
        if(targetUser == null){
            throw new NoSuchUserException("No such user with id : " + userId);
        }
        targetUser.modifyValues(nameValueList);
        userStore.update(targetUser);
    }

    @Override
    public void removeUser(String userId) {
        if(!userStore.exists(userId)){
            throw new NoSuchUserException("No such user with id : " + userId);
        }
        userStore.delete(userId);
    }
}

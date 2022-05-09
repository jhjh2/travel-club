package io.myweb.travelclub.store.mapstore;

import io.myweb.travelclub.entity.club.User;
import io.myweb.travelclub.store.UserStore;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class UserMapStore implements UserStore {

    private Map<String, User> userMap;

    public UserMapStore(){
        this.userMap= new LinkedHashMap<>();
    }

    @Override
    public String create(User member) {
        return null;
    }

    @Override
    public User retrieve(String memberId) {
        return null;
    }

    @Override
    public User retrieveByEmail(String email) {
        return null;
    }

    @Override
    public List<User> retrieveByName(String name) {
        return null;
    }

    @Override
    public void update(User member) {

    }

    @Override
    public void delete(String email) {

    }

    @Override
    public boolean exists(String memberId) {
        return false;
    }
}

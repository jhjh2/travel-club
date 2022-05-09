package io.myweb.travelclub.store;

import io.myweb.travelclub.entity.club.User;
import io.myweb.travelclub.store.jpastore.jpo.UserJpo;

import java.util.List;
import java.util.Optional;

public interface UserStore {

    String create(User user);
    User retrieve(String userId);
    User retrieveByEmail(String email);
    List<User> retrieveByName(String name);
    void update(User user);
    void delete(String userId);

    boolean exists(String userId);
}

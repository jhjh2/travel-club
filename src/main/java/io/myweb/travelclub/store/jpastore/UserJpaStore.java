package io.myweb.travelclub.store.jpastore;

import io.myweb.travelclub.entity.club.User;
import io.myweb.travelclub.store.UserStore;
import io.myweb.travelclub.store.jpastore.jpo.UserJpo;
import io.myweb.travelclub.store.jpastore.repository.UserRepository;
import io.myweb.travelclub.util.exception.NoSuchUserException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserJpaStore implements UserStore {

    private UserRepository userRepository;

    public UserJpaStore(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public String create(User user) {
        userRepository.save(new UserJpo(user));
        return user.getId();
    }

    @Override
    public User retrieve(String userId) {
        User user = null;
        Optional<UserJpo> userJpo = userRepository.findById(userId);
        if(userJpo.isPresent()) {
            user = userJpo.get().toDomain();
        }
        return user;
    }

    @Override
    public User retrieveByEmail(String email) {
        User user = null;
        Optional<UserJpo> userJpo = userRepository.findByEmail(email);
        if(userJpo.isPresent()) {
            user = userJpo.get().toDomain();
        }
        return user;
    }

    @Override
    public List<User> retrieveByName(String name) {
        List<UserJpo> userJpos = userRepository.findAllByName(name);
        return userJpos.stream().map(UserJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public void update(User user) {
        userRepository.save(new UserJpo(user));
    }

    @Override
    public void delete(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public boolean exists(String userId) {
        return userRepository.existsById(userId);
    }
}

package io.myweb.travelclub.store.jpastore.repository;

import io.myweb.travelclub.store.jpastore.jpo.UserJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserJpo, String> {
    Optional<UserJpo> findByEmail(String email);
    List<UserJpo> findAllByName(String name);
}

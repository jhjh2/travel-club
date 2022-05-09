package io.myweb.travelclub.store.jpastore.repository;

import io.myweb.travelclub.store.jpastore.jpo.TravelClubJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<TravelClubJpo, String> {
    List<TravelClubJpo> findAllByName(String name);
}

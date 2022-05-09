package io.myweb.travelclub.store.jpastore.repository;

import io.myweb.travelclub.store.jpastore.jpo.MembershipJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MembershipRepository extends JpaRepository<MembershipJpo, String> {
    Optional<MembershipJpo> findByClubIdAndUserId(String clubId, String userId);
    Optional<MembershipJpo> findByClubIdAndUserEmail(String clubId, String userEmail);
    List<MembershipJpo> findAllByClubId(String clubId);
    List<MembershipJpo> findAllByUserId(String userId);


}

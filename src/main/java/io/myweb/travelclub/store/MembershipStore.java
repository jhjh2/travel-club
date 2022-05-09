package io.myweb.travelclub.store;

import io.myweb.travelclub.entity.club.Membership;

import java.util.List;

public interface MembershipStore {

    String create(Membership membership);
    Membership retrieve(String membershipId);
    Membership retrieveByClubIdAndUserId(String clubId, String userId);
    Membership retrieveByClubIdAndUserEmail(String clubId, String userEmail);
    List<Membership> retrieveByClubId(String clubId);
    List<Membership> retrieveByUserId(String userId);
    void update(Membership membership);
    void delete(String membershipId);

    boolean exists(String membershipId);
}

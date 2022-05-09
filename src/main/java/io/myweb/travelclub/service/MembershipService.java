package io.myweb.travelclub.service;

import io.myweb.travelclub.entity.club.Membership;
import io.myweb.travelclub.service.sdo.MembershipCdo;
import io.myweb.travelclub.shared.NameValueList;

import java.util.List;

public interface MembershipService {

    String registerMembership(MembershipCdo membershipCdo);
    Membership findMembership(String membershipId);
    Membership findMembershipByClubIdAndUserId(String clubId, String userId);
    Membership findMembershipByClubIdAndUserEmail(String clubId, String userEmail);
    List<Membership> findAllMembershipsOfClub(String clubId);
    List<Membership> findAllMembershipsOfUser(String userId);
    void modifyMembership(String membershipId, NameValueList nameValueList);
    void removeMembership(String membershipId);
}

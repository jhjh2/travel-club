package io.myweb.travelclub.service.logic;

import io.myweb.travelclub.entity.club.Membership;
import io.myweb.travelclub.service.MembershipService;
import io.myweb.travelclub.service.sdo.MembershipCdo;
import io.myweb.travelclub.shared.NameValueList;
import io.myweb.travelclub.store.MembershipStore;
import io.myweb.travelclub.util.exception.NoSuchMembershipException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipServiceLogic implements MembershipService {

    private final MembershipStore membershipStore;

    public MembershipServiceLogic(MembershipStore membershipStore){
        this.membershipStore = membershipStore;
    }

    @Override
    public String registerMembership(MembershipCdo membershipCdo) {
        Membership newMembership = new Membership(membershipCdo.getClubId(), membershipCdo.getUserId());
        return membershipStore.create(newMembership);
    }

    @Override
    public Membership findMembership(String membershipId) {
        return membershipStore.retrieve(membershipId);
    }

    @Override
    public Membership findMembershipByClubIdAndUserId(String clubId, String userId) {
        return membershipStore.retrieveByClubIdAndUserId(clubId, userId);
    }

    @Override
    public Membership findMembershipByClubIdAndUserEmail(String clubId, String userEmail) {
        return membershipStore.retrieveByClubIdAndUserEmail(clubId, userEmail);
    }

    @Override
    public List<Membership> findAllMembershipsOfClub(String clubId) {
        return membershipStore.retrieveByClubId(clubId);
    }

    @Override
    public List<Membership> findAllMembershipsOfUser(String userId) {
        return membershipStore.retrieveByUserId(userId);
    }

    @Override
    public void modifyMembership(String membershipId, NameValueList nameValueList) {
        Membership targetMembership = membershipStore.retrieve(membershipId);
        if(targetMembership == null){
            throw new NoSuchMembershipException("No such membership with id : " + membershipId);
        }
        targetMembership.modifyValues(nameValueList);
        membershipStore.update(targetMembership);
    }

    @Override
    public void removeMembership(String membershipId) {
        if(!membershipStore.exists(membershipId)){
            throw new NoSuchMembershipException("No such membership with id : " + membershipId);
        }
        membershipStore.delete(membershipId);
    }
}

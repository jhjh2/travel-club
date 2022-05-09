package io.myweb.travelclub.controller;

import io.myweb.travelclub.entity.club.Membership;
import io.myweb.travelclub.service.MembershipService;
import io.myweb.travelclub.service.sdo.MembershipCdo;
import io.myweb.travelclub.shared.NameValueList;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MembershipController {

    private final MembershipService membershipService;

    public MembershipController(MembershipService membershipService){
        this.membershipService = membershipService;
    }

    @PostMapping("/memberships")
    public String register(@RequestBody MembershipCdo membershipCdo){
        return membershipService.registerMembership(membershipCdo);
    }

    @GetMapping("/memberships/{membershipId}")
    public Membership find(@PathVariable String membershipId){
        return membershipService.findMembership(membershipId);
    }

//    @GetMapping("/memberships")
//    public Membership findByOptions(MembershipCdo membershipCdo){ //이거 맞나?
//        Membership foundMembership = null;
//        if(membershipCdo.getUserId() != null) {
//            foundMembership = membershipService.findMembershipByClubIdAndUserId(membershipCdo.getClubId(), membershipCdo.getUserId());
//        } else if (membershipCdo.getUserEmail() != null) {
//            foundMembership = membershipService.findMembershipByClubIdAndUserEmail(membershipCdo.getClubId(), membershipCdo.getUserEmail());
//        }
//        return foundMembership;
//    }

    @GetMapping("/clubs/{clubId}/memberships")
    public Membership findByClubIdAndUserId(@PathVariable String clubId, @RequestParam String userId){
        return membershipService.findMembershipByClubIdAndUserId(clubId, userId);
    }

    @GetMapping("/clubs/{clubId}/memberships")
    public Membership findByClubIdAndUserEmail(@PathVariable String clubId, @RequestParam String userEmail){
        return membershipService.findMembershipByClubIdAndUserEmail(clubId, userEmail);
    }

    @GetMapping("/clubs/{clubId}/memberships/all")
    public List<Membership> findAllMembershipsOfClub(@PathVariable String clubId){
        return membershipService.findAllMembershipsOfClub(clubId);
    }

    @GetMapping("/users/{userId}/memberships/all")
    public List<Membership> findAllMembershipsOfUser(@PathVariable String userId){
        return membershipService.findAllMembershipsOfUser(userId);
    }

    @PutMapping("/memberships/{membershipId}")
    public void modify(@PathVariable String membershipId, @RequestBody NameValueList nameValueList){
        membershipService.modifyMembership(membershipId, nameValueList);
    }

    @DeleteMapping("/memberships/{membershipId}")
    public void delete(@PathVariable String membershipId){
        membershipService.removeMembership(membershipId);
    }
}

package io.myweb.travelclub.store.jpastore;

import io.myweb.travelclub.entity.club.Membership;
import io.myweb.travelclub.store.MembershipStore;
import io.myweb.travelclub.store.jpastore.jpo.MembershipJpo;
import io.myweb.travelclub.store.jpastore.repository.MembershipRepository;
import io.myweb.travelclub.util.exception.NoSuchMembershipException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MembershipJpaStore implements MembershipStore {

    private MembershipRepository membershipRepository;

    public MembershipJpaStore(MembershipRepository membershipRepository){
        this.membershipRepository = membershipRepository;
    }

    @Override
    public String create(Membership membership) {
        membershipRepository.save(new MembershipJpo(membership));
        return membership.getId();
    }

    @Override
    public Membership retrieve(String membershipId) {
        Optional<MembershipJpo> membershipJpo = membershipRepository.findById(membershipId);
        if(!membershipJpo.isPresent()){
            throw new NoSuchMembershipException(String.format("Membership(%s) is not found.",membershipId));
        }
        return membershipJpo.get().toDomain();
    }

    @Override
    public Membership retrieveByClubIdAndUserId(String clubId, String userId) {
        Optional<MembershipJpo> membershipJpo = membershipRepository.findByClubIdAndUserId(clubId, userId);
        if(!membershipJpo.isPresent()){
            throw new NoSuchMembershipException(String.format("User(%s) is not a member of the club(%s).",userId, clubId));
        }
        return membershipJpo.get().toDomain();
    }

    @Override
    public Membership retrieveByClubIdAndUserEmail(String clubId, String userEmail) {
        Optional<MembershipJpo> membershipJpo = membershipRepository.findByClubIdAndUserEmail(clubId, userEmail);
        if(!membershipJpo.isPresent()){
            throw new NoSuchMembershipException(String.format("User(%s) is not a member of the club(%s).",userEmail, clubId));
        }
        return membershipJpo.get().toDomain();
    }

    @Override
    public List<Membership> retrieveByClubId(String clubId) {
        List<MembershipJpo> membershipJpos = membershipRepository.findAllByClubId(clubId);
        return membershipJpos.stream().map(MembershipJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Membership> retrieveByUserId(String userId) {
        List<MembershipJpo> membershipJpos = membershipRepository.findAllByUserId(userId);
        return membershipJpos.stream().map(MembershipJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public void update(Membership membership) {
        membershipRepository.save(new MembershipJpo(membership));
    }

    @Override
    public void delete(String membershipId) {
        membershipRepository.deleteById(membershipId);
    }

    @Override
    public boolean exists(String membershipId) {
        return membershipRepository.existsById(membershipId);
    }
}

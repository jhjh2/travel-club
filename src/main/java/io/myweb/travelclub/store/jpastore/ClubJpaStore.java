package io.myweb.travelclub.store.jpastore;

import io.myweb.travelclub.entity.club.TravelClub;
import io.myweb.travelclub.store.ClubStore;
import io.myweb.travelclub.store.jpastore.jpo.TravelClubJpo;
import io.myweb.travelclub.store.jpastore.repository.ClubRepository;
import io.myweb.travelclub.util.exception.NoSuchClubException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClubJpaStore implements ClubStore {

    private ClubRepository clubRepository;

    public ClubJpaStore(ClubRepository clubRepository){
        this.clubRepository = clubRepository;
    }

    @Override
    public String create(TravelClub club) {
        clubRepository.save(new TravelClubJpo(club));
        return club.getId();
    }

    @Override
    public TravelClub retrieve(String clubId) {
        Optional<TravelClubJpo> clubJpo = clubRepository.findById(clubId);
        if(!clubJpo.isPresent()){
            throw new NoSuchClubException(String.format("TravelClub(%s) is not found.", clubId));
        }
        return clubJpo.get().toDomain();
    }

    @Override
    public List<TravelClub> retrieveByName(String name) {
        List<TravelClubJpo> clubJpos = clubRepository.findAllByName(name);
        //return clubJpos.stream().map(travelClubJpo -> travelClubJpo.toDomain()).collect(Collectors.toList());
        return clubJpos.stream().map(TravelClubJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<TravelClub> retrieveAll() {
        List<TravelClubJpo> clubJpos = clubRepository.findAll();
        //return clubJpos.stream().map(clubJpo -> clubJpo.toDomain()).collect(Collectors.toList());
        return clubJpos.stream().map(TravelClubJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public void update(TravelClub club) {
        clubRepository.save(new TravelClubJpo(club));
    }

    @Override
    public void delete(String clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public boolean exists(String clubId) {
        return clubRepository.existsById(clubId);
    }
}

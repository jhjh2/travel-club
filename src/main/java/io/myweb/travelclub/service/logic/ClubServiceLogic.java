package io.myweb.travelclub.service.logic;

import io.myweb.travelclub.entity.club.TravelClub;
import io.myweb.travelclub.service.ClubService;
import io.myweb.travelclub.service.sdo.TravelClubCdo;
import io.myweb.travelclub.shared.NameValueList;
import io.myweb.travelclub.store.ClubStore;
import io.myweb.travelclub.store.mapstore.ClubMapStore;
import io.myweb.travelclub.util.exception.NoSuchClubException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceLogic implements ClubService {

    private final ClubStore clubStore;

    public ClubServiceLogic(ClubStore clubStore) {
        this.clubStore = clubStore;
    }

    @Override
    public String registerClub(TravelClubCdo travelClubCdo) {
        TravelClub newClub = new TravelClub(travelClubCdo.getName(), travelClubCdo.getIntro());
        newClub.checkValidation();
        return clubStore.create(newClub);
    }

    @Override
    public TravelClub findClubById(String id) {
        return clubStore.retrieve(id);
    }

    @Override
    public List<TravelClub> findClubsByName(String name) {
        return clubStore.retrieveByName(name);
    }

    @Override
    public List<TravelClub> findAll(){
        return clubStore.retrieveAll();
    }

    @Override
    public void modify(String clubId, NameValueList nameValues) {
        TravelClub foundClub = clubStore.retrieve(clubId);
        if(foundClub == null){
            throw new NoSuchClubException("No such club with id : " + clubId);
        }
        foundClub.modifyValues(nameValues);
        foundClub.checkValidation();
        clubStore.update(foundClub);
    }

    @Override
    public void remove(String clubId) {
        if(!clubStore.exists(clubId)){
            throw new NoSuchClubException("No such club with id : " + clubId);
        }
        clubStore.delete(clubId);
    }
}

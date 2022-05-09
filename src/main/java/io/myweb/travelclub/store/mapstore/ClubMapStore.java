package io.myweb.travelclub.store.mapstore;

import io.myweb.travelclub.entity.club.TravelClub;
import io.myweb.travelclub.store.ClubStore;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class ClubMapStore implements ClubStore {

    private Map<String, TravelClub> clubMap;

    public ClubMapStore() {
        this.clubMap = new LinkedHashMap<>();
    }

    @Override
    public String create(TravelClub club) {
        return null;
    }

    @Override
    public TravelClub retrieve(String clubId) {
        return null;
    }

    @Override
    public List<TravelClub> retrieveByName(String name) {
        return null;
    }

    @Override
    public List<TravelClub> retrieveAll(){
        //
        return null;
    }

    @Override
    public void update(TravelClub club) {

    }

    @Override
    public void delete(String clubId) {

    }

    @Override
    public boolean exists(String clubId) {
        return false;
    }
}

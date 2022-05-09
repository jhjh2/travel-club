package io.myweb.travelclub.service;

import io.myweb.travelclub.entity.club.TravelClub;
import io.myweb.travelclub.service.sdo.TravelClubCdo;
import io.myweb.travelclub.shared.NameValueList;

import java.util.List;

public interface ClubService {

    String registerClub(TravelClubCdo club);
    TravelClub findClubById(String id);
    List<TravelClub> findClubsByName(String name);
    List<TravelClub> findAll();
    void modify(String clubId, NameValueList nameValues);
    void remove(String clubId);
}

package io.myweb.travelclub.controller;

import io.myweb.travelclub.entity.club.TravelClub;
import io.myweb.travelclub.service.ClubService;
import io.myweb.travelclub.service.sdo.TravelClubCdo;
import io.myweb.travelclub.shared.NameValueList;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService){
        this.clubService = clubService;
    }

    @PostMapping("/clubs")
    public String register(@RequestBody TravelClubCdo travelClubCdo){
        return clubService.registerClub(travelClubCdo);
    }

    @GetMapping("/clubs/all")
    public List<TravelClub> findAll(){
        return clubService.findAll();
    }

    @GetMapping("/clubs/{clubId}") // http://localhost:8090/
    public TravelClub find(@PathVariable String clubId){
        return clubService.findClubById(clubId);
    }

    @GetMapping("/clubs") // http://localhost:8090?name=
    public List<TravelClub> findByName(@RequestParam String name){
        return clubService.findClubsByName(name);
    }

    @PutMapping("/clubs/{clubId}")
    public void modify(@PathVariable String clubId, @RequestBody NameValueList nameValueList){
        clubService.modify(clubId, nameValueList);
    }

    @DeleteMapping("/clubs/{clubId}")
    public void delete(@PathVariable String clubId){
        clubService.remove(clubId);
    }
}

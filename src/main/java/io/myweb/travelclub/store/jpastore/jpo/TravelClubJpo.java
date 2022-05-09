package io.myweb.travelclub.store.jpastore.jpo;

import io.myweb.travelclub.entity.club.TravelClub;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="TRAVEL_CLUBS")
public class TravelClubJpo {

    @Id
    private String id;
    private String name;
    private String intro;
    private long foundationTime;

    public TravelClubJpo(TravelClub travelClub){
       /* this.id = travelClub.getId();
        this.name = travelClub.getName();
        this.intro = travelClub.getIntro();
        this.foundationTime = travelClub.getFoundationTime();*/
        BeanUtils.copyProperties(travelClub, this);
    }

    public TravelClub toDomain(){
        TravelClub travelClub = new TravelClub(this.name, this.intro);
        travelClub.setId(this.id);
        travelClub.setFoundationTime(this.foundationTime);
        return travelClub;
    }
}

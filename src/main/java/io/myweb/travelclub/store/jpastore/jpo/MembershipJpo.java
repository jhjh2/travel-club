package io.myweb.travelclub.store.jpastore.jpo;

import io.myweb.travelclub.entity.club.Membership;
import io.myweb.travelclub.entity.club.TravelClub;
import io.myweb.travelclub.entity.club.User;
import io.myweb.travelclub.entity.club.vo.RoleInClub;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity // 데이터베이스 엔티티 객체
@Getter
@Setter
@NoArgsConstructor
@Table(name="MEMBERSHIPS")
public class MembershipJpo {
    @Id // 데이터 구분 식별자
    private String id;
    private String clubId;
    private String userId;
    @Enumerated(EnumType.STRING)
    private RoleInClub role;
    private String joinDate;

    public MembershipJpo(Membership membership){
        BeanUtils.copyProperties(membership, this);
    }

    public Membership toDomain(){
        Membership membership = new Membership(this.clubId, this.userId);
        membership.setId(this.id);
        membership.setRole(this.role);
        membership.setJoinDate(this.joinDate);
        return membership;
    }
}

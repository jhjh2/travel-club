package io.myweb.travelclub.service.sdo;

import io.myweb.travelclub.entity.club.vo.RoleInClub;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipCdo {

    private String clubId;
    private String userId;
    private RoleInClub role;

    private String userEmail;
}

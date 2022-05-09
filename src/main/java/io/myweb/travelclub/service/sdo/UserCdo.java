package io.myweb.travelclub.service.sdo;

import io.myweb.travelclub.entity.club.vo.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCdo {

    private String email;
    private String name;
    private String nickName;
    private String phoneNumber;
    private String birthDay;
    //private List<Address> addresses;
}

package io.myweb.travelclub.store.jpastore.jpo;

import io.myweb.travelclub.entity.club.User;
import io.myweb.travelclub.entity.club.vo.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="USERS")
public class UserJpo {

    @Id
    private String id;
    private String email;
    private String name;
    private String phoneNumber;
    private String nickName;
    private String birthDay;
    //private List<Address> addresses;

    public UserJpo(User user){
        BeanUtils.copyProperties(user,this);
    }

    public User toDomain(){
        User user = new User(this.email, this.name, this.phoneNumber);
        user.setId(this.id);
        user.setNickName(this.nickName);
        user.setBirthDay(this.birthDay);
        return user;
    }
}

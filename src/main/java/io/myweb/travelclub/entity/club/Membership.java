package io.myweb.travelclub.entity.club;

import com.google.gson.Gson;
import io.myweb.travelclub.entity.Entity;
import io.myweb.travelclub.entity.club.vo.RoleInClub;
import io.myweb.travelclub.shared.NameValue;
import io.myweb.travelclub.shared.NameValueList;
import io.myweb.travelclub.util.helper.DateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Membership extends Entity {

    private String clubId;
    private String userId;
    private RoleInClub role;
    private String joinDate;

    public Membership(String id) {
        //
        super(id);
    }

    public Membership(String clubId, String userId) {
        //
        this.clubId = clubId;
        this.userId = userId;
        this.role = RoleInClub.Member;
        this.joinDate = DateUtil.today();
    }

    @Override
    public String toString() {
        //
        StringBuilder builder = new StringBuilder();

        builder.append("club Id:").append(clubId);
        builder.append(", user Id:").append(userId);
        builder.append(", role:").append(role.name());
        builder.append(", join date:").append(joinDate);

        return builder.toString();
    }

    public void modifyValues(NameValueList nameValueList) {
        //
        for (NameValue nameValue : nameValueList.getNameValues()) {
            String value = nameValue.getValue();
            switch (nameValue.getName()) {
                case "role":
                    this.role = RoleInClub.valueOf(value);
                    break;
            }
        }
    }

    public static Membership sample() {
        //
        return new Membership(
                TravelClub.sample().getId(),
                User.sample().getId()
        );
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toString());
        System.out.println(new Gson().toJson(sample()));
    }
}

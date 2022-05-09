import io.myweb.travelclub.service.UserService;
import io.myweb.travelclub.service.sdo.UserCdo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceLogicTest {

    @Autowired
    private UserService userService;
    private String kimId;

    @BeforeEach
    public void setUp() {
        kimId = this.userService.registerUser(new UserCdo("kim@mail.com","kim","kim00","010-1111-1111","2001.01.01"));
    }

    @Test
    public void registerTest() {
        String newUserId = this.userService.registerUser(
                new UserCdo("lee@mail.com","lee","lee00","010-2222-2222","2002.02.02"));
        assertThat(this.userService.findUserByEmail("lee@mail.com").getId()).isEqualTo(newUserId);

        this.userService.removeUser(newUserId);
    }

    @AfterEach
    public void tearDown() {
        this.userService.removeUser(kimId);
    }
}

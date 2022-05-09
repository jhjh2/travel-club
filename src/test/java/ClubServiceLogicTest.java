import io.myweb.travelclub.service.ClubService;
import io.myweb.travelclub.service.sdo.TravelClubCdo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClubServiceLogicTest {

    @Autowired
    private ClubService clubService;
    private String sampleClubId;

    @BeforeEach
    public void setUp() {
        this.sampleClubId = this.clubService.registerClub(new TravelClubCdo("Sample Club","Sample Club Intro"));
    }

    @Test
    public void registerTest() {
        String clubId = this.clubService.registerClub(new TravelClubCdo("Java Club","Java Club Intro"));
        assertThat(this.clubService.findClubById(clubId).getIntro()).isEqualTo("Java Club Intro");
    }

    @AfterEach
    public void tearDown() {
        this.clubService.remove(sampleClubId);
    }
}

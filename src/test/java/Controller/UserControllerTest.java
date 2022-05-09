package Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.myweb.travelclub.service.sdo.UserCdo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private UserCdo kim;

    private String kimId;

    @BeforeEach
    void setUp() throws Exception {
        this.kim = new UserCdo("kim@mail.com","kim","kim00","010-1111-1111","2001.01.01");
        String content = objectMapper.writeValueAsString(kim);
        mockMvc.perform(post("/users")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void register() throws Exception {
        UserCdo newUserCdo = new UserCdo("lee@mail.com","lee","lee00","010-2222-2222","2002.02.02");
        String content = objectMapper.writeValueAsString(newUserCdo);
        mockMvc.perform(post("/users")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @AfterEach
    void tearDown() throws Exception {
        mockMvc.perform(delete("/users/" + kimId));
    }
}

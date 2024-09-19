package org.globallogic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.globallogic.beans.others.Phone;
import org.globallogic.beans.response.ErrorResponse;
import org.globallogic.beans.resquest.LoginRequest;
import org.globallogic.beans.resquest.SignUpRequest;
import org.globallogic.constant.Constant;
import org.globallogic.dao.User;
import org.globallogic.dao.UserRepository;
import org.globallogic.jwt.JWTTokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.globallogic.constant.Constant.TOKEN_EMPTY_ERROR_MESSAGE;
import static org.globallogic.utils.Date.dateNow;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTTokenProvider jwtToken;

    private String token = "";

    @Test
    void loginUsersTest() throws Exception {
        User userForTest = createUserForTest();

        assertNotEquals(userForTest.toString(), "");
        assertNotEquals(userForTest.hashCode(), 0);

        assertTrue(userForTest.getPassword().matches(Constant.PATTERN_CREDENTIALS));

        token = userForTest.getToken();
        assertNotNull(userRepository.save(userForTest));

        LoginRequest loginRQ = new LoginRequest(token);
        mockMvc.perform(post("/users/login")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(loginRQ)))
                        .andExpect(status().isOk());

        User userCheck = userRepository.findByEmail(userForTest.getEmail());
        assertNotNull(userCheck);
        assertEquals(token, userCheck.getToken());
    }

    @Test
    void loginUsersWrongParamTest() throws Exception {
        LoginRequest loginRQ = new LoginRequest("");
        mockMvc.perform(post("/users/login")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(loginRQ)))
                .andExpect(status().isBadRequest()).andExpect(content().string(containsString(TOKEN_EMPTY_ERROR_MESSAGE)));


    }

    private User createUserForTest() {
        String email = "jcm@mail.com";
        return new User("Juan Carlos Mesa",
                email,
                "Pass12",
                getPhonesForTest(),
                dateNow(),
                dateNow(),
                dateNow(),
                jwtToken.generateToken(email));
    }

    @Test
    void signUpUserTest() throws Exception {
        SignUpRequest signInRQ = getSignUpRequest();

        mockMvc.perform(post("/users/sign-up")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(signInRQ)))
                        .andExpect(status().isOk());

        ErrorResponse errorResponse = new ErrorResponse("User with this email already exist", false);

        MvcResult mvnResult= mockMvc.perform(post("/users/sign-up")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(signInRQ)))
                        .andExpect(status().isBadRequest()).andReturn();

        assertThat(mvnResult.getResponse().getContentAsString().contains(errorResponse.getMessage()));
    }

    @Test
    void signUpUserWrongUrlTest() throws Exception {
        mockMvc.perform(post("/users/sign-up2")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(new SignUpRequest())))
                .andExpect(status().isNotFound());

    }

    private SignUpRequest getSignUpRequest() {
        return new SignUpRequest("Carlos Perez", "cp@mail.com", "Pass12", getPhonesForTest());
    }

    private List<Phone> getPhonesForTest() {
        Phone phone = new Phone("946644558","1","57");
        List<Phone> phones = new ArrayList<>();
        phones.add(phone);
        return phones;
    }

}



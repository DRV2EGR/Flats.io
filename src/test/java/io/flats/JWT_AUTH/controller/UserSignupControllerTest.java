package io.flats.JWT_AUTH.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.flats.JWT_AUTH.payload.UserDtoPayload;
import io.flats.JWT_AUTH.service.UserService;
import io.flats.entity.Comments;
import io.flats.entity.Likes;
import io.flats.entity.Role;
import io.flats.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.hamcrest.Matchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserSignupController.class})
@ExtendWith(SpringExtension.class)
public class UserSignupControllerTest {
    @MockBean
    private UserService userService;

    @Autowired
    private UserSignupController userSignupController;

    @Test
    public void testSignupNewRealtor() throws Exception {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);
        Optional<User> ofResult = Optional.<User>of(user);
        when(this.userService.findByUsername(anyString())).thenReturn(ofResult);

        UserDtoPayload userDtoPayload = new UserDtoPayload();
        userDtoPayload.setLastName("Doe");
        userDtoPayload.setEmail("jane.doe@example.org");
        userDtoPayload.setPassword("iloveyou");
        userDtoPayload.setUsername("janedoe");
        userDtoPayload.setSecondName("Second Name");
        userDtoPayload.setPhoneNumber("4105551212");
        userDtoPayload.setFirstName("Jane");
        userDtoPayload.setUserProfileImageUrl("https://example.org/example");
        String content = (new ObjectMapper()).writeValueAsString(userDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/signup/realtor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userSignupController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(409));
    }

    @Test
    public void testSignupNewRealtor2() throws Exception {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);
        when(this.userService.registerNewRealtor((UserDtoPayload) any())).thenReturn(user);
        when(this.userService.findByUsername(anyString())).thenReturn(Optional.<User>empty());

        UserDtoPayload userDtoPayload = new UserDtoPayload();
        userDtoPayload.setLastName("Doe");
        userDtoPayload.setEmail("jane.doe@example.org");
        userDtoPayload.setPassword("iloveyou");
        userDtoPayload.setUsername("janedoe");
        userDtoPayload.setSecondName("Second Name");
        userDtoPayload.setPhoneNumber("4105551212");
        userDtoPayload.setFirstName("Jane");
        userDtoPayload.setUserProfileImageUrl("https://example.org/example");
        String content = (new ObjectMapper()).writeValueAsString(userDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/signup/realtor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userSignupController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"id\":123,\"firstName\":\"Jane\",\"secondName\":\"Second Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email"
                                        + "\":\"jane.doe@example.org\",\"password\":\"iloveyou\",\"phoneNumber\":\"4105551212\",\"activationCode\":\"Activation"
                                        + " Code\",\"timeOfAccountCreation\":[1,1,1,1,1],\"userProfileImageUrl\":\"https://example.org/example\",\"rating"
                                        + "\":10.0,\"role\":{\"id\":123,\"name\":\"Name\"},\"puttedLikesToFlats\":[],\"puttedCommentsToFlats\":[],\"receivedC"
                                        + "ommentsToFlats\":[]}")));
    }

    @Test
    public void testSignupNewSeller() throws Exception {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);
        Optional<User> ofResult = Optional.<User>of(user);
        when(this.userService.findByUsername(anyString())).thenReturn(ofResult);

        UserDtoPayload userDtoPayload = new UserDtoPayload();
        userDtoPayload.setLastName("Doe");
        userDtoPayload.setEmail("jane.doe@example.org");
        userDtoPayload.setPassword("iloveyou");
        userDtoPayload.setUsername("janedoe");
        userDtoPayload.setSecondName("Second Name");
        userDtoPayload.setPhoneNumber("4105551212");
        userDtoPayload.setFirstName("Jane");
        userDtoPayload.setUserProfileImageUrl("https://example.org/example");
        String content = (new ObjectMapper()).writeValueAsString(userDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/signup/seller")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userSignupController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(409));
    }

    @Test
    public void testSignupNewSeller2() throws Exception {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);
        when(this.userService.registerNewSailor((UserDtoPayload) any())).thenReturn(user);
        when(this.userService.findByUsername(anyString())).thenReturn(Optional.<User>empty());

        UserDtoPayload userDtoPayload = new UserDtoPayload();
        userDtoPayload.setLastName("Doe");
        userDtoPayload.setEmail("jane.doe@example.org");
        userDtoPayload.setPassword("iloveyou");
        userDtoPayload.setUsername("janedoe");
        userDtoPayload.setSecondName("Second Name");
        userDtoPayload.setPhoneNumber("4105551212");
        userDtoPayload.setFirstName("Jane");
        userDtoPayload.setUserProfileImageUrl("https://example.org/example");
        String content = (new ObjectMapper()).writeValueAsString(userDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/signup/seller")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userSignupController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"id\":123,\"firstName\":\"Jane\",\"secondName\":\"Second Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email"
                                        + "\":\"jane.doe@example.org\",\"password\":\"iloveyou\",\"phoneNumber\":\"4105551212\",\"activationCode\":\"Activation"
                                        + " Code\",\"timeOfAccountCreation\":[1,1,1,1,1],\"userProfileImageUrl\":\"https://example.org/example\",\"rating"
                                        + "\":10.0,\"role\":{\"id\":123,\"name\":\"Name\"},\"puttedLikesToFlats\":[],\"puttedCommentsToFlats\":[],\"receivedC"
                                        + "ommentsToFlats\":[]}")));
    }
}


package io.flats.controller;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.flats.JWT_AUTH.dto.UserDto;
import io.flats.JWT_AUTH.jwt.JwtUserDetailsService;
import io.flats.JWT_AUTH.service.UserService;
import io.flats.entity.Comments;
import io.flats.entity.Likes;
import io.flats.entity.Role;
import io.flats.entity.User;
import io.flats.repository.UserRepository;
import io.flats.service.FlatService;
import io.flats.service.LikeAndCommentService;

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

@ContextConfiguration(classes = {UserBasicController.class})
@ExtendWith(SpringExtension.class)
public class UserBasicControllerTest {
    @MockBean
    private FlatService flatService;

    @MockBean
    private JwtUserDetailsService jwtUserDetailsService;

    @MockBean
    private LikeAndCommentService likeAndCommentService;

    @Autowired
    private UserBasicController userBasicController;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserService userService;

    @Test
    public void testGetAddRealtorInfo() throws Exception {
        when(this.userService.getAdditRealtorInfo(anyLong())).thenReturn(1);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/api/user/public/get_additional_info_about_realtor");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.userBasicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("1")));
    }

    @Test
    public void testGetAllRieltors() throws Exception {
        when(this.userService.findAllRieltors()).thenReturn(new ArrayList<User>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/public/get_all_realtors");
        MockMvcBuilders.standaloneSetup(this.userBasicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

//    @Test
//    public void testGetAllRieltors2() throws Exception {
//        Role role = new Role();
//        role.setId(123L);
//        role.setName("?");
//
//        User user = new User();
//        user.setLastName("Doe");
//        user.setEmail("jane.doe@example.org");
//        user.setPassword("iloveyou");
//        user.setActivationCode("?");
//        user.setId(123L);
//        user.setPhoneNumber("4105551212");
//        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
//        user.setUserProfileImageUrl("https://example.org/example");
//        user.setFirstName("Jane");
//        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
//        user.setUsername("janedoe");
//        user.setSecondName("?");
//        user.setPuttedLikesToFlats(new ArrayList<Likes>());
//        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
//        user.setRating(10.0f);
//        user.setRole(role);
//
//        ArrayList<User> userList = new ArrayList<User>();
//        userList.add(user);
//        when(this.userService.findAllRieltors()).thenReturn(userList);
//        when(this.likeAndCommentService.getReceivedCommentsByUserId(anyLong())).thenReturn(new ArrayList<Comments>());
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/public/get_all_realtors");
//        MockMvcBuilders.standaloneSetup(this.userBasicController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content()
//                        .string(Matchers.containsString(
//                                "[{\"id\":123,\"firstName\":\"Jane\",\"secondName\":\"?\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email\":\"jane.doe"
//                                        + "@example.org\",\"phoneNumber\":\"4105551212\",\"role\":\"?\",\"rating\":10.0,\"dateUserFrom\":-62135602157000,"
//                                        + "\"realtorsCommentsNomber\":0}]")));
//    }

    @Test
    public void testGetCommentsToUserById() throws Exception {
        when(this.likeAndCommentService.getReceivedCommentsByUserId(anyLong())).thenReturn(new ArrayList<Comments>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/user/public/get_comments_to_user_by_id");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.userBasicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetCommentsToUserById2() throws Exception {
        Role role = new Role();
        role.setId(123L);
        role.setName("?");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("?");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user.setUsername("janedoe");
        user.setSecondName("?");
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("?");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivationCode("?");
        user1.setId(123L);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user1.setUsername("janedoe");
        user1.setSecondName("?");
        user1.setPuttedLikesToFlats(new ArrayList<Likes>());
        user1.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user1.setRating(10.0f);
        user1.setRole(role1);

        Comments comments = new Comments();
        comments.setId(123L);
        comments.setUserTo(user);
        comments.setUser_from(user1);
        comments.setCommentText("?");
        comments.setRating(10.0f);

        ArrayList<Comments> commentsList = new ArrayList<Comments>();
        commentsList.add(comments);
        when(this.likeAndCommentService.getReceivedCommentsByUserId(anyLong())).thenReturn(commentsList);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/user/public/get_comments_to_user_by_id");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.userBasicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "[{\"user_from\":{\"id\":0,\"firstName\":\"Jane\",\"secondName\":\"?\",\"lastName\":\"Doe\",\"username\":\"janedoe\","
                                        + "\"email\":\"jane.doe@example.org\",\"phoneNumber\":\"4105551212\",\"role\":\"?\",\"rating\":0.0,\"dateUserFrom\""
                                        + ":null,\"realtorsCommentsNomber\":0},\"img_from\":{\"img\":\"https://example.org/example\"},\"comment\":\"?\","
                                        + "\"rating\":10.0}]")));
    }

    @Test
    public void testGetLikesFromUserById() throws Exception {
        when(this.likeAndCommentService.getLikesOfUserById(anyLong())).thenReturn(new ArrayList<Likes>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/user/public/get_likes_from_user_by_id");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.userBasicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetLikesFromUserById2() throws Exception {
        when(this.likeAndCommentService.getLikesOfUserById(anyLong())).thenReturn(new ArrayList<Likes>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/user/public/get_likes_from_user_by_id",
                "Uri Vars");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.userBasicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

//    @Test
//    public void testGetUserInfo() throws Exception {
//        Role role = new Role();
//        role.setId(123L);
//        role.setName("Name");
//
//        User user = new User();
//        user.setLastName("Doe");
//        user.setEmail("jane.doe@example.org");
//        user.setPassword("iloveyou");
//        user.setActivationCode("Activation Code");
//        user.setId(123L);
//        user.setPhoneNumber("4105551212");
//        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
//        user.setUserProfileImageUrl("https://example.org/example");
//        user.setFirstName("Jane");
//        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
//        user.setUsername("janedoe");
//        user.setSecondName("Second Name");
//        user.setPuttedLikesToFlats(new ArrayList<Likes>());
//        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
//        user.setRating(10.0f);
//        user.setRole(role);
//        Optional<User> ofResult = Optional.<User>of(user);
//        when(this.userService.findByUsername(anyString())).thenReturn(ofResult);
//
//        UserDto userDto = new UserDto();
//        userDto.setLastName("Doe");
//        userDto.setEmail("jane.doe@example.org");
//        userDto.setPassword("iloveyou");
//        userDto.setRole("Role");
//        userDto.setUsername("janedoe");
//        userDto.setSecondName("Second Name");
//        userDto.setPhoneNumber("4105551212");
//        userDto.setFirstName("Jane");
//        String content = (new ObjectMapper()).writeValueAsString(userDto);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/public/get_user_info")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        MockMvcBuilders.standaloneSetup(this.userBasicController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content()
//                        .string(Matchers.containsString(
//                                "{\"id\":123,\"firstName\":\"Jane\",\"secondName\":\"Second Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email"
//                                        + "\":\"jane.doe@example.org\",\"phoneNumber\":\"4105551212\",\"role\":\"Name\",\"rating\":10.0,\"dateUserFrom\":"
//                                        + "-62135602157000,\"realtorsCommentsNomber\":0}")));
//    }

    @Test
    public void testGetUserInfo2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/user/public/get_user_info_from_token")
                .param("token", "foo");
        MockMvcBuilders.standaloneSetup(this.userBasicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetUserInfo3() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/user/public/get_user_info_from_token");
        getResult.contentType("Not all who wander are lost");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("token", "foo");
        MockMvcBuilders.standaloneSetup(this.userBasicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetUserPostedFlats() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/public/get_user_posted_flats");
        MockMvcBuilders.standaloneSetup(this.userBasicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetUserPostedFlats2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/public/get_user_posted_flats",
                "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.userBasicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetUserProfileImageUrlByUsername() throws Exception {
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
        when(this.userRepository.findByUsername(anyString())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/user/public/get_user_img_url_by_username")
                .param("username", "foo");
        MockMvcBuilders.standaloneSetup(this.userBasicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("{\"img\":\"https://example.org/example\"}")));
    }

    @Test
    public void testGetUserProfileImageUrlByUsername2() throws Exception {
        when(this.userRepository.findByUsername(anyString())).thenReturn(Optional.<User>empty());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/user/public/get_user_img_url_by_username")
                .param("username", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userBasicController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}


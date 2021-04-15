package io.flats.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.flats.JWT_AUTH.service.UserService;
import io.flats.entity.Flat;
import io.flats.entity.FlatOrderType;
import io.flats.entity.FlatsImages;
import io.flats.entity.Role;
import io.flats.entity.User;
import io.flats.payload.FlatDtoPayload;
import io.flats.service.FlatService;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {FlatController.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FlatControllerTest {
    @Autowired
    private FlatController flatController;

    @MockBean
    private FlatService flatService;

    @MockBean
    private UserService userService;

    @Test
    public void testAddFlat() throws Exception {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(1);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");
        when(this.flatService.addRentFlat((FlatDtoPayload) any())).thenReturn(flat);

        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setFlatsImages(new ArrayList<String>());
        flatDtoPayload.setPrice(10.0f);
        flatDtoPayload.setUsername("janedoe");
        flatDtoPayload.setCountry("Country");
        flatDtoPayload.setFloor(1);
        flatDtoPayload.setTown("Oxford");
        flatDtoPayload.setForSale(false);
        flatDtoPayload.setDescription("The characteristics of someone or something");
        flatDtoPayload.setForRent(true);
        flatDtoPayload.setHouseNom("House Nom");
        flatDtoPayload.setStreet("Street");
        String content = (new ObjectMapper()).writeValueAsString(flatDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/flats/add_flat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.flatController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("{\"response\":\"OK\"}")));
    }

    @Test
    public void testAddFlat2() throws Exception {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(1);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");
        when(this.flatService.addRentFlat((FlatDtoPayload) any())).thenReturn(flat);

        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setFlatsImages(new ArrayList<String>());
        flatDtoPayload.setPrice(10.0f);
        flatDtoPayload.setUsername("janedoe");
        flatDtoPayload.setCountry("Country");
        flatDtoPayload.setFloor(1);
        flatDtoPayload.setTown("Oxford");
        flatDtoPayload.setForSale(false);
        flatDtoPayload.setDescription("The characteristics of someone or something");
        flatDtoPayload.setForRent(true);
        flatDtoPayload.setHouseNom("House Nom");
        flatDtoPayload.setStreet("Street");
        String content = (new ObjectMapper()).writeValueAsString(flatDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/flats/add_flat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.flatController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("{\"response\":\"OK\"}")));
    }

    @Test
    public void testGetFlat() throws Exception {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(1);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");
        when(this.flatService.findFlatById(anyLong())).thenReturn(flat);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/flats/get_flat");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.flatController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"country\":\"Country\",\"town\":\"Oxford\",\"street\":\"Street\",\"houseNom\":\"House Nom\",\"floor\":1,\"price\":10.0"
                                        + ",\"description\":\"The characteristics of someone or something\",\"images\":[],\"id\":123,\"ownerUsername\":"
                                        + "\"janedoe\",\"ownerID\":123}")));
    }

    @Test
    public void testGetFlat2() throws Exception {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("?");

        Role role = new Role();
        role.setId(123L);
        role.setName("?");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("?");
        user.setUsername("janedoe");
        user.setSecondName("?");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("?");
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("?");
        flat.setStreet("?");

        FlatsImages flatsImages = new FlatsImages();
        flatsImages.setImgUrl("https://example.org/example");
        flatsImages.setId(123L);
        flatsImages.setFlat(flat);

        ArrayList<FlatsImages> flatsImagesList = new ArrayList<FlatsImages>();
        flatsImagesList.add(flatsImages);

        FlatOrderType flatOrderType1 = new FlatOrderType();
        flatOrderType1.setId(123L);
        flatOrderType1.setName("Name");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivationCode("Activation Code");
        user1.setUsername("janedoe");
        user1.setSecondName("Second Name");
        user1.setId(123L);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setRole(role1);

        Flat flat1 = new Flat();
        flat1.setFlatsImages(flatsImagesList);
        flat1.setPrice(10.0f);
        flat1.setCountry("Country");
        flat1.setFloor(1);
        flat1.setId(123L);
        flat1.setOrderType(flatOrderType1);
        flat1.setTown("Oxford");
        flat1.setOwner(user1);
        flat1.setDescription("The characteristics of someone or something");
        flat1.setHouseNom("House Nom");
        flat1.setStreet("Street");
        when(this.flatService.findFlatById(anyLong())).thenReturn(flat1);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/flats/get_flat");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.flatController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"country\":\"Country\",\"town\":\"Oxford\",\"street\":\"Street\",\"houseNom\":\"House Nom\",\"floor\":1,\"price\":10.0"
                                        + ",\"description\":\"The characteristics of someone or something\",\"images\":[\"https://example.org/example\""
                                        + "],\"id\":123,\"ownerUsername\":\"janedoe\",\"ownerID\":123}")));
    }

    @Test
    public void testGetFlat3() throws Exception {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(1);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");
        when(this.flatService.findFlatById(anyLong())).thenReturn(flat);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/flats/get_flat");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.flatController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"country\":\"Country\",\"town\":\"Oxford\",\"street\":\"Street\",\"houseNom\":\"House Nom\",\"floor\":1,\"price\":10.0"
                                        + ",\"description\":\"The characteristics of someone or something\",\"images\":[],\"id\":123,\"ownerUsername\":"
                                        + "\"janedoe\",\"ownerID\":123}")));
    }

    @Test
    public void testGetFlat4() throws Exception {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("?");

        Role role = new Role();
        role.setId(123L);
        role.setName("?");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("?");
        user.setUsername("janedoe");
        user.setSecondName("?");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("?");
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("?");
        flat.setStreet("?");

        FlatsImages flatsImages = new FlatsImages();
        flatsImages.setImgUrl("https://example.org/example");
        flatsImages.setId(123L);
        flatsImages.setFlat(flat);

        ArrayList<FlatsImages> flatsImagesList = new ArrayList<FlatsImages>();
        flatsImagesList.add(flatsImages);

        FlatOrderType flatOrderType1 = new FlatOrderType();
        flatOrderType1.setId(123L);
        flatOrderType1.setName("Name");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivationCode("Activation Code");
        user1.setUsername("janedoe");
        user1.setSecondName("Second Name");
        user1.setId(123L);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setRole(role1);

        Flat flat1 = new Flat();
        flat1.setFlatsImages(flatsImagesList);
        flat1.setPrice(10.0f);
        flat1.setCountry("Country");
        flat1.setFloor(1);
        flat1.setId(123L);
        flat1.setOrderType(flatOrderType1);
        flat1.setTown("Oxford");
        flat1.setOwner(user1);
        flat1.setDescription("The characteristics of someone or something");
        flat1.setHouseNom("House Nom");
        flat1.setStreet("Street");
        when(this.flatService.findFlatById(anyLong())).thenReturn(flat1);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/flats/get_flat");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.flatController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"country\":\"Country\",\"town\":\"Oxford\",\"street\":\"Street\",\"houseNom\":\"House Nom\",\"floor\":1,\"price\":10.0"
                                        + ",\"description\":\"The characteristics of someone or something\",\"images\":[\"https://example.org/example\""
                                        + "],\"id\":123,\"ownerUsername\":\"janedoe\",\"ownerID\":123}")));
    }
}


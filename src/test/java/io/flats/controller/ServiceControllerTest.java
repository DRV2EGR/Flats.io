package io.flats.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ServiceController.class})
@ExtendWith(SpringExtension.class)
public class ServiceControllerTest {
    @MockBean
    private FlatService flatService;

    @Autowired
    private ServiceController serviceController;

    @Test
    public void testAddFilterredFlats() throws Exception {
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
        when(this.flatService.addSaleFlat((FlatDtoPayload) any())).thenReturn(flat);

        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setFlatsImages(new ArrayList<String>());
        flatDtoPayload.setPrice(10.0f);
        flatDtoPayload.setUsername("janedoe");
        flatDtoPayload.setCountry("Country");
        flatDtoPayload.setFloor(1);
        flatDtoPayload.setTown("Oxford");
        flatDtoPayload.setForSale(true);
        flatDtoPayload.setDescription("The characteristics of someone or something");
        flatDtoPayload.setForRent(true);
        flatDtoPayload.setHouseNom("House Nom");
        flatDtoPayload.setStreet("Street");
        String content = (new ObjectMapper()).writeValueAsString(flatDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/service/add-sale-flat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("{\"response\":\"OK\"}")));
    }

    @Test
    public void testAddFilterredFlats2() throws Exception {
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
        flat.setId(0L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");
        when(this.flatService.addSaleFlat((FlatDtoPayload) any())).thenReturn(flat);

        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setFlatsImages(new ArrayList<String>());
        flatDtoPayload.setPrice(10.0f);
        flatDtoPayload.setUsername("janedoe");
        flatDtoPayload.setCountry("Country");
        flatDtoPayload.setFloor(1);
        flatDtoPayload.setTown("Oxford");
        flatDtoPayload.setForSale(true);
        flatDtoPayload.setDescription("The characteristics of someone or something");
        flatDtoPayload.setForRent(true);
        flatDtoPayload.setHouseNom("House Nom");
        flatDtoPayload.setStreet("Street");
        String content = (new ObjectMapper()).writeValueAsString(flatDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/service/add-sale-flat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string(Matchers.containsString("{\"response\":\"Not completed.\"}")));
    }

    @Test
    public void testAddFilterredFlats3() throws Exception {
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
        when(this.flatService.addSaleFlat((FlatDtoPayload) any())).thenReturn(flat);

        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setFlatsImages(new ArrayList<String>());
        flatDtoPayload.setPrice(10.0f);
        flatDtoPayload.setUsername("janedoe");
        flatDtoPayload.setCountry("Country");
        flatDtoPayload.setFloor(1);
        flatDtoPayload.setTown("Oxford");
        flatDtoPayload.setForSale(true);
        flatDtoPayload.setDescription("The characteristics of someone or something");
        flatDtoPayload.setForRent(true);
        flatDtoPayload.setHouseNom("House Nom");
        flatDtoPayload.setStreet("Street");
        String content = (new ObjectMapper()).writeValueAsString(flatDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/service/add-sale-flat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("{\"response\":\"OK\"}")));
    }

    @Test
    public void testAddFilterredFlats4() throws Exception {
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
        flat.setId(0L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");
        when(this.flatService.addSaleFlat((FlatDtoPayload) any())).thenReturn(flat);

        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setFlatsImages(new ArrayList<String>());
        flatDtoPayload.setPrice(10.0f);
        flatDtoPayload.setUsername("janedoe");
        flatDtoPayload.setCountry("Country");
        flatDtoPayload.setFloor(1);
        flatDtoPayload.setTown("Oxford");
        flatDtoPayload.setForSale(true);
        flatDtoPayload.setDescription("The characteristics of someone or something");
        flatDtoPayload.setForRent(true);
        flatDtoPayload.setHouseNom("House Nom");
        flatDtoPayload.setStreet("Street");
        String content = (new ObjectMapper()).writeValueAsString(flatDtoPayload);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/service/add-sale-flat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string(Matchers.containsString("{\"response\":\"Not completed.\"}")));
    }

    @Test
    public void testAddRentFlats() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/service/add-rent-flat");
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddRentFlats2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/service/add-rent-flat");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddRentFlats3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/service/add-rent-flat");
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddRentFlats4() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/service/add-rent-flat");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testMainPage() throws Exception {
        when(this.flatService.findAll()).thenReturn(new ArrayList<Flat>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/service/flats");
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testMainPage2() throws Exception {
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

        ArrayList<Flat> flatList = new ArrayList<Flat>();
        flatList.add(flat);
        when(this.flatService.findImagesByFlatId(anyLong())).thenReturn(new ArrayList<String>());
        when(this.flatService.findAll()).thenReturn(flatList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/service/flats");
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "[{\"country\":\"?\",\"town\":\"Oxford\",\"street\":\"?\",\"houseNom\":\"?\",\"floor\":0,\"price\":10.0,\"description\":\"The"
                                        + " characteristics of someone or something\",\"images\":[],\"id\":123,\"ownerUsername\":\"janedoe\",\"ownerID"
                                        + "\":123}]")));
    }

    @Test
    public void testMainPage3() throws Exception {
        when(this.flatService.findAll()).thenReturn(new ArrayList<Flat>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/service/flats");
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testMainPage4() throws Exception {
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

        ArrayList<Flat> flatList = new ArrayList<Flat>();
        flatList.add(flat);
        when(this.flatService.findImagesByFlatId(anyLong())).thenReturn(new ArrayList<String>());
        when(this.flatService.findAll()).thenReturn(flatList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/service/flats");
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "[{\"country\":\"?\",\"town\":\"Oxford\",\"street\":\"?\",\"houseNom\":\"?\",\"floor\":0,\"price\":10.0,\"description\":\"The"
                                        + " characteristics of someone or something\",\"images\":[],\"id\":123,\"ownerUsername\":\"janedoe\",\"ownerID"
                                        + "\":123}]")));
    }

    @Test
    public void testReturnFilterredFlats() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/service/filterred-flats");
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testReturnFilterredFlats2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/service/filterred-flats");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testReturnFilterredFlats3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/service/filterred-flats");
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testReturnFilterredFlats4() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/service/filterred-flats");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.serviceController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}


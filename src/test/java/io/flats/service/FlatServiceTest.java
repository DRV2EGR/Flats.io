package io.flats.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.flats.JWT_AUTH.exeption.NotFoundException;
import io.flats.JWT_AUTH.service.UserService;
import io.flats.entity.Flat;
import io.flats.entity.FlatOrderType;
import io.flats.entity.FlatsImages;
import io.flats.entity.Role;
import io.flats.entity.User;
import io.flats.payload.FlatDtoPayload;
import io.flats.repository.FlatOrderTypeRepository;
import io.flats.repository.FlatRepository;
import io.flats.repository.FlatsImagesRepository;
import io.flats.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FlatService.class, UserService.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FlatServiceTest {
    @MockBean
    private FlatOrderTypeRepository flatOrderTypeRepository;

    @MockBean
    private FlatRepository flatRepository;

    @Autowired
    private FlatService flatService;

    @MockBean
    private FlatsImagesRepository flatsImagesRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserService userService;

    @Test
    public void testFindImagesByFlatId() {
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
        Optional<Flat> ofResult = Optional.<Flat>of(flat);
        when(this.flatRepository.findById((Long) any())).thenReturn(ofResult);
        assertTrue(this.flatService.findImagesByFlatId(123L).isEmpty());
        verify(this.flatRepository).findById((Long) any());
    }

    @Test
    public void testFindImagesByFlatId2() {
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
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");

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
        Optional<Flat> ofResult = Optional.<Flat>of(flat1);
        when(this.flatRepository.findById((Long) any())).thenReturn(ofResult);
        List<String> actualFindImagesByFlatIdResult = this.flatService.findImagesByFlatId(123L);
        assertEquals(1, actualFindImagesByFlatIdResult.size());
        assertEquals("https://example.org/example", actualFindImagesByFlatIdResult.get(0));
        verify(this.flatRepository).findById((Long) any());
    }

    @Test
    public void testFindImagesByFlatId3() {
        when(this.flatRepository.findById((Long) any())).thenReturn(Optional.<Flat>empty());
        assertThrows(NoSuchElementException.class, () -> this.flatService.findImagesByFlatId(123L));
        verify(this.flatRepository).findById((Long) any());
    }

    @Test
    public void testFindAll() {
        ArrayList<Flat> flatList = new ArrayList<Flat>();
        when(this.flatRepository.findAll()).thenReturn(flatList);
        List<Flat> actualFindAllResult = this.flatService.findAll();
        assertSame(flatList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.flatRepository).findAll();
    }

    @Test
    public void testAddSaleFlat() {
        when(this.flatOrderTypeRepository.findById((Long) any())).thenThrow(new NotFoundException());
        assertThrows(NotFoundException.class, () -> this.flatService.addSaleFlat(new FlatDtoPayload()));
        verify(this.flatOrderTypeRepository).findById((Long) any());
    }

    @Test
    public void testAddSaleFlat2() {
        when(this.flatOrderTypeRepository.findById((Long) any())).thenReturn(Optional.<FlatOrderType>empty());
        this.flatService.addSaleFlat(new FlatDtoPayload());
        verify(this.flatOrderTypeRepository).findById((Long) any());
    }

    @Test
    public void testAddSaleFlat3() {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");
        Optional<FlatOrderType> ofResult = Optional.<FlatOrderType>of(flatOrderType);
        when(this.flatOrderTypeRepository.findById((Long) any())).thenReturn(ofResult);
        FlatDtoPayload flatDtoPayload = mock(FlatDtoPayload.class);
        when(flatDtoPayload.getDescription()).thenThrow(new NotFoundException());
        when(flatDtoPayload.getPrice()).thenReturn(10.0f);
        when(flatDtoPayload.getFloor()).thenReturn(1);
        when(flatDtoPayload.getHouseNom()).thenReturn("foo");
        when(flatDtoPayload.getStreet()).thenReturn("foo");
        when(flatDtoPayload.getTown()).thenReturn("foo");
        when(flatDtoPayload.getCountry()).thenReturn("foo");
        assertThrows(NotFoundException.class, () -> this.flatService.addSaleFlat(flatDtoPayload));
        verify(flatDtoPayload).getPrice();
        verify(flatDtoPayload).getTown();
        verify(flatDtoPayload).getDescription();
        verify(flatDtoPayload).getFloor();
        verify(flatDtoPayload).getStreet();
        verify(flatDtoPayload).getCountry();
        verify(flatDtoPayload).getHouseNom();
    }

    @Test
    public void testAddRentFlat() {
        when(this.flatOrderTypeRepository.findById((Long) any())).thenThrow(new NotFoundException());
        assertThrows(NotFoundException.class, () -> this.flatService.addRentFlat(new FlatDtoPayload()));
        verify(this.flatOrderTypeRepository).findById((Long) any());
    }

    @Test
    public void testAddRentFlat2() {
        when(this.flatOrderTypeRepository.findById((Long) any())).thenReturn(Optional.<FlatOrderType>empty());
        this.flatService.addRentFlat(new FlatDtoPayload());
        verify(this.flatOrderTypeRepository).findById((Long) any());
    }

    @Test
    public void testAddRentFlat3() {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");
        Optional<FlatOrderType> ofResult = Optional.<FlatOrderType>of(flatOrderType);
        when(this.flatOrderTypeRepository.findById((Long) any())).thenReturn(ofResult);
        FlatDtoPayload flatDtoPayload = mock(FlatDtoPayload.class);
        when(flatDtoPayload.getDescription()).thenThrow(new NotFoundException());
        when(flatDtoPayload.getPrice()).thenReturn(10.0f);
        when(flatDtoPayload.getFloor()).thenReturn(1);
        when(flatDtoPayload.getHouseNom()).thenReturn("foo");
        when(flatDtoPayload.getStreet()).thenReturn("foo");
        when(flatDtoPayload.getTown()).thenReturn("foo");
        when(flatDtoPayload.getCountry()).thenReturn("foo");
        assertThrows(NotFoundException.class, () -> this.flatService.addRentFlat(flatDtoPayload));
        verify(flatDtoPayload).getPrice();
        verify(flatDtoPayload).getTown();
        verify(flatDtoPayload).getDescription();
        verify(flatDtoPayload).getFloor();
        verify(flatDtoPayload).getStreet();
        verify(flatDtoPayload).getCountry();
        verify(flatDtoPayload).getHouseNom();
    }

    @Test
    public void testFindFlatById() {
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
        Optional<Flat> ofResult = Optional.<Flat>of(flat);
        when(this.flatRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(flat, this.flatService.findFlatById(123L));
        verify(this.flatRepository).findById((Long) any());
    }

    @Test
    public void testFindFlatById2() {
        when(this.flatRepository.findById((Long) any())).thenReturn(Optional.<Flat>empty());
        assertThrows(NotFoundException.class, () -> this.flatService.findFlatById(123L));
        verify(this.flatRepository).findById((Long) any());
    }

    @Test
    public void testDeleteFlatById() {
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
        Optional<Flat> ofResult = Optional.<Flat>of(flat);
        doNothing().when(this.flatRepository).delete((Flat) any());
        when(this.flatRepository.findById((Long) any())).thenReturn(ofResult);
        assertFalse(this.flatService.deleteFlatById(123L));
        verify(this.flatRepository).delete((Flat) any());
        verify(this.flatRepository, times(3)).findById((Long) any());
    }

    @Test
    public void testDeleteFlatById2() {
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
        flat.setPrice(0.5f);
        flat.setCountry("Country");
        flat.setFloor(1);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");
        Optional<Flat> ofResult = Optional.<Flat>of(flat);
        doNothing().when(this.flatRepository).delete((Flat) any());
        when(this.flatRepository.findById((Long) any())).thenReturn(ofResult);
        assertFalse(this.flatService.deleteFlatById(123L));
        verify(this.flatRepository).delete((Flat) any());
        verify(this.flatRepository, times(3)).findById((Long) any());
    }

    @Test
    public void testDeleteFlatById3() {
        doNothing().when(this.flatRepository).delete((Flat) any());
        when(this.flatRepository.findById((Long) any())).thenReturn(Optional.<Flat>empty());
        this.flatService.deleteFlatById(123L);
        verify(this.flatRepository).findById((Long) any());
    }

    @org.junit.Test
    public void _testFindImagesByFlatId() {
        given(this.flatRepository.findById(any()))
                .willReturn(
                        java.util.Optional.of(new Flat(20L, List.of(new FlatsImages("S1CR1T", new Flat(20L)))))
                );

        List<String> imgs = flatService.findImagesByFlatId(20L);

        assert (imgs.size() == 1);
        assert (imgs.get(0).equals("S1CR1T"));

    }

    @org.junit.Test
    public void _testFindAll() {
        given(this.flatRepository.findAll())
                .willReturn(
                        List.of(
                                new Flat(10L), new Flat(100L), new Flat(1000L)
                        )
                );

        List<Flat> listOfFlats = flatService.findAll();

        assert (!listOfFlats.isEmpty());
        assert (listOfFlats.size() == 3);

        for (int i = 0; i < listOfFlats.size(); ++i) {
            assert (listOfFlats.get(i).getId() == Math.pow(10, i+1));
        }
    }

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }

    @org.junit.Test
    @WithMockUser(username = "john_the_admin", roles = "ADMIN")
    public void _testAddSaleFlat() {

        when(flatRepository.save(any(Flat.class))).thenReturn(
                new Flat(20L, List.of(
                        new FlatsImages("S1CR1T", new Flat(20L)),
                        new FlatsImages("OWO_UWU", new Flat(20L))
                ))
        );

        given(flatRepository.findById(any())).willReturn(
                java.util.Optional.of(new Flat(20L, List.of(
                        new FlatsImages("S1CR1T", new Flat(20L)),
                        new FlatsImages("OWO_UWU", new Flat(20L))
                )))
        );

        when(flatsImagesRepository.save(any())).thenReturn(
                new FlatsImages("S1CR1T", new Flat(20L))
        );


        Flat created = flatService.addSaleFlat(
                new FlatDtoPayload("freya", true, false, List.of("S1CR1T", "OWO_UWU"))
        );

        assert(created.getId() == 20L);
        assert (created.getFlatsImages().size() == 2);
        assert (created.getFlatsImages().get(0).getImgUrl().equals("S1CR1T"));
        assert (created.getFlatsImages().get(1).getImgUrl().equals("OWO_UWU"));
    }

    @org.junit.Test
    @WithMockUser(username = "john_the_admin", roles = "ADMIN")
    public void _testAddRentFlat() {

        when(flatRepository.save(any(Flat.class))).thenReturn(
                new Flat(20L, List.of(
                        new FlatsImages("S1CR1T", new Flat(20L)),
                        new FlatsImages("OWO_UWU", new Flat(20L))
                ))
        );

        given(flatRepository.findById(any())).willReturn(
                java.util.Optional.of(new Flat(20L, List.of(
                        new FlatsImages("S1CR1T", new Flat(20L)),
                        new FlatsImages("OWO_UWU", new Flat(20L))
                )))
        );

        when(flatsImagesRepository.save(any())).thenReturn(
                new FlatsImages("S1CR1T", new Flat(20L))
        );


        Flat created = flatService.addRentFlat(
                new FlatDtoPayload("freya", true, false, List.of("S1CR1T", "OWO_UWU"))
        );

        assert(created.getId() == 20L);
        assert (created.getFlatsImages().size() == 2);
        assert (created.getFlatsImages().get(0).getImgUrl().equals("S1CR1T"));
        assert (created.getFlatsImages().get(1).getImgUrl().equals("OWO_UWU"));
    }

    @org.junit.Test
    public void _testFindFlatById() {
        when(flatRepository.findById(any())).thenReturn(
                java.util.Optional.of(new Flat(10L))
        );

        Flat findedFlat = flatService.findFlatById(10L);

        assert (findedFlat.getId() == 10);
    }

    @org.junit.Test
    public void _testDeleteFlatById() {
        final Flat entity = new Flat(20L, List.of(
                new FlatsImages("S1CR1T", new Flat(20L)),
                new FlatsImages("OWO_UWU", new Flat(20L))
        ));
        Optional<Flat> optionalEntityType = Optional.of(entity);

        when(flatRepository.findById(20L)).thenReturn(optionalEntityType);

        // when
        /*boolean b = */flatService.deleteFlatById(entity.getId());
        //System.out.println(b);

        // then
        Mockito.verify(flatRepository, times(1)).delete(entity);
        //I dont think you need to assert to confirm actual delete as you are testing mock registry. to assert somethink like below you need to return null by mocking the same call again and return the null but thats of no use
        //assertThat(flatRepository.findById(20L).get()).isNull();

        //assert (b); - is ok, but then return null doesn't work.

        //TODO: testDeleteFlatById
    }
}


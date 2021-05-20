package io.flats.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.flats.JWT_AUTH.exeption.NotFoundException;
import io.flats.JWT_AUTH.service.UserService;
import io.flats.dto.FlatDto;
import io.flats.entity.Comments;
import io.flats.entity.Flat;
import io.flats.entity.FlatOrderType;
import io.flats.entity.FlatsImages;
import io.flats.entity.Likes;
import io.flats.entity.Role;
import io.flats.entity.User;
import io.flats.payload.FlatDtoPayload;
import io.flats.repository.CommentsRepository;
import io.flats.repository.FlatOrderTypeRepository;
import io.flats.repository.FlatRepository;
import io.flats.repository.LikesRepository;
import io.flats.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FlatService.class, UserService.class})
@ExtendWith(SpringExtension.class)
public class FlatServiceTest {
    @MockBean
    private CommentsRepository commentsRepository;

    @MockBean
    private FlatOrderTypeRepository flatOrderTypeRepository;

    @MockBean
    private FlatRepository flatRepository;

    @Autowired
    private FlatService flatService;

    @MockBean
    private LikesRepository likesRepository;

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
        flat.setFlatsLikes(new ArrayList<Likes>());
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
        flat.setFlatsLikes(new ArrayList<Likes>());
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
        user1.setId(123L);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user1.setUsername("janedoe");
        user1.setSecondName("Second Name");
        user1.setPuttedLikesToFlats(new ArrayList<Likes>());
        user1.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user1.setRating(10.0f);
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
        flat1.setFlatsLikes(new ArrayList<Likes>());
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

//    @Test
//    public void testAddSaleFlat2() {
//        when(this.flatOrderTypeRepository.findById((Long) any())).thenReturn(Optional.<FlatOrderType>empty());
//        this.flatService.addSaleFlat(new FlatDtoPayload());
//        verify(this.flatOrderTypeRepository).findById((Long) any());
//    }

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

//    @Test
//    public void testAddRentFlat2() {
//        when(this.flatOrderTypeRepository.findById((Long) any())).thenReturn(Optional.<FlatOrderType>empty());
//        this.flatService.addRentFlat(new FlatDtoPayload());
//        verify(this.flatOrderTypeRepository).findById((Long) any());
//    }

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
        flat.setFlatsLikes(new ArrayList<Likes>());
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
        flat.setFlatsLikes(new ArrayList<Likes>());
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
        flat.setFlatsLikes(new ArrayList<Likes>());
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");
        Optional<Flat> ofResult = Optional.<Flat>of(flat);
        doNothing().when(this.flatRepository).delete((Flat) any());
        when(this.flatRepository.findById((Long) any())).thenReturn(ofResult);
        assertFalse(this.flatService.deleteFlatById(123L));
        verify(this.flatRepository).delete((Flat) any());
        verify(this.flatRepository, times(3)).findById((Long) any());
    }

//    @Test
//    public void testDeleteFlatById3() {
//        doNothing().when(this.flatRepository).delete((Flat) any());
//        when(this.flatRepository.findById((Long) any())).thenReturn(Optional.<Flat>empty());
//        this.flatService.deleteFlatById(123L);
//        verify(this.flatRepository).findById((Long) any());
//    }

    @Test
    public void testConvertFlatToFlatDto() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User(123L, "janedoe");
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

        Flat flat = new Flat(123L);
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setOwner(user);
        FlatDto actualConvertFlatToFlatDtoResult = this.flatService.convertFlatToFlatDto(flat);
        assertNull(actualConvertFlatToFlatDtoResult.getCountry());
        assertEquals("FlatDto(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                + " images=[], id=123, ownerUsername=janedoe, ownerID=123)", actualConvertFlatToFlatDtoResult.toString());
        assertNull(actualConvertFlatToFlatDtoResult.getTown());
        assertNull(actualConvertFlatToFlatDtoResult.getStreet());
        assertEquals(0.0f, actualConvertFlatToFlatDtoResult.getPrice());
        assertEquals("janedoe", actualConvertFlatToFlatDtoResult.getOwnerUsername());
        assertEquals(123L, actualConvertFlatToFlatDtoResult.getOwnerID());
        assertEquals(123L, actualConvertFlatToFlatDtoResult.getId());
        assertNull(actualConvertFlatToFlatDtoResult.getHouseNom());
        assertEquals(0, actualConvertFlatToFlatDtoResult.getFloor());
        assertNull(actualConvertFlatToFlatDtoResult.getDescription());
    }

    @Test
    public void testConvertFlatToFlatDto2() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User(123L, "janedoe");
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

        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivationCode("Activation Code");
        user1.setId(123L);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user1.setUsername("janedoe");
        user1.setSecondName("Second Name");
        user1.setPuttedLikesToFlats(new ArrayList<Likes>());
        user1.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user1.setRating(10.0f);
        user1.setRole(role1);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user1);
        flat.setDescription("The characteristics of someone or something");
        flat.setFlatsLikes(new ArrayList<Likes>());
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");

        FlatsImages flatsImages = new FlatsImages();
        flatsImages.setImgUrl("https://example.org/example");
        flatsImages.setId(123L);
        flatsImages.setFlat(flat);

        ArrayList<FlatsImages> flatsImagesList = new ArrayList<FlatsImages>();
        flatsImagesList.add(flatsImages);

        Flat flat1 = new Flat(123L);
        flat1.setFlatsImages(flatsImagesList);
        flat1.setOwner(user);
        FlatDto actualConvertFlatToFlatDtoResult = this.flatService.convertFlatToFlatDto(flat1);
        assertNull(actualConvertFlatToFlatDtoResult.getCountry());
        assertEquals(
                "FlatDto(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                        + " images=[https://example.org/example], id=123, ownerUsername=janedoe, ownerID=123)",
                actualConvertFlatToFlatDtoResult.toString());
        assertNull(actualConvertFlatToFlatDtoResult.getTown());
        assertNull(actualConvertFlatToFlatDtoResult.getStreet());
        assertEquals(0.0f, actualConvertFlatToFlatDtoResult.getPrice());
        assertEquals("janedoe", actualConvertFlatToFlatDtoResult.getOwnerUsername());
        assertEquals(123L, actualConvertFlatToFlatDtoResult.getOwnerID());
        assertEquals(123L, actualConvertFlatToFlatDtoResult.getId());
        List<String> images = actualConvertFlatToFlatDtoResult.getImages();
        assertEquals(1, images.size());
        assertEquals("https://example.org/example", images.get(0));
        assertNull(actualConvertFlatToFlatDtoResult.getHouseNom());
        assertEquals(0, actualConvertFlatToFlatDtoResult.getFloor());
        assertNull(actualConvertFlatToFlatDtoResult.getDescription());
    }
}


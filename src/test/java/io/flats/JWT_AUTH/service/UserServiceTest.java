package io.flats.JWT_AUTH.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.flats.JWT_AUTH.payload.UserDtoPayload;
import io.flats.dto.UserDto;
import io.flats.entity.Comments;
import io.flats.entity.Flat;
import io.flats.entity.Likes;
import io.flats.entity.Role;
import io.flats.entity.User;
import io.flats.exception.UserNotFoundExeption;
import io.flats.repository.FlatRepository;
import io.flats.repository.RoleRepository;
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

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    @MockBean
    private FlatRepository flatRepository;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testPasswordEncoder() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        this.userService.passwordEncoder();
    }

    @Test
    public void testFindByUsername() {
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
        Optional<User> actualFindByUsernameResult = this.userService.findByUsername("janedoe");
        assertSame(ofResult, actualFindByUsernameResult);
        assertTrue(actualFindByUsernameResult.isPresent());
        verify(this.userRepository, times(2)).findByUsername(anyString());
    }

    @Test
    public void testFindByUsername2() {
        Optional<User> emptyResult = Optional.<User>empty();
        when(this.userRepository.findByUsername(anyString())).thenReturn(emptyResult);
        Optional<User> actualFindByUsernameResult = this.userService.findByUsername("janedoe");
        assertSame(emptyResult, actualFindByUsernameResult);
        assertFalse(actualFindByUsernameResult.isPresent());
        verify(this.userRepository, times(2)).findByUsername(anyString());
    }

    @Test
    public void testFindById() {
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
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<User> actualFindByIdResult = this.userService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.userRepository, times(2)).findById((Long) any());
    }

    @Test
    public void testFindById2() {
        Optional<User> emptyResult = Optional.<User>empty();
        when(this.userRepository.findById((Long) any())).thenReturn(emptyResult);
        Optional<User> actualFindByIdResult = this.userService.findById(123L);
        assertSame(emptyResult, actualFindByIdResult);
        assertFalse(actualFindByIdResult.isPresent());
        verify(this.userRepository, times(2)).findById((Long) any());
    }

    @Test
    public void testRegisterNewSailor() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        Optional<Role> ofResult = Optional.<Role>of(role);
        when(this.roleRepository.findByName(anyString())).thenReturn(ofResult);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

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
        user.setRole(role1);
        when(this.userRepository.save((User) any())).thenReturn(user);
        User actualRegisterNewSailorResult = this.userService.registerNewSailor(new UserDtoPayload("Jane", "Second Name",
                "Doe", "janedoe", "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example"));
        assertEquals("janedoe", actualRegisterNewSailorResult.getUsername());
        assertEquals("https://example.org/example", actualRegisterNewSailorResult.getUserProfileImageUrl());
        assertEquals("Second Name", actualRegisterNewSailorResult.getSecondName());
        assertEquals("jane.doe@example.org", actualRegisterNewSailorResult.getEmail());
        assertEquals("Doe", actualRegisterNewSailorResult.getLastName());
        assertEquals(0.0f, actualRegisterNewSailorResult.getRating());
        assertEquals("Jane", actualRegisterNewSailorResult.getFirstName());
        assertSame(role, actualRegisterNewSailorResult.getRole());
        assertEquals("4105551212", actualRegisterNewSailorResult.getPhoneNumber());
        verify(this.roleRepository).findByName(anyString());
        verify(this.userRepository).save((User) any());
    }

    @Test
    public void testRegisterNewSailor2() {
        when(this.roleRepository.findByName(anyString())).thenReturn(Optional.<Role>empty());

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
        when(this.userRepository.save((User) any())).thenReturn(user);
        assertThrows(NoSuchElementException.class,
                () -> this.userService.registerNewSailor(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                        "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
        verify(this.roleRepository).findByName(anyString());
    }

//    @Test
//    public void testRegisterNewSailor3() {
//        Role role = new Role();
//        role.setId(123L);
//        role.setName("Name");
//        Optional<Role> ofResult = Optional.<Role>of(role);
//        when(this.roleRepository.findByName(anyString())).thenReturn(ofResult);
//
//        Role role1 = new Role();
//        role1.setId(123L);
//        role1.setName("Name");
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
//        user.setRole(role1);
//        when(this.userRepository.save((User) any())).thenReturn(user);
//        this.userService.registerNewSailor(new UserDtoPayload());
//        verify(this.roleRepository).findByName(anyString());
//    }

    @Test
    public void testRegisterNewRealtor() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        Optional<Role> ofResult = Optional.<Role>of(role);
        when(this.roleRepository.findByName(anyString())).thenReturn(ofResult);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

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
        user.setRole(role1);
        when(this.userRepository.save((User) any())).thenReturn(user);
        User actualRegisterNewRealtorResult = this.userService.registerNewRealtor(new UserDtoPayload("Jane", "Second Name",
                "Doe", "janedoe", "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example"));
        assertEquals("janedoe", actualRegisterNewRealtorResult.getUsername());
        assertEquals("https://example.org/example", actualRegisterNewRealtorResult.getUserProfileImageUrl());
        assertEquals("Second Name", actualRegisterNewRealtorResult.getSecondName());
        assertEquals("jane.doe@example.org", actualRegisterNewRealtorResult.getEmail());
        assertEquals("Doe", actualRegisterNewRealtorResult.getLastName());
        assertEquals(0.0f, actualRegisterNewRealtorResult.getRating());
        assertEquals("Jane", actualRegisterNewRealtorResult.getFirstName());
        assertSame(role, actualRegisterNewRealtorResult.getRole());
        assertEquals("4105551212", actualRegisterNewRealtorResult.getPhoneNumber());
        verify(this.roleRepository).findByName(anyString());
        verify(this.userRepository).save((User) any());
    }

    @Test
    public void testRegisterNewRealtor2() {
        when(this.roleRepository.findByName(anyString())).thenReturn(Optional.<Role>empty());

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
        when(this.userRepository.save((User) any())).thenReturn(user);
        assertThrows(NoSuchElementException.class,
                () -> this.userService.registerNewRealtor(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                        "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
        verify(this.roleRepository).findByName(anyString());
    }

//    testGetAdditRealtorInfo2

    @Test
    public void testFindByEmail() {
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
        when(this.userRepository.findByEmail(anyString())).thenReturn(ofResult);
        Optional<User> actualFindByEmailResult = this.userService.findByEmail("jane.doe@example.org");
        assertSame(ofResult, actualFindByEmailResult);
        assertTrue(actualFindByEmailResult.isPresent());
        verify(this.userRepository, times(2)).findByEmail(anyString());
    }

    @Test
    public void testFindByEmail2() {
        Optional<User> emptyResult = Optional.<User>empty();
        when(this.userRepository.findByEmail(anyString())).thenReturn(emptyResult);
        Optional<User> actualFindByEmailResult = this.userService.findByEmail("jane.doe@example.org");
        assertSame(emptyResult, actualFindByEmailResult);
        assertFalse(actualFindByEmailResult.isPresent());
        verify(this.userRepository, times(2)).findByEmail(anyString());
    }

    @Test
    public void testFindAllRieltors() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        Optional<Role> ofResult = Optional.<Role>of(role);
        when(this.roleRepository.findByName(anyString())).thenReturn(ofResult);
        ArrayList<User> userList = new ArrayList<User>();
        when(this.userRepository.findAllByRole((Role) any())).thenReturn(Optional.<List<User>>of(userList));
        List<User> actualFindAllRieltorsResult = this.userService.findAllRieltors();
        assertSame(userList, actualFindAllRieltorsResult);
        assertTrue(actualFindAllRieltorsResult.isEmpty());
        verify(this.roleRepository).findByName(anyString());
        verify(this.userRepository).findAllByRole((Role) any());
    }

    @Test
    public void testFindAllRieltors2() {
        when(this.roleRepository.findByName(anyString())).thenReturn(Optional.<Role>empty());
        when(this.userRepository.findAllByRole((Role) any())).thenReturn(Optional.<List<User>>of(new ArrayList<User>()));
        assertThrows(RuntimeException.class, () -> this.userService.findAllRieltors());
        verify(this.roleRepository).findByName(anyString());
    }

    @Test
    public void testFindAllRieltors3() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        Optional<Role> ofResult = Optional.<Role>of(role);
        when(this.roleRepository.findByName(anyString())).thenReturn(ofResult);
        when(this.userRepository.findAllByRole((Role) any())).thenReturn(Optional.<List<User>>empty());
        assertThrows(UserNotFoundExeption.class, () -> this.userService.findAllRieltors());
        verify(this.roleRepository).findByName(anyString());
        verify(this.userRepository).findAllByRole((Role) any());
    }

    @Test
    public void testConvertUserToUserDto() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User(123L, "janedoe");
        user.setRole(role);
        UserDto actualConvertUserToUserDtoResult = this.userService.convertUserToUserDto(user);
        assertEquals("janedoe", actualConvertUserToUserDtoResult.getUsername());
        assertNull(actualConvertUserToUserDtoResult.getSecondName());
        assertEquals("Name", actualConvertUserToUserDtoResult.getRole());
        assertNull(actualConvertUserToUserDtoResult.getPhoneNumber());
        assertNull(actualConvertUserToUserDtoResult.getLastName());
        assertEquals(123L, actualConvertUserToUserDtoResult.getId());
        assertNull(actualConvertUserToUserDtoResult.getFirstName());
        assertNull(actualConvertUserToUserDtoResult.getEmail());
    }

    @Test
    public void testGetAdditRealtorInfo() {
        when(this.flatRepository.findAllByOwner((User) any())).thenReturn(new ArrayList<Flat>());

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
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals(0, this.userService.getAdditRealtorInfo(123L));
        verify(this.flatRepository).findAllByOwner((User) any());
        verify(this.userRepository).findById((Long) any());
    }

//    @Test
//    public void testGetAdditRealtorInfo2() {
//        when(this.flatRepository.findAllByOwner((User) any())).thenReturn(new ArrayList<Flat>());
//        when(this.userRepository.findById((Long) any())).thenReturn(Optional.<User>empty());
//        this.userService.getAdditRealtorInfo(123L);
//        verify(this.userRepository).findById((Long) any());
//    }
}


package io.flats.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.flats.JWT_AUTH.exeption.NotFoundException;
import io.flats.entity.Comments;
import io.flats.entity.Flat;
import io.flats.entity.FlatOrderType;
import io.flats.entity.FlatsImages;
import io.flats.entity.Likes;
import io.flats.entity.Role;
import io.flats.entity.User;
import io.flats.exception.UserNotFoundExeption;
import io.flats.repository.CommentsRepository;
import io.flats.repository.FlatRepository;
import io.flats.repository.LikesRepository;
import io.flats.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {LikeAndCommentService.class})
@ExtendWith(SpringExtension.class)
public class LikeAndCommentServiceTest {
    @MockBean
    private CommentsRepository commentsRepository;

    @MockBean
    private FlatRepository flatRepository;

    @Autowired
    private LikeAndCommentService likeAndCommentService;

    @MockBean
    private LikesRepository likesRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testGetReceivedCommentsByUserId() {
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
        ArrayList<Comments> commentsList = new ArrayList<Comments>();
        user.setReceivedCommentsToFlats(commentsList);
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);
        Optional<User> ofResult = Optional.<User>of(user);
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
        List<Comments> actualReceivedCommentsByUserId = this.likeAndCommentService.getReceivedCommentsByUserId(123L);
        assertSame(commentsList, actualReceivedCommentsByUserId);
        assertTrue(actualReceivedCommentsByUserId.isEmpty());
        verify(this.userRepository).findById((Long) any());
    }

    @Test
    public void testGetReceivedCommentsByUserId2() {
        when(this.userRepository.findById((Long) any())).thenReturn(Optional.<User>empty());
        assertThrows(UserNotFoundExeption.class, () -> this.likeAndCommentService.getReceivedCommentsByUserId(123L));
        verify(this.userRepository).findById((Long) any());
    }

    @Test
    public void testGetPuttedCommentsByUserId() {
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
        ArrayList<Comments> commentsList = new ArrayList<Comments>();
        user.setPuttedCommentsToFlats(commentsList);
        user.setRating(10.0f);
        user.setRole(role);
        Optional<User> ofResult = Optional.<User>of(user);
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
        List<Comments> actualPuttedCommentsByUserId = this.likeAndCommentService.getPuttedCommentsByUserId(123L);
        assertSame(commentsList, actualPuttedCommentsByUserId);
        assertTrue(actualPuttedCommentsByUserId.isEmpty());
        verify(this.userRepository).findById((Long) any());
    }

    @Test
    public void testGetPuttedCommentsByUserId2() {
        when(this.userRepository.findById((Long) any())).thenReturn(Optional.<User>empty());
        assertThrows(UserNotFoundExeption.class, () -> this.likeAndCommentService.getPuttedCommentsByUserId(123L));
        verify(this.userRepository).findById((Long) any());
    }

    @Test
    public void testGetLikesOfFlatById() {
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
        ArrayList<Likes> likesList = new ArrayList<Likes>();
        flat.setFlatsLikes(likesList);
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");
        Optional<Flat> ofResult = Optional.<Flat>of(flat);
        when(this.flatRepository.findById((Long) any())).thenReturn(ofResult);
        List<Likes> actualLikesOfFlatById = this.likeAndCommentService.getLikesOfFlatById(123L);
        assertSame(likesList, actualLikesOfFlatById);
        assertTrue(actualLikesOfFlatById.isEmpty());
        verify(this.flatRepository).findById((Long) any());
    }

    @Test
    public void testGetLikesOfFlatById2() {
        when(this.flatRepository.findById((Long) any())).thenReturn(Optional.<Flat>empty());
        assertThrows(NotFoundException.class, () -> this.likeAndCommentService.getLikesOfFlatById(123L));
        verify(this.flatRepository).findById((Long) any());
    }

    @Test
    public void testGetLikesOfUserById() {
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
        ArrayList<Likes> likesList = new ArrayList<Likes>();
        user.setPuttedLikesToFlats(likesList);
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);
        Optional<User> ofResult = Optional.<User>of(user);
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
        List<Likes> actualLikesOfUserById = this.likeAndCommentService.getLikesOfUserById(123L);
        assertSame(likesList, actualLikesOfUserById);
        assertTrue(actualLikesOfUserById.isEmpty());
        verify(this.userRepository).findById((Long) any());
    }

    @Test
    public void testGetLikesOfUserById2() {
        when(this.userRepository.findById((Long) any())).thenReturn(Optional.<User>empty());
        assertThrows(NotFoundException.class, () -> this.likeAndCommentService.getLikesOfUserById(123L));
        verify(this.userRepository).findById((Long) any());
    }
}


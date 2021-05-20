package io.flats.JWT_AUTH.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.flats.entity.Comments;
import io.flats.entity.Likes;
import io.flats.entity.Role;
import io.flats.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

public class JwtUserFactoryTest {
    @Test
    public void testCreate() {
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
        JwtUser actualCreateResult = JwtUserFactory.create(user);
        Collection<? extends GrantedAuthority> authorities = actualCreateResult.getAuthorities();
        assertEquals(1, authorities.size());
        assertEquals("iloveyou", actualCreateResult.getPassword());
        assertEquals("janedoe", actualCreateResult.getUsername());
        assertEquals("Name", ((ArrayList<? extends GrantedAuthority>) authorities).get(0).getAuthority());
    }

//    @Test
//    public void testCreate2() {
//        // TODO: This test is incomplete.
//        //   Reason: No meaningful assertions found.
//        //   To help Diffblue Cover to find assertions, please add getters to the
//        //   class under test that return fields written by the method under test.
//        //   See https://diff.blue/R004
//
//        Role role = new Role();
//        role.setId(123L);
//        role.setName("");
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
//        JwtUserFactory.create(user);
//    }
}


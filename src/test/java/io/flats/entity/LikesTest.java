package io.flats.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class LikesTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Likes()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        Likes likes = new Likes();

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

        Likes likes1 = new Likes();
        likes1.setUser(user);
        likes1.setId(123L);
        likes1.setFlat(flat);
        assertTrue(likes.canEqual(likes1));
    }

    @Test
    public void testConstructor() {
        Likes actualLikes = new Likes();
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
        actualLikes.setFlat(flat);
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
        actualLikes.setUser(user1);
        assertSame(flat, actualLikes.getFlat());
        User user2 = actualLikes.getUser();
        assertSame(user1, user2);
        assertEquals(user, user2);
        assertEquals("Likes(user=User{id=123, email='jane.doe@example.org'}, flat=Flat(country=Country, town=Oxford,"
                + " street=Street, houseNom=House Nom, floor=1, price=10.0, description=The characteristics of someone"
                + " or something, orderType=FlatOrderType(name=Name), owner=User{id=123, email='jane.doe@example.org'},"
                + " flatsImages=[], flatsLikes=[]))", actualLikes.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new Likes()).equals("42"));
    }

    @Test
    public void testEquals2() {
        Likes likes = new Likes();

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

        Likes likes1 = new Likes();
        likes1.setUser(user);
        likes1.setId(123L);
        likes1.setFlat(flat);
        assertFalse(likes.equals(likes1));
    }

    @Test
    public void testEquals3() {
        Likes likes = new Likes();
        assertTrue(likes.equals(new Likes()));
    }

    @Test
    public void testEquals4() {
        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode(null);
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(null);
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user.setUsername("janedoe");
        user.setSecondName(null);
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);

        Likes likes = new Likes();
        likes.setUser(user);
        assertFalse(likes.equals(new Likes()));
    }

    @Test
    public void testEquals5() {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName(null);

        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode(null);
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(null);
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user.setUsername("janedoe");
        user.setSecondName(null);
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry(null);
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setFlatsLikes(new ArrayList<Likes>());
        flat.setHouseNom(null);
        flat.setStreet(null);

        Likes likes = new Likes();
        likes.setFlat(flat);
        assertFalse(likes.equals(new Likes()));
    }

    @Test
    public void testEquals6() {
        Likes likes = new Likes();

        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName(null);

        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode(null);
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(null);
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user.setUsername("janedoe");
        user.setSecondName(null);
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry(null);
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setFlatsLikes(new ArrayList<Likes>());
        flat.setHouseNom(null);
        flat.setStreet(null);

        Likes likes1 = new Likes();
        likes1.setFlat(flat);
        assertFalse(likes.equals(likes1));
    }

    @Test
    public void testHashCode() {
        assertEquals(6061, (new Likes()).hashCode());
    }

    @Test
    public void testHashCode2() {
        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode(null);
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(null);
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user.setUsername("janedoe");
        user.setSecondName(null);
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);

        Likes likes = new Likes();
        likes.setUser(user);
        assertEquals(1245165929, likes.hashCode());
    }

    @Test
    public void testHashCode3() {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName(null);

        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode(null);
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(null);
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user.setUsername("janedoe");
        user.setSecondName(null);
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry(null);
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setFlatsLikes(new ArrayList<Likes>());
        flat.setHouseNom(null);
        flat.setStreet(null);

        Likes likes = new Likes();
        likes.setFlat(flat);
        assertEquals(466386586, likes.hashCode());
    }

    @Test
    public void testHashCode4() {
        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode(null);
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(null);
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user.setUsername("janedoe");
        user.setSecondName(null);
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);

        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName(null);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName(null);

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivationCode(null);
        user1.setId(123L);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(null);
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user1.setUsername("janedoe");
        user1.setSecondName(null);
        user1.setPuttedLikesToFlats(new ArrayList<Likes>());
        user1.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user1.setRating(10.0f);
        user1.setRole(role1);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry(null);
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user1);
        flat.setDescription("The characteristics of someone or something");
        flat.setFlatsLikes(new ArrayList<Likes>());
        flat.setHouseNom(null);
        flat.setStreet(null);

        Likes likes = new Likes();
        likes.setUser(user);
        likes.setId(123L);
        likes.setFlat(flat);

        ArrayList<Likes> likesList = new ArrayList<Likes>();
        likesList.add(likes);

        Role role2 = new Role();
        role2.setId(123L);
        role2.setName(null);

        User user2 = new User();
        user2.setLastName("Doe");
        user2.setEmail("jane.doe@example.org");
        user2.setPassword("iloveyou");
        user2.setActivationCode(null);
        user2.setId(123L);
        user2.setPhoneNumber("4105551212");
        user2.setTimeOfAccountCreation(null);
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setFirstName("Jane");
        user2.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user2.setUsername("janedoe");
        user2.setSecondName(null);
        user2.setPuttedLikesToFlats(likesList);
        user2.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user2.setRating(10.0f);
        user2.setRole(role2);

        Likes likes1 = new Likes();
        likes1.setUser(user2);
        assertEquals(-352870459, likes1.hashCode());
    }

    @Test
    public void testHashCode5() {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName(null);

        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode(null);
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(null);
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user.setUsername("janedoe");
        user.setSecondName(null);
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);

        FlatOrderType flatOrderType1 = new FlatOrderType();
        flatOrderType1.setId(123L);
        flatOrderType1.setName(null);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName(null);

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivationCode(null);
        user1.setId(123L);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(null);
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user1.setUsername("janedoe");
        user1.setSecondName(null);
        user1.setPuttedLikesToFlats(new ArrayList<Likes>());
        user1.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user1.setRating(10.0f);
        user1.setRole(role1);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry(null);
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType1);
        flat.setTown("Oxford");
        flat.setOwner(user1);
        flat.setDescription("The characteristics of someone or something");
        flat.setFlatsLikes(new ArrayList<Likes>());
        flat.setHouseNom(null);
        flat.setStreet(null);

        Likes likes = new Likes();
        likes.setUser(user);
        likes.setId(123L);
        likes.setFlat(flat);

        ArrayList<Likes> likesList = new ArrayList<Likes>();
        likesList.add(likes);

        Role role2 = new Role();
        role2.setId(123L);
        role2.setName(null);

        User user2 = new User();
        user2.setLastName("Doe");
        user2.setEmail("jane.doe@example.org");
        user2.setPassword("iloveyou");
        user2.setActivationCode(null);
        user2.setId(123L);
        user2.setPhoneNumber("4105551212");
        user2.setTimeOfAccountCreation(null);
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setFirstName("Jane");
        user2.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user2.setUsername("janedoe");
        user2.setSecondName(null);
        user2.setPuttedLikesToFlats(likesList);
        user2.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user2.setRating(10.0f);
        user2.setRole(role2);

        Flat flat1 = new Flat();
        flat1.setFlatsImages(new ArrayList<FlatsImages>());
        flat1.setPrice(10.0f);
        flat1.setCountry(null);
        flat1.setFloor(0);
        flat1.setId(123L);
        flat1.setOrderType(flatOrderType);
        flat1.setTown("Oxford");
        flat1.setOwner(user2);
        flat1.setDescription("The characteristics of someone or something");
        flat1.setFlatsLikes(new ArrayList<Likes>());
        flat1.setHouseNom(null);
        flat1.setStreet(null);

        Likes likes1 = new Likes();
        likes1.setFlat(flat1);
        assertEquals(671520206, likes1.hashCode());
    }
}


package io.flats.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class CommentsTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Comments()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        Comments comments = new Comments();

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

        Comments comments1 = new Comments();
        comments1.setId(123L);
        comments1.setUserTo(user);
        comments1.setUser_from(user1);
        comments1.setCommentText("Comment Text");
        comments1.setRating(10.0f);
        assertTrue(comments.canEqual(comments1));
    }

    @Test
    public void testConstructor() {
        Comments actualComments = new Comments();
        actualComments.setCommentText("Comment Text");
        actualComments.setRating(10.0f);
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
        actualComments.setUserTo(user);
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
        actualComments.setUser_from(user1);
        assertEquals("Comment Text", actualComments.getCommentText());
        assertEquals(10.0f, actualComments.getRating());
        User user_from = actualComments.getUser_from();
        User userTo = actualComments.getUserTo();
        assertEquals(user_from, userTo);
        assertSame(user, userTo);
        assertEquals(user, user_from);
        assertSame(user1, user_from);
        assertEquals("Comments(user_from=User{id=123, email='jane.doe@example.org'}, userTo=User{id=123, email='jane.doe"
                + "@example.org'}, commentText=Comment Text, rating=10.0)", actualComments.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new Comments()).equals("42"));
    }

    @Test
    public void testEquals2() {
        Comments comments = new Comments();

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

        Comments comments1 = new Comments();
        comments1.setId(123L);
        comments1.setUserTo(user);
        comments1.setUser_from(user1);
        comments1.setCommentText("Comment Text");
        comments1.setRating(10.0f);
        assertFalse(comments.equals(comments1));
    }

    @Test
    public void testEquals3() {
        Comments comments = new Comments();
        assertTrue(comments.equals(new Comments()));
    }

    @Test
    public void testHashCode() {
        assertEquals(12269624, (new Comments()).hashCode());
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

        Comments comments = new Comments();
        comments.setUserTo(user);
        assertEquals(1257429492, comments.hashCode());
    }

    @Test
    public void testHashCode3() {
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

        Comments comments = new Comments();
        comments.setUser_from(user);
        assertEquals(462257804, comments.hashCode());
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

        Comments comments = new Comments();
        comments.setId(123L);
        comments.setUserTo(user);
        comments.setUser_from(user1);
        comments.setCommentText(null);
        comments.setRating(10.0f);

        ArrayList<Comments> commentsList = new ArrayList<Comments>();
        commentsList.add(comments);

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
        user2.setReceivedCommentsToFlats(commentsList);
        user2.setUsername("janedoe");
        user2.setSecondName(null);
        user2.setPuttedLikesToFlats(new ArrayList<Likes>());
        user2.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user2.setRating(10.0f);
        user2.setRole(role2);

        Comments comments1 = new Comments();
        comments1.setUserTo(user2);
        assertEquals(511791478, comments1.hashCode());
    }

    @Test
    public void testHashCode5() {
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

        Comments comments = new Comments();
        comments.setId(123L);
        comments.setUserTo(user);
        comments.setUser_from(user1);
        comments.setCommentText(null);
        comments.setRating(10.0f);

        ArrayList<Comments> commentsList = new ArrayList<Comments>();
        commentsList.add(comments);

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
        user2.setReceivedCommentsToFlats(commentsList);
        user2.setUsername("janedoe");
        user2.setSecondName(null);
        user2.setPuttedLikesToFlats(new ArrayList<Likes>());
        user2.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user2.setRating(10.0f);
        user2.setRole(role2);

        Comments comments1 = new Comments();
        comments1.setUser_from(user2);
        assertEquals(-580712062, comments1.hashCode());
    }

//    @Test
//    public void testHashCode6() {
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
//
//        Role role1 = new Role();
//        role1.setId(123L);
//        role1.setName("Name");
//
//        User user1 = new User();
//        user1.setLastName("Doe");
//        user1.setEmail("jane.doe@example.org");
//        user1.setPassword("iloveyou");
//        user1.setActivationCode("Activation Code");
//        user1.setId(123L);
//        user1.setPhoneNumber("4105551212");
//        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
//        user1.setUserProfileImageUrl("https://example.org/example");
//        user1.setFirstName("Jane");
//        user1.setReceivedCommentsToFlats(new ArrayList<Comments>());
//        user1.setUsername("janedoe");
//        user1.setSecondName("Second Name");
//        user1.setPuttedLikesToFlats(new ArrayList<Likes>());
//        user1.setPuttedCommentsToFlats(new ArrayList<Comments>());
//        user1.setRating(10.0f);
//        user1.setRole(role1);
//
//        Comments comments = new Comments();
//        comments.setId(123L);
//        comments.setUserTo(user);
//        comments.setUser_from(user1);
//        comments.setCommentText("Comment Text");
//        comments.setRating(10.0f);
//
//        ArrayList<Comments> commentsList = new ArrayList<Comments>();
//        commentsList.add(comments);
//        commentsList.addAll(new ArrayList<? extends Comments>());
//
//        Role role2 = new Role();
//        role2.setId(123L);
//        role2.setName(null);
//
//        User user2 = new User();
//        user2.setLastName("Doe");
//        user2.setEmail("jane.doe@example.org");
//        user2.setPassword("iloveyou");
//        user2.setActivationCode(null);
//        user2.setId(123L);
//        user2.setPhoneNumber("4105551212");
//        user2.setTimeOfAccountCreation(null);
//        user2.setUserProfileImageUrl("https://example.org/example");
//        user2.setFirstName("Jane");
//        user2.setReceivedCommentsToFlats(commentsList);
//        user2.setUsername("janedoe");
//        user2.setSecondName(null);
//        user2.setPuttedLikesToFlats(new ArrayList<Likes>());
//        user2.setPuttedCommentsToFlats(new ArrayList<Comments>());
//        user2.setRating(10.0f);
//        user2.setRole(role2);
//
//        Comments comments1 = new Comments();
//        comments1.setUserTo(user2);
//        assertEquals(-785677713, comments1.hashCode());
//    }
}


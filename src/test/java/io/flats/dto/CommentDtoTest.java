package io.flats.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CommentDtoTest {
    @Test
    public void testConstructor() {
        UserDto user_from = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        CommentDto actualCommentDto = new CommentDto(user_from, new UserProfileImageUrlDto("https://example.org/example"),
                "Comment", 10.0f);
        assertEquals("Comment", actualCommentDto.getComment());
        assertEquals(
                "CommentDto(user_from=UserDto(id=0, firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe,"
                        + " email=jane.doe@example.org, phoneNumber=4105551212, role=Role, rating=0.0, dateUserFrom=null,"
                        + " realtorsCommentsNomber=0), img_from=UserProfileImageUrlDto(img=https://example.org/example),"
                        + " comment=Comment, rating=10.0)",
                actualCommentDto.toString());
        assertEquals(10.0f, actualCommentDto.getRating());
    }
}


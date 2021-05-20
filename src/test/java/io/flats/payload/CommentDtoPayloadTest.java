package io.flats.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CommentDtoPayloadTest {
    @Test
    public void testConstructor() {
        CommentDtoPayload actualCommentDtoPayload = new CommentDtoPayload(1L, "Comment Text", 10.0f);
        assertEquals("Comment Text", actualCommentDtoPayload.getCommentText());
        assertEquals(10.0f, actualCommentDtoPayload.getRating());
        assertEquals(1L, actualCommentDtoPayload.getId_to());
    }
}


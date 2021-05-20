package io.flats.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDtoPayload {
    protected long id_to;
    protected String commentText;
    protected float rating;

    public CommentDtoPayload(long id_to, String commentText, float rating) {
        this.id_to = id_to;
        this.commentText = commentText;
        this.rating = rating;
    }
}

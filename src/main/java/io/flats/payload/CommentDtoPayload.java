package io.flats.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDtoPayload {
    protected long id_to;
    protected String commentText;

    public CommentDtoPayload(long id_to, String commentText) {
        this.id_to = id_to;
        this.commentText = commentText;
    }
}

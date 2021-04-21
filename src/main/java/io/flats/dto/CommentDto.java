package io.flats.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {
    UserDto user_from;
    UserProfileImageUrlDto img_from;

    String comment;

    public CommentDto(UserDto user_from, UserProfileImageUrlDto img_from, String comment) {
        this.user_from = user_from;
        this.img_from = img_from;
        this.comment = comment;
    }
}

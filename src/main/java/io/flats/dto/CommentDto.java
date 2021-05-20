package io.flats.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {
    UserDto user_from;
    UserProfileImageUrlDto img_from;

    String comment;
    float rating;

    public CommentDto(UserDto user_from, UserProfileImageUrlDto img_from, String comment, float rating) {
        this.user_from = user_from;
        this.img_from = img_from;
        this.comment = comment;
        this.rating = rating;
    }
}

package io.flats.dto;

import lombok.Data;

@Data
public class UserProfileImageUrlDto {
    private String img;

    public UserProfileImageUrlDto(String img) {
        this.img = img;
    }
}

package io.flats.dto;

import lombok.Data;

@Data
public class UserProfileImageUrlDto {
    private String url;

    public UserProfileImageUrlDto(String url) {
        this.url = url;
    }
}

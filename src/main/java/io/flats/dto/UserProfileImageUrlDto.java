package io.flats.dto;

import lombok.Data;

/**
 * The type User profile image url dto.
 */
@Data
public class UserProfileImageUrlDto {
    private String img;

    /**
     * Instantiates a new User profile image url dto.
     *
     * @param img the img
     */
    public UserProfileImageUrlDto(String img) {
        this.img = img;
    }
}

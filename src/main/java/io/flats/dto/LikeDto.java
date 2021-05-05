package io.flats.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import io.flats.entity.Flat;
import io.flats.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikeDto {
    protected UserDto user;
    protected FlatDto flat;

    public LikeDto(UserDto user) {
        this.user = user;
    }

    public LikeDto(UserDto user, FlatDto flat) {
        this.user = user;
        this.flat = flat;
    }
}

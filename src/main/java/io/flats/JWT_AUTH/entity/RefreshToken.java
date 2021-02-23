package io.flats.JWT_AUTH.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "refresh_tokens")
@Data
@NoArgsConstructor
public class RefreshToken {
    @Column(name = "user_id")
    protected long userId;

    @Id
    @Column(name = "refresh_token")
    protected String refreshToken;

    public RefreshToken(long userId, String refreshToken) {
        this.userId = userId;
        this.refreshToken = refreshToken;
    }
}
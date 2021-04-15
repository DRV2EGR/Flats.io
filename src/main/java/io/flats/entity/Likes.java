package io.flats.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="flats_likes")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class Likes extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "user_id")
    protected User user;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    protected Flat flat;
}

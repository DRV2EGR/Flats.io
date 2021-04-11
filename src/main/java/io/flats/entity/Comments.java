package io.flats.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="users_comments")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class Comments extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "user_id_from")
    protected User user_from;

    @ManyToOne
    @JoinColumn(name = "user_id_to")
    protected User user_to;
}

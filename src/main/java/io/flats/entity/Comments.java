package io.flats.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="comments")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Comments extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "user_id_from")
    protected User user_from;

    @ManyToOne
    @JoinColumn(name = "user_id_to")
    protected User userTo;

    @Column(columnDefinition = "TEXT")
    protected String commentText;

    protected float rating;

}

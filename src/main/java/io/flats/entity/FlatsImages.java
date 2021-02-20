package io.flats.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="flats_images")
public class FlatsImages extends BaseEntity {

    protected String imgUrl;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    protected Flat flat;
}

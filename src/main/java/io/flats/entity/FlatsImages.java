package io.flats.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The type Flats images.
 */
@Entity
@Table(name="flats_images")
@Data
public class FlatsImages extends BaseEntity {

    /**
     * The Img url.
     */
    protected String imgUrl;

    /**
     * The Flat.
     */
    @ManyToOne
    @JoinColumn(name = "flat_id")
    protected Flat flat;
}

package io.flats.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The type Flat.
 */
@Entity
@Table(name = "flats")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Flat extends BaseEntity {


    /**
     * The Country.
     */
    protected String country;
    /**
     * The Town.
     */
    protected String town;
    /**
     * The Street.
     */
    protected String street;
    /**
     * The House nom.
     */
    protected int houseNom;
    /**
     * The Floor.
     */
    protected int floor;

    /**
     * The Price.
     */
    protected float price;

    /**
     * The Description.
     */
    protected String description;

    /**
     * The Order type.
     */
    @ManyToOne
    @JoinColumn(name = "flat_order_type_id", referencedColumnName = "id")
    protected FlatOrderType orderType;

    /**
     * The Owner.
     */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected User owner;

    /**
     * The Flats images.
     */
    @OneToMany(mappedBy="flat")
    protected List<FlatsImages> flatsImages;
}

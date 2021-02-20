package io.flats.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "flats")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Flat extends BaseEntity {


    protected String country;
    protected String town;
    protected String street;
    protected int houseNom;
    protected int floor;

    protected float price;

    protected String description;

    @ManyToOne
    @JoinColumn(name = "flat_order_type_id", referencedColumnName = "id")
    protected FlatOrderType orderType;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected User owner;

    @OneToMany(mappedBy="flat")
    protected List<FlatsImages> flatsImages;
}

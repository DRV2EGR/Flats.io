package io.flats.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    protected String description;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected User owner;
}

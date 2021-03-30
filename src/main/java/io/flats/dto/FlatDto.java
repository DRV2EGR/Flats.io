package io.flats.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Flat dto.
 */
@Data
@NoArgsConstructor
public class FlatDto {
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
     * The Images.
     */
    protected List<String> images;

    /**
     * The Id.
     */
    protected long id;

    protected String ownerUsername;

    protected long ownerID;

    public FlatDto(String country, String town, String street, int houseNom,
                   int floor, float price, String description, List<String> images, long id, String ownerUsername, long ownerID) {
        this.country = country;
        this.town = town;
        this.street = street;
        this.houseNom = houseNom;
        this.floor = floor;
        this.price = price;
        this.description = description;
        this.images = images;
        this.id = id;
        this.ownerUsername = ownerUsername;
        this.ownerID = ownerID;
    }

    public void setImageListToNew() {
        this.images = new ArrayList<>();
    }
}

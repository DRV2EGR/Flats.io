package io.flats.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

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

    /**
     * Instantiates a new Flat dto.
     *
     * @param country     the country
     * @param town        the town
     * @param street      the street
     * @param houseNom    the house nom
     * @param floor       the floor
     * @param price       the price
     * @param description the description
     * @param images      the images
     * @param id          the id
     */
    public FlatDto(String country, String town, String street, int houseNom, int floor, float price, String description, List<String> images, long id) {
        this.country = country;
        this.town = town;
        this.street = street;
        this.houseNom = houseNom;
        this.floor = floor;
        this.price = price;
        this.description = description;
        this.images = images;
        this.id = id;
    }
}

package io.flats.payload;

import io.flats.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Flat dto payload.
 */
@Data
@NoArgsConstructor
public class FlatDtoPayload {
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
     * The User id.
     */
//TODO: исправить на получение юзверя из авторизации
    protected long userId;

    /**
     * Instantiates a new Flat dto payload.
     *
     * @param country     the country
     * @param town        the town
     * @param street      the street
     * @param houseNom    the house nom
     * @param floor       the floor
     * @param price       the price
     * @param description the description
     * @param userId      the user id
     */
    public FlatDtoPayload(String country, String town, String street,
                          int houseNom, int floor, float price,
                          String description, long userId) {
        this.country = country;
        this.town = town;
        this.street = street;
        this.houseNom = houseNom;
        this.floor = floor;
        this.price = price;
        this.description = description;
        this.userId = userId;
    }
}

package io.flats.payload;

import java.util.List;

import io.flats.entity.FlatsImages;
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

    protected boolean forSale;

    protected boolean forRent;



    /**
     * The User id.
     */
//TODO: исправить на получение юзверя из авторизации
    protected String username;

    protected List<String> flatsImages;

    public FlatDtoPayload(String country, String town, String street, int houseNom,
                          int floor, float price, String description, boolean forSale,
                          boolean forRent, String username, List<String> flatsImages) {
        this.country = country;
        this.town = town;
        this.street = street;
        this.houseNom = houseNom;
        this.floor = floor;
        this.price = price;
        this.description = description;
        this.forSale = forSale;
        this.forRent = forRent;
        this.username = username;
        this.flatsImages = flatsImages;
    }
}

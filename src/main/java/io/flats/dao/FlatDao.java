package io.flats.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlatDao {
    protected String country;
    protected String town;
    protected String street;
    protected int houseNom;
    protected int floor;

    protected String description;

    public FlatDao(String country, String town, String street, int houseNom, int floor, String description) {
        this.country = country;
        this.town = town;
        this.street = street;
        this.houseNom = houseNom;
        this.floor = floor;
        this.description = description;
    }
}

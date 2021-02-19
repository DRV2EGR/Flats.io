package io.flats.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlatDto {
    protected String country;
    protected String town;
    protected String street;
    protected int houseNom;
    protected int floor;

    protected float price;

    protected String description;

    public FlatDto(String country, String town, String street, int houseNom, int floor, String description) {
        this.country = country;
        this.town = town;
        this.street = street;
        this.houseNom = houseNom;
        this.floor = floor;
        this.description = description;
    }
}

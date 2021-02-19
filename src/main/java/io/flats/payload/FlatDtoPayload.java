package io.flats.payload;

import io.flats.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlatDtoPayload {
    protected String country;
    protected String town;
    protected String street;
    protected int houseNom;
    protected int floor;

    protected float price;

    protected String description;

    //TODO: исправить на получение юзверя из авторизации
    protected long userId;

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

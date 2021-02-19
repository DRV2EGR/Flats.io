package io.flats.payload;

import io.flats.entity.FlatOrderType;
import io.flats.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
public class AddSaleFlatDaoPayload {
    protected String country;
    protected String town;
    protected String street;
    protected int houseNom;
    protected int floor;

    protected float price;

    protected String description;

    protected FlatOrderType orderType;

    protected User owner;

    public AddSaleFlatDaoPayload(String country, String town, String street, int houseNom, int floor, float price, String description, FlatOrderType orderType, User owner) {
        this.country = country;
        this.town = town;
        this.street = street;
        this.houseNom = houseNom;
        this.floor = floor;
        this.price = price;
        this.description = description;
        this.orderType = orderType;
        this.owner = owner;
    }
}

package io.flats.payload;

import io.flats.entity.FlatOrderType;
import io.flats.entity.User;
import io.flats.exception.UserNotFoundExeption;
import io.flats.repository.FlatOrderTypeRepository;
import io.flats.repository.UserRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
public class AddSaleFlatDaoPayload {
    @Autowired
    FlatOrderTypeRepository flatOrderTypeRepository;

    @Autowired
    UserRepository userRepository;

    protected String country;
    protected String town;
    protected String street;
    protected int houseNom;
    protected int floor;

    protected float price;

    protected String description;

    protected FlatOrderType orderType;

    protected User owner;

    public AddSaleFlatDaoPayload(String country, String town, String street, int houseNom, int floor, float price, String description, long ownerId) {
        this.country = country;
        this.town = town;
        this.street = street;
        this.houseNom = houseNom;
        this.floor = floor;
        this.price = price;
        this.description = description;
        this.orderType = flatOrderTypeRepository.findById(1L).get();
        this.owner = userRepository.findById(ownerId).orElseThrow(
                () -> { throw new UserNotFoundExeption(); }
        );
    }
}

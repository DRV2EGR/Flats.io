package io.flats.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Filter dto payload.
 */
@Data
@NoArgsConstructor
public class FilterDtoPayload {
    /**
     * The Floor nomber.
     */
    public int floorNomber;
    /**
     * The Street name.
     */
    public String streetName;
    /**
     * The Rooms count.
     */
    public int roomsCount;

    /**
     * Instantiates a new Filter dto payload.
     *
     * @param floorNomber the floor nomber
     * @param streetName  the street name
     * @param roomsCount  the rooms count
     */
    public FilterDtoPayload(int floorNomber, String streetName, int roomsCount) {
        this.floorNomber = floorNomber;
        this.streetName = streetName;
        this.roomsCount = roomsCount;
    }
}

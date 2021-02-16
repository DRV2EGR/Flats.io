package io.flats.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FilterPayload {
    public int floorNomber;
    public String streetName;
    public int roomsCount;

    public FilterPayload(int floorNomber, String streetName, int roomsCount) {
        this.floorNomber = floorNomber;
        this.streetName = streetName;
        this.roomsCount = roomsCount;
    }
}

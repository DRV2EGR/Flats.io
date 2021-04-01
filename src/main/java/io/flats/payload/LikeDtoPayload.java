package io.flats.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikeDtoPayload {
    protected long id_from;
    protected long id_to;

    public LikeDtoPayload(long id_from, long id_to) {
        this.id_from = id_from;
        this.id_to = id_to;
    }
}

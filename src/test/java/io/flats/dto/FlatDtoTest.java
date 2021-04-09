package io.flats.dto;

import java.util.List;

import io.flats.JWT_AUTH.payload.UserDtoPayload;
import io.flats.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlatDtoTest {

    @Test
    public void testConstrictorAllArgs() {
        FlatDto fd = new FlatDto("S1Cr1T", "S1Cr1T", "S1Cr1T",
                "S1Cr1T", 12, 12F,
                "S1Cr1T", List.of("S1Cr1T", "S1Cr1T"), 12L,
                "S1Cr1T", 12L);

        assertThat(fd.getCountry()).isEqualTo("S1Cr1T");
        assertThat(fd.getTown()).isEqualTo("S1Cr1T");
        assertThat(fd.getStreet()).isEqualTo("S1Cr1T");
        assertThat(fd.getHouseNom()).isEqualTo("S1Cr1T");
        assertThat(fd.getFloor()).isEqualTo(12);
        assertThat(fd.getPrice()).isEqualTo(12F);
        assertThat(fd.getDescription()).isEqualTo("S1Cr1T");
        assertThat(fd.getImages().size()).isEqualTo(2);
        assertThat(fd.getId()).isEqualTo(12L);
        assertThat(fd.getOwnerUsername()).isEqualTo("S1Cr1T");
        assertThat(fd.getOwnerID()).isEqualTo(12L);
    }

    @Test
    public void testSetImageListToNew() {
        FlatDto fd = new FlatDto();
        fd.setImageListToNew();

        assertThat(fd.getImages()).isNotNull();
    }
}

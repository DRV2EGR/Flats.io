package io.flats;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import io.flats.JWT_AUTH.service.UserService;
import io.flats.entity.Flat;
import io.flats.entity.FlatsImages;
import io.flats.entity.User;
import io.flats.payload.FlatDtoPayload;
import io.flats.repository.FlatRepository;
import io.flats.repository.FlatsImagesRepository;
import io.flats.repository.UserRepository;
import io.flats.service.FlatService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class FlatServiceTest {
    @MockBean
    private FlatRepository flatRepository;

    @MockBean
    private FlatsImagesRepository flatsImagesRepository;

    @Autowired
    private FlatService flatService;

    @Test
    public void testFindImagesByFlatId() {
        given(this.flatRepository.findById(any()))
                .willReturn(
                        java.util.Optional.of(new Flat(20L, List.of(new FlatsImages("S1CR1T", new Flat(20L)))))
                );

        List<String> imgs = flatService.findImagesByFlatId(20L);

        assert (imgs.size() == 1);
        assert (imgs.get(0).equals("S1CR1T"));

    }

    @Test
    public void testFindAll() {
        given(this.flatRepository.findAll())
                .willReturn(
                        List.of(
                                new Flat(10L), new Flat(100L), new Flat(1000L)
                        )
                );

        List<Flat> listOfFlats = flatService.findAll();

        assert (!listOfFlats.isEmpty());
        assert (listOfFlats.size() == 3);

        for (int i = 0; i < listOfFlats.size(); ++i) {
            assert (listOfFlats.get(i).getId() == Math.pow(10, i+1));
        }
    }

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @WithMockUser(username = "john_the_admin", roles = "ADMIN")
    public void testAddSaleFlat() {

        when(flatRepository.save(any(Flat.class))).thenReturn(
                new Flat(20L, List.of(
                        new FlatsImages("S1CR1T", new Flat(20L)),
                        new FlatsImages("OWO_UWU", new Flat(20L))
                ))
        );

        given(flatRepository.findById(any())).willReturn(
                java.util.Optional.of(new Flat(20L, List.of(
                        new FlatsImages("S1CR1T", new Flat(20L)),
                        new FlatsImages("OWO_UWU", new Flat(20L))
                )))
        );

        when(flatsImagesRepository.save(any())).thenReturn(
                new FlatsImages("S1CR1T", new Flat(20L))
        );


        Flat created = flatService.addSaleFlat(
                new FlatDtoPayload("freya", true, false, List.of("S1CR1T", "OWO_UWU"))
        );

        assert(created.getId() == 20L);
        assert (created.getFlatsImages().size() == 2);
        assert (created.getFlatsImages().get(0).getImgUrl().equals("S1CR1T"));
        assert (created.getFlatsImages().get(1).getImgUrl().equals("OWO_UWU"));
    }

    @Test
    @WithMockUser(username = "john_the_admin", roles = "ADMIN")
    public void testAddRentFlat() {

        when(flatRepository.save(any(Flat.class))).thenReturn(
                new Flat(20L, List.of(
                        new FlatsImages("S1CR1T", new Flat(20L)),
                        new FlatsImages("OWO_UWU", new Flat(20L))
                ))
        );

        given(flatRepository.findById(any())).willReturn(
                java.util.Optional.of(new Flat(20L, List.of(
                        new FlatsImages("S1CR1T", new Flat(20L)),
                        new FlatsImages("OWO_UWU", new Flat(20L))
                )))
        );

        when(flatsImagesRepository.save(any())).thenReturn(
                new FlatsImages("S1CR1T", new Flat(20L))
        );


        Flat created = flatService.addRentFlat(
                new FlatDtoPayload("freya", true, false, List.of("S1CR1T", "OWO_UWU"))
        );

        assert(created.getId() == 20L);
        assert (created.getFlatsImages().size() == 2);
        assert (created.getFlatsImages().get(0).getImgUrl().equals("S1CR1T"));
        assert (created.getFlatsImages().get(1).getImgUrl().equals("OWO_UWU"));
    }

    @Test
    public void testFindFlatById() {
        when(flatRepository.findById(any())).thenReturn(
                java.util.Optional.of(new Flat(10L))
        );

        Flat findedFlat = flatService.findFlatById(10L);

        assert (findedFlat.getId() == 10);
    }

    @Test
    public void testDeleteFlatById() {
        final Flat entity = new Flat(20L, List.of(
                new FlatsImages("S1CR1T", new Flat(20L)),
                new FlatsImages("OWO_UWU", new Flat(20L))
        ));
        Optional<Flat> optionalEntityType = Optional.of(entity);

        when(flatRepository.findById(20L)).thenReturn(optionalEntityType);

        // when
        /*boolean b = */flatService.deleteFlatById(entity.getId());
        //System.out.println(b);

        // then
        Mockito.verify(flatRepository, times(1)).delete(entity);
        //I dont think you need to assert to confirm actual delete as you are testing mock registry. to assert somethink like below you need to return null by mocking the same call again and return the null but thats of no use
        //assertThat(flatRepository.findById(20L).get()).isNull();

        //assert (b); - is ok, but then return null doesn't work.

        //TODO: testDeleteFlatById
    }

}

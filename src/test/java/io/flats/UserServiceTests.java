package io.flats;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import io.flats.JWT_AUTH.payload.UserDtoPayload;
import io.flats.JWT_AUTH.service.UserService;
import io.flats.entity.Flat;
import io.flats.entity.User;
import io.flats.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;


    @Test
    public void testBCryptPasswordEncoder() {
        BCryptPasswordEncoder bcpe = userService.passwordEncoder();

        assertThat (bcpe).isInstanceOf(BCryptPasswordEncoder.class);
    }

    @Test
    public void testFindByUsername() {
        given(this.userRepository.findByUsername(any()))
                .willReturn(java.util.Optional.of(new User(1L, "Username")));

        User user = userService.findByUsername("Username").orElse(null);
        assert (user.getUsername().equals("Username"));
    }

    @Test
    public void testFindById() {
        given(this.userRepository.findById(any()))
                .willReturn(java.util.Optional.of(new User(1L, "Username")));

        User user = userService.findById(1L).orElse(null);
        assert (user.getId() == 1);
    }


    @Test
    public void testRegisterNewSailor() {
        UserDtoPayload udp = new UserDtoPayload(
                "Username", "Username", "Username",
                "Username", "Username", "Username",
                "6668855", "Username");

        User created = userService.registerNewSailor(udp);

        assertThat(created.getRole().getName()).isEqualTo("ROLE_SELLER");

        assertThat(created.getFirstName()).isEqualTo(udp.getFirstName());
        assertThat(created.getSecondName()).isEqualTo(udp.getSecondName());
        assertThat(created.getLastName()).isEqualTo(udp.getLastName());
        assertThat(created.getUsername()).isEqualTo(udp.getUsername());
        assertThat(created.getEmail()).isEqualTo(udp.getEmail());
        //assertThat(created.getPassword()).isEqualTo(udp.getPassword());
        assertThat(created.getPhoneNumber()).isEqualTo(udp.getPhoneNumber());
        assertThat(created.getUserProfileImageUrl()).isEqualTo(udp.getUserProfileImageUrl());

    }

    @Test
    public void testRegisterNewRealtor() {
        UserDtoPayload udp = new UserDtoPayload(
                "Username", "Username", "Username",
                "Username", "Username", "Username",
                "6668855", "Username");

        User created = userService.registerNewRealtor(udp);

        assertThat(created.getRole().getName()).isEqualTo("ROLE_REALTOR");

        assertThat(created.getFirstName()).isEqualTo(udp.getFirstName());
        assertThat(created.getSecondName()).isEqualTo(udp.getSecondName());
        assertThat(created.getLastName()).isEqualTo(udp.getLastName());
        assertThat(created.getUsername()).isEqualTo(udp.getUsername());
        assertThat(created.getEmail()).isEqualTo(udp.getEmail());
        //assertThat(created.getPassword()).isEqualTo(udp.getPassword());
        assertThat(created.getPhoneNumber()).isEqualTo(udp.getPhoneNumber());
        assertThat(created.getUserProfileImageUrl()).isEqualTo(udp.getUserProfileImageUrl());

    }

    @Test
    public void testFindByEmail() {
        given(this.userRepository.findByEmail(any()))
                .willReturn(java.util.Optional.of(new User(1L, "Username")));

        User user = userService.findByEmail("Username").orElse(null);
        assert (Objects.requireNonNull(user).getUsername().equals("Username"));
    }

    @Test
    public void testFindAllRieltors() {
        given(this.userRepository.findAllByRole(any()))
                .willReturn(
                        Optional.of(
                                List.of(
                                new User(10L, "Username"),
                                new User(100L, "Username")
                            )
                        )
                );

        List<User> listOfRealtors = userService.findAllRieltors();

        assert (!listOfRealtors.isEmpty());
        assert (listOfRealtors.size() == 2);

        for (int i = 0; i < listOfRealtors.size(); ++i) {
            assert (listOfRealtors.get(i).getId() == Math.pow(10, i+1));
        }
    }

}

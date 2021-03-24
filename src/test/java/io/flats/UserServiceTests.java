package io.flats;

import io.flats.JWT_AUTH.service.UserService;
import io.flats.entity.User;
import io.flats.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    public void testGetById() {
        given(this.userRepository.findById(any()))
                .willReturn(java.util.Optional.of(new User(1L, "Username")));

        User user = userService.findById(1L).orElse(null);
        assert (user.getId() == 1);
    }

    @Test
    public void testGetByUsername() {
        given(this.userRepository.findByUsername(any()))
                .willReturn(java.util.Optional.of(new User(1L, "Username")));

        User user = userService.findByUsername("Username").orElse(null);
        assert (user.getUsername().equals("Username"));
    }
}

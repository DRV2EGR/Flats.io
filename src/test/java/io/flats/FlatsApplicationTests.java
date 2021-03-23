package io.flats;

import io.flats.JWT_AUTH.service.UserService;
import io.flats.entity.User;
import io.flats.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonContentAssert;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlatsApplicationTests {

    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    public void testGetById() {
        given(this.userRepository.findById(any()))
                .willReturn(java.util.Optional.of(new User(1L, "Name")));
        User person = userService.findById(1L).get();
        assert (person.getId() == 1);
    }

}

package io.flats.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FlatsImagesTest {
    @Test
    public void testCanEqual() {
        assertFalse((new FlatsImages()).canEqual("Other"));
        assertFalse((new FlatsImages()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        FlatsImages flatsImages = new FlatsImages();

        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");

        FlatsImages flatsImages1 = new FlatsImages();
        flatsImages1.setImgUrl("https://example.org/example");
        flatsImages1.setId(123L);
        flatsImages1.setFlat(flat);
        assertTrue(flatsImages.canEqual(flatsImages1));
    }

    @Test
    public void testCanEqual3() {
        FlatsImages flatsImages = new FlatsImages();

        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");

        FlatsImages flatsImages1 = new FlatsImages();
        flatsImages1.setImgUrl("https://example.org/example");
        flatsImages1.setId(123L);
        flatsImages1.setFlat(flat);
        assertTrue(flatsImages.canEqual(flatsImages1));
    }

    @Test
    public void testEquals() {
        assertFalse((new FlatsImages()).equals("42"));
        assertFalse((new FlatsImages()).equals("42"));
    }

    @Test
    public void testEquals10() {
        FlatsImages flatsImages = new FlatsImages();

        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");

        FlatsImages flatsImages1 = new FlatsImages();
        flatsImages1.setImgUrl(null);
        flatsImages1.setId(123L);
        flatsImages1.setFlat(flat);
        assertFalse(flatsImages.equals(flatsImages1));
    }

    @Test
    public void testEquals11() {
        FlatsImages flatsImages = new FlatsImages("https://example.org/example", new Flat(123L));
        assertFalse(flatsImages.equals(new FlatsImages()));
    }

    @Test
    public void testEquals2() {
        FlatsImages flatsImages = new FlatsImages();

        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");

        FlatsImages flatsImages1 = new FlatsImages();
        flatsImages1.setImgUrl("https://example.org/example");
        flatsImages1.setId(123L);
        flatsImages1.setFlat(flat);
        assertFalse(flatsImages.equals(flatsImages1));
    }

    @Test
    public void testEquals3() {
        FlatsImages flatsImages = new FlatsImages();
        assertTrue(flatsImages.equals(new FlatsImages()));
    }

    @Test
    public void testEquals4() {
        FlatsImages flatsImages = new FlatsImages("https://example.org/example", new Flat(123L));

        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");

        FlatsImages flatsImages1 = new FlatsImages();
        flatsImages1.setImgUrl("https://example.org/example");
        flatsImages1.setId(123L);
        flatsImages1.setFlat(flat);
        assertFalse(flatsImages.equals(flatsImages1));
    }

    @Test
    public void testEquals5() {
        FlatsImages flatsImages = new FlatsImages();

        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");

        FlatsImages flatsImages1 = new FlatsImages();
        flatsImages1.setImgUrl(null);
        flatsImages1.setId(123L);
        flatsImages1.setFlat(flat);
        assertFalse(flatsImages.equals(flatsImages1));
    }

    @Test
    public void testEquals6() {
        FlatsImages flatsImages = new FlatsImages("https://example.org/example", new Flat(123L));
        assertFalse(flatsImages.equals(new FlatsImages()));
    }

    @Test
    public void testEquals7() {
        FlatsImages flatsImages = new FlatsImages();

        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");

        FlatsImages flatsImages1 = new FlatsImages();
        flatsImages1.setImgUrl("https://example.org/example");
        flatsImages1.setId(123L);
        flatsImages1.setFlat(flat);
        assertFalse(flatsImages.equals(flatsImages1));
    }

    @Test
    public void testEquals8() {
        FlatsImages flatsImages = new FlatsImages();
        assertTrue(flatsImages.equals(new FlatsImages()));
    }

    @Test
    public void testEquals9() {
        FlatsImages flatsImages = new FlatsImages("https://example.org/example", new Flat(123L));

        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(0);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");

        FlatsImages flatsImages1 = new FlatsImages();
        flatsImages1.setImgUrl("https://example.org/example");
        flatsImages1.setId(123L);
        flatsImages1.setFlat(flat);
        assertFalse(flatsImages.equals(flatsImages1));
    }

    @Test
    public void testHashCode() {
        assertEquals(6061, (new FlatsImages()).hashCode());
        assertEquals(-2104156954, (new FlatsImages("https://example.org/example", new Flat(123L))).hashCode());
        assertEquals(6061, (new FlatsImages()).hashCode());
        assertEquals(-2104156954, (new FlatsImages("https://example.org/example", new Flat(123L))).hashCode());
    }

    @Test
    public void testHashCode2() {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(1);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");

        FlatsImages flatsImages = new FlatsImages();
        flatsImages.setImgUrl("https://example.org/example");
        flatsImages.setId(123L);
        flatsImages.setFlat(flat);

        ArrayList<FlatsImages> flatsImagesList = new ArrayList<FlatsImages>();
        flatsImagesList.add(flatsImages);

        FlatOrderType flatOrderType1 = new FlatOrderType();
        flatOrderType1.setId(123L);
        flatOrderType1.setName(null);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName(null);

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivationCode(null);
        user1.setUsername("janedoe");
        user1.setSecondName(null);
        user1.setId(123L);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(null);
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setRole(role1);

        Flat flat1 = new Flat();
        flat1.setFlatsImages(flatsImagesList);
        flat1.setPrice(10.0f);
        flat1.setCountry(null);
        flat1.setFloor(0);
        flat1.setId(123L);
        flat1.setOrderType(flatOrderType1);
        flat1.setTown("Oxford");
        flat1.setOwner(user1);
        flat1.setDescription("The characteristics of someone or something");
        flat1.setHouseNom(null);
        flat1.setStreet(null);

        FlatsImages flatsImages1 = new FlatsImages();
        flatsImages1.setFlat(flat1);
        assertEquals(-1949272712, flatsImages1.hashCode());
    }

    @Test
    public void testHashCode3() {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(1);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");

        FlatsImages flatsImages = new FlatsImages();
        flatsImages.setImgUrl("https://example.org/example");
        flatsImages.setId(123L);
        flatsImages.setFlat(flat);

        ArrayList<FlatsImages> flatsImagesList = new ArrayList<FlatsImages>();
        flatsImagesList.add(flatsImages);

        FlatOrderType flatOrderType1 = new FlatOrderType();
        flatOrderType1.setId(123L);
        flatOrderType1.setName(null);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName(null);

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivationCode(null);
        user1.setUsername("janedoe");
        user1.setSecondName(null);
        user1.setId(123L);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(null);
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setRole(role1);

        Flat flat1 = new Flat();
        flat1.setFlatsImages(flatsImagesList);
        flat1.setPrice(10.0f);
        flat1.setCountry(null);
        flat1.setFloor(0);
        flat1.setId(123L);
        flat1.setOrderType(flatOrderType1);
        flat1.setTown("Oxford");
        flat1.setOwner(user1);
        flat1.setDescription("The characteristics of someone or something");
        flat1.setHouseNom(null);
        flat1.setStreet(null);

        FlatsImages flatsImages1 = new FlatsImages();
        flatsImages1.setFlat(flat1);
        assertEquals(-1949272712, flatsImages1.hashCode());
    }

    @Test
    public void testSetFlat() {
        FlatsImages flatsImages = new FlatsImages();
        flatsImages.setFlat(new Flat(123L));
        assertEquals("FlatsImages(imgUrl=null, flat=Flat(country=null, town=null, street=null, houseNom=null, floor=0,"
                + " price=0.0, description=null, orderType=null, owner=null, flatsImages=null))", flatsImages.toString());
    }

    @Test
    public void testSetFlat2() {
        FlatsImages flatsImages = new FlatsImages();
        flatsImages.setFlat(new Flat(123L));
        assertEquals("FlatsImages(imgUrl=null, flat=Flat(country=null, town=null, street=null, houseNom=null, floor=0,"
                + " price=0.0, description=null, orderType=null, owner=null, flatsImages=null))", flatsImages.toString());
    }

    @Test
    public void testSetImgUrl() {
        FlatsImages flatsImages = new FlatsImages();
        flatsImages.setImgUrl("https://example.org/example");
        assertEquals("https://example.org/example", flatsImages.getImgUrl());
    }

    @Test
    public void testSetImgUrl2() {
        FlatsImages flatsImages = new FlatsImages();
        flatsImages.setImgUrl("https://example.org/example");
        assertEquals("https://example.org/example", flatsImages.getImgUrl());
    }

    @Test
    public void testToString() {
        assertEquals("FlatsImages(imgUrl=null, flat=null)", (new FlatsImages()).toString());
        assertEquals("FlatsImages(imgUrl=null, flat=null)", (new FlatsImages()).toString());
    }

    @Test
    public void testToString2() {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(1);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");

        FlatsImages flatsImages = new FlatsImages();
        flatsImages.setImgUrl("https://example.org/example");
        flatsImages.setId(123L);
        flatsImages.setFlat(flat);

        ArrayList<FlatsImages> flatsImagesList = new ArrayList<FlatsImages>();
        flatsImagesList.add(flatsImages);

        FlatOrderType flatOrderType1 = new FlatOrderType();
        flatOrderType1.setId(123L);
        flatOrderType1.setName("Name");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivationCode("Activation Code");
        user1.setUsername("janedoe");
        user1.setSecondName("Second Name");
        user1.setId(123L);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setRole(role1);

        Flat flat1 = new Flat();
        flat1.setFlatsImages(flatsImagesList);
        flat1.setPrice(10.0f);
        flat1.setCountry("Country");
        flat1.setFloor(0);
        flat1.setId(123L);
        flat1.setOrderType(flatOrderType1);
        flat1.setTown("Oxford");
        flat1.setOwner(user1);
        flat1.setDescription("The characteristics of someone or something");
        flat1.setHouseNom("House Nom");
        flat1.setStreet("Street");

        FlatsImages flatsImages1 = new FlatsImages();
        flatsImages1.setFlat(flat1);
        assertEquals(
                "FlatsImages(imgUrl=null, flat=Flat(country=Country, town=Oxford, street=Street, houseNom=House Nom,"
                        + " floor=0, price=10.0, description=The characteristics of someone or something, orderType=FlatOrderType"
                        + "(name=Name), owner=User{id=123, email='jane.doe@example.org'}, flatsImages=[FlatsImages(imgUrl=https"
                        + "://example.org/example, flat=Flat(country=Country, town=Oxford, street=Street, houseNom=House Nom,"
                        + " floor=1, price=10.0, description=The characteristics of someone or something, orderType=FlatOrderType"
                        + "(name=Name), owner=User{id=123, email='jane.doe@example.org'}, flatsImages=[]))]))",
                flatsImages1.toString());
    }

    @Test
    public void testToString3() {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setId(123L);
        flatOrderType.setName("Name");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);

        Flat flat = new Flat();
        flat.setFlatsImages(new ArrayList<FlatsImages>());
        flat.setPrice(10.0f);
        flat.setCountry("Country");
        flat.setFloor(1);
        flat.setId(123L);
        flat.setOrderType(flatOrderType);
        flat.setTown("Oxford");
        flat.setOwner(user);
        flat.setDescription("The characteristics of someone or something");
        flat.setHouseNom("House Nom");
        flat.setStreet("Street");

        FlatsImages flatsImages = new FlatsImages();
        flatsImages.setImgUrl("https://example.org/example");
        flatsImages.setId(123L);
        flatsImages.setFlat(flat);

        ArrayList<FlatsImages> flatsImagesList = new ArrayList<FlatsImages>();
        flatsImagesList.add(flatsImages);

        FlatOrderType flatOrderType1 = new FlatOrderType();
        flatOrderType1.setId(123L);
        flatOrderType1.setName("Name");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivationCode("Activation Code");
        user1.setUsername("janedoe");
        user1.setSecondName("Second Name");
        user1.setId(123L);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setRole(role1);

        Flat flat1 = new Flat();
        flat1.setFlatsImages(flatsImagesList);
        flat1.setPrice(10.0f);
        flat1.setCountry("Country");
        flat1.setFloor(0);
        flat1.setId(123L);
        flat1.setOrderType(flatOrderType1);
        flat1.setTown("Oxford");
        flat1.setOwner(user1);
        flat1.setDescription("The characteristics of someone or something");
        flat1.setHouseNom("House Nom");
        flat1.setStreet("Street");

        FlatsImages flatsImages1 = new FlatsImages();
        flatsImages1.setFlat(flat1);
        assertEquals(
                "FlatsImages(imgUrl=null, flat=Flat(country=Country, town=Oxford, street=Street, houseNom=House Nom,"
                        + " floor=0, price=10.0, description=The characteristics of someone or something, orderType=FlatOrderType"
                        + "(name=Name), owner=User{id=123, email='jane.doe@example.org'}, flatsImages=[FlatsImages(imgUrl=https"
                        + "://example.org/example, flat=Flat(country=Country, town=Oxford, street=Street, houseNom=House Nom,"
                        + " floor=1, price=10.0, description=The characteristics of someone or something, orderType=FlatOrderType"
                        + "(name=Name), owner=User{id=123, email='jane.doe@example.org'}, flatsImages=[]))]))",
                flatsImages1.toString());
    }
}


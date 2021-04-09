package io.flats.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FlatOrderTypeTest {
    @Test
    public void testCanEqual() {
        assertFalse((new FlatOrderType()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        FlatOrderType flatOrderType = new FlatOrderType();

        FlatOrderType flatOrderType1 = new FlatOrderType();
        flatOrderType1.setId(123L);
        flatOrderType1.setName("Name");
        assertTrue(flatOrderType.canEqual(flatOrderType1));
    }

    @Test
    public void testEquals() {
        assertFalse((new FlatOrderType()).equals("42"));
    }

    @Test
    public void testEquals2() {
        FlatOrderType flatOrderType = new FlatOrderType();

        FlatOrderType flatOrderType1 = new FlatOrderType();
        flatOrderType1.setId(123L);
        flatOrderType1.setName("Name");
        assertFalse(flatOrderType.equals(flatOrderType1));
    }

    @Test
    public void testEquals3() {
        FlatOrderType flatOrderType = new FlatOrderType();
        assertTrue(flatOrderType.equals(new FlatOrderType()));
    }

    @Test
    public void testEquals4() {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setName("Name");

        FlatOrderType flatOrderType1 = new FlatOrderType();
        flatOrderType1.setId(123L);
        flatOrderType1.setName("Name");
        assertTrue(flatOrderType.equals(flatOrderType1));
    }

    @Test
    public void testEquals5() {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setName("Name");

        FlatOrderType flatOrderType1 = new FlatOrderType();
        flatOrderType1.setId(123L);
        flatOrderType1.setName(null);
        assertFalse(flatOrderType.equals(flatOrderType1));
    }

    @Test
    public void testHashCode() {
        assertEquals(102, (new FlatOrderType()).hashCode());
    }

    @Test
    public void testHashCode2() {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setName("Name");
        assertEquals(2420454, flatOrderType.hashCode());
    }

    @Test
    public void testSetName() {
        FlatOrderType flatOrderType = new FlatOrderType();
        flatOrderType.setName("Name");
        assertEquals("FlatOrderType(name=Name)", flatOrderType.toString());
    }

    @Test
    public void testToString() {
        assertEquals("FlatOrderType(name=null)", (new FlatOrderType()).toString());
    }
}


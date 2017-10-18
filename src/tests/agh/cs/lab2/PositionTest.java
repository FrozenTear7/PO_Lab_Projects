package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PositionTest {
    @Test
    public void toStringTest () {
        assertEquals("(1, 1)", new Position(1, 1).toString());
    }

    @Test
    public void smallerTest () {
        Position thisPosition = new Position(1, 1);
        assertTrue(thisPosition.smaller(new Position(2, 2)));
    }

    @Test
    public void largerTest () {
        Position thisPosition = new Position(1, 1);
        assertTrue(thisPosition.larger(new Position(0, 0)));
    }

    @Test
    public void addTest () {
        Position thisPosition = new Position(1, 1);
        assertEquals(("(1, 1)"), thisPosition.add(new Position(0, 0)).toString());
    }
}

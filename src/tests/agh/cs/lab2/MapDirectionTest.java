package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapDirectionTest {
    @Test
    public void toStringTest () {
        assertEquals("Północ", MapDirection.North.toString());
    }

    @Test
    public void nextTest () {
        assertEquals("Wschód", MapDirection.North.next().toString());
    }

    @Test
    public void previousTest () {
        assertEquals("Zachód", MapDirection.North.previous().toString());
    }
}

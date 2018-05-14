import org.junit.Test;

import static org.junit.Assert.*;

public class CoinsTest {

    @Test
    public void setValue() {
        Coins testC = new Coins(10, 10, 100);
        testC.setValue(200);
        assertEquals(200, testC.getValue());
    }

    @Test
    public void move() {
        Coins testC = new Coins(10, 10, 100);
        testC.move();
        assertEquals(12.0, testC.getY(), 0);
    }

    @Test
    public void getValue() {
        Coins testC = new Coins(10, 10, 100);
        assertEquals(100, testC.getValue());
    }

    @Test
    public void lifeCycle() {
        Coins testC = new Coins(10, 10, 100);
        testC.lifeCycle();
        assertEquals(12.0, testC.getY(), 0);
    }
}
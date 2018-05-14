import org.junit.Test;

import static org.junit.Assert.*;

public class SnailTest {

    @Test
    public void distanceTo() {
        Snail testS = new Snail();
        Coins testC = new Coins(50, 51, 100);
        assertEquals(49, testS.distanceTo(testC), 0);
    }

    @Test
    public void moveToCoins() {
        Snail testS = new Snail();
        Coins testC = new Coins(75, 75, 100);
        testS.moveToCoins(testC);
        assertEquals(Direction.RIGHT, testS.getDirection());
    }

    @Test
    public void lifeCycle() {
        Snail testS = new Snail();
        Coins.money = 0;
        Coins testC = new Coins(50, 100, 100);
        LinkedList<Coins> listCoins = new LinkedList<>();
        listCoins.add(testC);
        testS.lifeCycle(listCoins);
        assertTrue(listCoins.isEmpty());
    }

    @Test
    public void setDirection() {
        Snail testS = new Snail();
        testS.setDirection(Direction.LEFT);
        assertEquals(Direction.LEFT, testS.getDirection());
    }

    @Test
    public void getDirection() {
        Snail testS = new Snail();
        assertEquals(Direction.RIGHT, testS.getDirection());
    }
}
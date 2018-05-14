import org.junit.Test;

import static org.junit.Assert.*;

public class GuppyTest {

    @Test
    public void grow() {
        Guppy testG = new Guppy();
        testG.grow();
        assertEquals(2, testG.getPhase());
    }

    @Test
    public void makeCoins() {
        Guppy testG = new Guppy();
        LinkedList<Coins> listCoins = new LinkedList<>();
        testG.makeCoins(listCoins);
        assertEquals(1, listCoins.getIdx());
    }

    @Test
    public void distanceTo() {
        Guppy testG = new Guppy();
        testG.setX(50);
        testG.setY(50);
        Food testF = new Food(54, 53);
        assertEquals(5, testG.distanceTo(testF), 0);
    }

    @Test
    public void moveToFood() {
        Guppy testG = new Guppy();
        Food testF = new Food(10, 10);
        testG.moveToFood(testF);
        assertEquals(2, testG.getSpeed(), 0);
    }

    @Test
    public void lifeCycle() {
        Guppy testG = new Guppy();
        LinkedList<Guppy> listGuppy = new LinkedList<>();
        Food testF = new Food(10, 10);
        LinkedList<Food> listFood = new LinkedList<>();
        Coins testC = new Coins(13, 14, 100);
        LinkedList<Coins> listCoins = new LinkedList<>();
        testG.lifeCycle(listFood, listCoins, listGuppy);
        assertEquals(1, testG.getTime());
    }

    @Test
    public void setPhase() {
        Guppy testG = new Guppy();
        testG.setPhase(2);
        assertEquals(2, testG.getPhase());
    }

    @Test
    public void setFoodCounter() {
        Guppy testG = new Guppy();
        testG.setFoodCounter(2);
        assertEquals(2, testG.getFoodCounter());
    }

    @Test
    public void getPhase() {
        Guppy testG = new Guppy();
        assertEquals(1, testG.getPhase());
    }

    @Test
    public void getFoodCounter() {
        Guppy testG = new Guppy();
        assertEquals(0, testG.getFoodCounter());
    }

    @Test
    public void getMaxPhase() {
        Guppy testG = new Guppy();
        assertEquals(3, testG.getMaxPhase());
    }

    @Test
    public void getTimeC() {
        Guppy testG = new Guppy();
        assertEquals(50, testG.getTimeC());
    }
}
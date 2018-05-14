import org.junit.Test;

import static org.junit.Assert.*;

public class PiranhaTest {

    @Test
    public void makeCoins() {
        Piranha testP = new Piranha();
        Guppy testG = new Guppy();
        testP.setX(testG.getX());
        testP.setY(testG.getY());
        LinkedList<Coins> listCoins = new LinkedList<>();
        testP.makeCoins(listCoins, testG);
        assertEquals(1, listCoins.getIdx());
    }

    @Test
    public void distanceTo() {
        Piranha testP = new Piranha();
        Guppy testG = new Guppy();
        testP.setX(testG.getX());
        testP.setY(testG.getY());
        assertEquals(0, testP.distanceTo(testG), 0);
    }

    @Test
    public void moveToFood() {
        Piranha testP = new Piranha();
        Guppy testG = new Guppy();
        testP.moveToFood(testG);
        assertEquals(3, testG.getSpeed(), 0);
    }

    @Test
    public void lifeCycle() {
        Piranha testP = new Piranha();
        LinkedList<Piranha> listPiranha = new LinkedList<>();
        listPiranha.add(testP);
        Guppy testG = new Guppy();
        LinkedList<Guppy> listGuppy = new LinkedList<>();
        listGuppy.add(testG);
        Coins testC = new Coins(13, 14, 100);
        LinkedList<Coins> listCoins = new LinkedList<>();
        listCoins.add(testC);
        testP.lifeCycle(listGuppy, listCoins, listPiranha);
        assertEquals(1, testP.getTime());
    }
}

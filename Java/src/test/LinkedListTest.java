import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void find() {
        Guppy testG = new Guppy();
        LinkedList<Guppy> testLL = new LinkedList<>();
        testLL.add(testG);
        assertEquals(0, testLL.find(testG));
    }

    @Test
    public void isEmpty() {
        Piranha testP = new Piranha();
        LinkedList<Piranha> testLL = new LinkedList<>();
        testLL.add(testP);
        assertFalse(testLL.isEmpty());
    }

    @Test
    public void add() {
        Piranha testP = new Piranha();
        Piranha testP1 = new Piranha();
        LinkedList<Piranha> testLL = new LinkedList<>();
        testLL.add(testP);
        testLL.add(testP1);
        assertEquals(2, testLL.getIdx());
    }

    @Test
    public void remove() {
        Coins testC = new Coins(10, 10, 100);
        Coins testC1 = new Coins(20, 20, 200);
        LinkedList<Coins> testLL = new LinkedList<>();
        testLL.add(testC);
        testLL.add(testC1);
        testLL.remove(testC);
        assertEquals(1, testLL.getIdx());
    }

    @Test
    public void get() {
        Food testF = new Food(10, 10);
        Food testF1 = new Food(20, 20);
        LinkedList<Food> testLL = new LinkedList<>();
        testLL.add(testF);
        testLL.add(testF1);
        assertEquals(testF1, testLL.get(1));
    }

    @Test
    public void getIdx() {
        Guppy testG = new Guppy();
        Guppy testG1 = new Guppy();
        Guppy testG2 = new Guppy();
        LinkedList<Guppy> testLL = new LinkedList<>();
        testLL.add(testG);
        testLL.add(testG1);
        testLL.add(testG2);
        assertEquals(3, testLL.getIdx());
    }
}
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodTest {

    @Test
    public void move() {
        Food testF = new Food(10, 10);
        testF.move();
        assertEquals(11, testF.getY(), 0);
    }

    @Test
    public void lifeCycle() {
        Food testF = new Food(95, 10);
        LinkedList<Food> listFood = new LinkedList<>();
        testF.lifeCycle(listFood);
        assertTrue(listFood.isEmpty());
    }
}
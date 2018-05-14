import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {

    @Test
    public void setElmt() {
        Food testF = new Food(10, 10);
        List<Food> testL = new List<>();
        testL.setElmt(testF);
        assertEquals(testF, testL.getElmt());
    }

    @Test
    public void setNext() {
        Food testF = new Food(10, 10);
        Food testF1 = new Food(20, 20);
        List<Food> testL = new List<>(testF);
        List<Food> testL1 = new List<>(testF1);
        testL.setNext(testL1);
        assertEquals(testL1, testL.getNext());
    }

    @Test
    public void getElmt() {
        Food testF = new Food(10, 10);
        List<Food> testL = new List<>(testF);
        assertEquals(testF, testL.getElmt());
    }

    @Test
    public void getNext() {
        Food testF = new Food(10, 10);
        Food testF1 = new Food(20, 20);
        List<Food> testL = new List<>(testF);
        List<Food> testL1 = new List<>(testF1);
        testL.setNext(testL1);
        assertEquals(testL1, testL.getNext());
    }
}
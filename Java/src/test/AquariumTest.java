import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumTest {

    @Test
    public static void getSize() {
        Aquarium testA = new Aquarium();
        assertEquals(100, testA.getSize());
    }

    @Test
    public static void getPercentSize() {
        Aquarium testA = new Aquarium();
        assertEquals(5, testA.getPercentSize(5), 0);
    }

    @Test
    public static void getBorder() {
        Aquarium testA = new Aquarium();
        assertEquals(95, testA.getBorder(5), 0);
    }
}

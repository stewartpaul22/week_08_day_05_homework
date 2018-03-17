import models.Food;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFood {

    private Food food1;

    @Before
    public void setUp() throws Exception {
        food1 = new Food("Banana", 100.00);
    }

    @Test
    public void canGetName() {
        assertEquals("Banana", food1.getName());
    }

    @Test
    public void canGetCalories() {
        assertEquals(100, food1.getCalories(), 0.01);
    }

    // Add tests for setters???


}

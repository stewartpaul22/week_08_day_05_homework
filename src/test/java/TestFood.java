import enums.MealType;
import models.Day;
import models.Food;
import models.Meal;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class TestFood {

    private Day day1;
    private Food food1;
    private Meal meal1;

    @Before
    public void setUp() throws Exception {
        day1 = new Day(new GregorianCalendar(2018, 3, 16));
        meal1 = new Meal("Banana", MealType.SNACK, day1);
        food1 = new Food("Banana", 100.00, meal1);
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

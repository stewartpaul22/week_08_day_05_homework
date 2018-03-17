import enums.MealType;
import models.Day;
import models.Food;
import models.Meal;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class TestDay {

    private Day day1;
    private Meal meal1;
    private Food food1;
    private Food food2;

    @Before
    public void setUp() throws Exception {
        day1 = new Day(new GregorianCalendar(2018, 3, 16));
        meal1 = new Meal("Soup and roll", MealType.MAINMEAL);
        food1 = new Food("Lentil soup", 190);
        food2 = new Food("Roll", 90);
    }

    @Test
    public void canGetDate() {
        assertEquals(new GregorianCalendar(2018, 3, 16), day1.getDayDate());
    }

    @Test
    public void canAddMealToDay() {
        meal1.addFood(food1);
        meal1.addFood(food2);
        day1.addMeal(meal1);
        assertEquals(1, day1.getMealCount());
    }


}

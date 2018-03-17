import enums.MealType;
import models.Food;
import models.Meal;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMeal {

    private Meal meal1;
    private Food food1;
    private Food food2;

    @Before
    public void setUp() throws Exception {
        meal1 = new Meal("Soup and roll", MealType.MAINMEAL);
        food1 = new Food("Lentil soup", 190);
        food2 = new Food("Roll", 90);
    }

    @Test
    public void canGetDescription() {
        assertEquals("Soup and roll", meal1.getDescription());
    }

    @Test
    public void canGetMealType() {
        assertEquals(MealType.MAINMEAL, meal1.getMealType());
    }

    @Test
    public void canAddFoodToMeal() {
        meal1.addFood(food1);
        meal1.addFood(food2);
        assertEquals(2, meal1.getFoodCount());
    }

    @Test
    public void canGetMealCalorieTotal() {
        meal1.addFood(food1);
        meal1.addFood(food2);
        assertEquals(280.00, meal1.getCalorieTotal(), 0.01);
    }
}

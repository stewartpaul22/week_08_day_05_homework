import enums.MealType;
import models.Day;
import models.Food;
import models.Meal;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestDay {

    private Day day1;
    private Meal meal1;
    private Food food1;
    private Food food2;

    @Before
    public void setUp() throws Exception {
        day1 = new Day(new GregorianCalendar(2018, 3, 16));
        meal1 = new Meal("Soup and roll", MealType.MAINMEAL, day1);
        food1 = new Food("Lentil soup", 190.00, meal1);
        food2 = new Food("Roll", 90.00, meal1);
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
        assertEquals(1, day1.mealCount());
    }

    @Test
    public void canCalculateDailyCalories() {
        meal1.addFood(food1);
        meal1.addFood(food2);
        day1.addMeal(meal1);
        assertEquals(280.00, day1.calorieTotal(), 0.01);
    }

    //    @Test
//    public void canGetMealsForGivenDate() {
//        GregorianCalendar testDate = new GregorianCalendar(2018, 3, 10);
//
//        meal1.addFood(food1);
//        meal1.addFood(food2);
//        day1.addMeal(meal1);
//
//        List<Meal> meals = new ArrayList<Meal>();
//        meals.add(meal1);
//
//        assertEquals(meals, day1.getMeals());
//        List<Meal> testMeals = Day.mealsForDate(testDate);
//    }

}

import db.DBHelper;
import enums.MealType;
import models.Day;
import models.Food;
import models.Meal;

import java.util.GregorianCalendar;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Day day1 = new Day(new GregorianCalendar(2018, 3, 10));
        DBHelper.saveOrUpdate(day1);
        Day day2 = new Day(new GregorianCalendar(2018, 3, 18));
        DBHelper.saveOrUpdate(day2);

        Meal meal1 = new Meal("Lentil soup and roll", MealType.MAINMEAL, day1);
        DBHelper.saveOrUpdate(meal1);
        Meal meal2 = new Meal("Banana", MealType.SNACK, day1);
        DBHelper.saveOrUpdate(meal2);

        Food food1 = new Food("Lentil Soup", 190, meal1);
        Food food2 = new Food("White bread roll", 90, meal1);
        Food food3 = new Food("Banana", 80, meal2);
        DBHelper.save(food1);
        DBHelper.save(food2);
        DBHelper.save(food3);

//        DBHelper.addFoodToMeal(food1, meal1);
//        DBHelper.addFoodToMeal(food2, meal1);

        List<Food> allFoodItems = DBHelper.getAll(Food.class);
        List<Meal> allMeals = DBHelper.getAll(Meal.class);
        List<Day> allDays = DBHelper.getAll(Day.class);



    }

}

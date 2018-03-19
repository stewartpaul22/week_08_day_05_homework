import db.DBHelper;
import enums.MealType;
import models.Day;
import models.Food;
import models.Meal;

import java.util.GregorianCalendar;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        // Save Day
        Day day1 = new Day(new GregorianCalendar(2018, 3, 10));
        DBHelper.saveOrUpdate(day1);
        Day day2 = new Day(new GregorianCalendar(2018, 3, 18));
        DBHelper.saveOrUpdate(day2);

        // Save Meal
        Meal meal1 = new Meal("Lentil soup and roll", MealType.MAINMEAL, day1);
        DBHelper.saveOrUpdate(meal1);
        Meal meal2 = new Meal("Banana", MealType.SNACK, day1);
        DBHelper.saveOrUpdate(meal2);
        Meal meal3 = new Meal("Fish and chips with mushy peas", MealType.MAINMEAL, day2);
        DBHelper.saveOrUpdate(meal3);

        // Save Food
        Food food1 = new Food("Lentil Soup", 190, meal1);
        Food food2 = new Food("White bread roll", 90, meal1);
        Food food3 = new Food("Banana", 80, meal2);
        Food food4 = new Food("Battered Cod", 280, meal3);
        Food food5 = new Food("Chips", 200, meal3);
        Food food6 = new Food("Mushy peas", 80, meal3);
        DBHelper.save(food1);
        DBHelper.save(food2);
        DBHelper.save(food3);
        DBHelper.save(food4);
        DBHelper.save(food5);
        DBHelper.save(food6);

        // Delete Day
        //DBHelper.delete(day1);

        // Delete Meal

        // Delete Food
        DBHelper.delete(food3);

        // Update Day

        // Update Meal

        // Update Food
        food2.setName("Brown bread roll");
        DBHelper.saveOrUpdate(food2);

        // List all from each table
        List<Food> allFoodItems = DBHelper.getAll(Food.class);
        List<Meal> allMeals = DBHelper.getAll(Meal.class);
        List<Day> allDays = DBHelper.getAll(Day.class);

        // Return all Meal for a given Date
        List<Meal> dateMeals = DBHelper.getAllMealsForDate(new GregorianCalendar(2018, 3, 18));

        // Return all Food for a given Meal
        // Does this make sense to do?

        // Return calorie count for a given date
        Double dateCalories = DBHelper.dateCalorieTotal(new GregorianCalendar(2018, 3, 18));

        // Return average calorie count for a given month

    }

}

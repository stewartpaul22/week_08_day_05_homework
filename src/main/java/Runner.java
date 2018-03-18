import db.DBHelper;
import enums.MealType;
import models.Food;
import models.Meal;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Meal meal1 = new Meal("Lentil soup and roll", MealType.MAINMEAL);
        DBHelper.save(meal1);

        Food food1 = new Food("Lentil Soup", 190);
        Food food2 = new Food("White bread roll", 90);
        DBHelper.save(food1);
        DBHelper.save(food2);

        List<Meal> allMeals = DBHelper.getAll(Meal.class);

        List<Food> allFoodItems = DBHelper.getAll(Food.class);

    }

}

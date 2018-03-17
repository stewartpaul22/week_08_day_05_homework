package models;

import enums.MealType;

import java.util.ArrayList;

public class Meal {

    private int id;
    private String description;
    private ArrayList<Food> foods;
    private MealType mealType;

    public Meal() {
    }

    public Meal(String description, MealType mealType) {
        this.description = description;
        this.mealType = mealType;
        this.foods = new ArrayList<Food>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public int getFoodCount() {
        return this.foods.size();
    }

    public void addFood(Food food) {
        this.foods.add(food);
    }

    public double getCalorieTotal() {
        double total = 0;
        for (Food food : this.foods) {
            total += food.getCalories();
        }
        return total;
    }
}

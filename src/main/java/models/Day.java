package models;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Day {

    private int id;
    private GregorianCalendar dayDate;
    private ArrayList<Meal> meals;

    public Day() {
    }

    public Day(GregorianCalendar dayDate) {
        this.dayDate = dayDate;
        this.meals = new ArrayList<Meal>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GregorianCalendar getDayDate() {
        return dayDate;
    }

    public void setDayDate(GregorianCalendar dayDate) {
        this.dayDate = dayDate;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    public int getMealCount() {
        return this.meals.size();
    }

    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }
}

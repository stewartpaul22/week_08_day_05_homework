package models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "days")
public class Day {

    private int id;
    private GregorianCalendar dayDate;
    private List<Meal> meals;

    public Day() {
    }

    public Day(GregorianCalendar dayDate) {
        this.dayDate = dayDate;
        this.meals = new ArrayList<Meal>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "date")
    public GregorianCalendar getDayDate() {
        return dayDate;
    }

    public void setDayDate(GregorianCalendar dayDate) {
        this.dayDate = dayDate;
    }

    @OneToMany(mappedBy = "day", fetch = FetchType.EAGER)
    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public int mealCount() {
        return this.meals.size();
    }

    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }

    public double calorieTotal() {
        double dayCalories = 0.00;
        for (Meal meal : this.meals) {
            dayCalories += meal.calculateCalorieTotal();
        }
        return dayCalories;
    }


//    public static List<Meal> mealsForDate(GregorianCalendar date) {
//        List<Meal> tempMeals = null;
//
//        for (Meal meal : meals) {
//            if (meal.getDay().getDayDate() == date) {
//                tempMeals.add(meal);
//            }
//            return tempMeals;
//        }
//
//        return null;
//    }
}

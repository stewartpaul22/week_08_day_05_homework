package models;

import enums.MealType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "meals")
public class Meal {

    private int id;
    private String description;
    private List<Food> foods;
    private MealType mealType;

    public Meal() {
    }

    public Meal(String description, MealType mealType) {
        this.description = description;
        this.mealType = mealType;
        this.foods = new ArrayList<Food>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "meal", fetch = FetchType.EAGER)
    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    @Column(name = "meal_type")
    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public int foodCount() {
        return this.foods.size();
    }

    public void addFood(Food food) {
        this.foods.add(food);
    }

    public double calculateCalorieTotal() {
        double total = 0;
        for (Food food : this.foods) {
            total += food.getCalories();
        }
        return total;
    }
}

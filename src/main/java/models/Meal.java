package models;

import enums.MealType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    private Day day;

    public Meal() {
    }

    public Meal(String description, MealType mealType, Day day) {
        this.description = description;
        this.mealType = mealType;
        this.foods = new ArrayList<Food>();
        this.day = day;
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

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "meal", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
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

    @ManyToOne
    @JoinColumn(name = "day_id")
    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
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

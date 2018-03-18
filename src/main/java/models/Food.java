package models;

import javax.persistence.*;

@Entity
@Table(name = "foods")
public class Food {

    private int id;
    private String name;
    private double calories;
    private Meal meal;

    public Food() {
    }

    public Food(String name, double calories, Meal meal) {
        this.name = name;
        this.calories = calories;
        this.meal = meal;
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    @Column(name = "calories")
    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}

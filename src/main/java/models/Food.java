package models;

public class Food {

    private int id;
    private String name;
    private double calories;

    public Food() {
    }

    public Food(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}

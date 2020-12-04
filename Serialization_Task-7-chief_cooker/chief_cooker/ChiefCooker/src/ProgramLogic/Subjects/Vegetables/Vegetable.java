package ProgramLogic.Subjects.Vegetables;

import java.io.Serializable;

public abstract class Vegetable implements Serializable {

    String name;
    double weight;
    int calorie;

    transient boolean isExist;

    {
        isExist = true;
    }

    public Vegetable() {
    }

    public Vegetable(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Vegetable(String name, double weight, int calorie) {
        this.name = name;
        this.weight = weight;
        this.calorie = calorie;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public boolean isExist() {
        return isExist;
    }


}

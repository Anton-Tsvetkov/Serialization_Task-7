package ProgramLogic.Subjects;

import ProgramLogic.Subjects.Vegetables.Vegetable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Salad implements Serializable {

    List<Vegetable> vegetables;
    double calorie;

    transient boolean isExist;


    {
        this.vegetables = new ArrayList<>();
        isExist = true;
    }

    public Salad() {

    }

    public Salad(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }


    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public double getCalorie() {
        return calorie;
    }


    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public void setVegetable(List<Vegetable> vegetables) {
        this.vegetables.addAll(vegetables);
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetables.add(vegetable);
    }

    public boolean isExist() {
        return isExist;
    }


    @Override
    public String toString() {
        return "Salad{" +
                "vegetables=" + vegetables +
                ", calorie=" + calorie +
                '}';
    }
}

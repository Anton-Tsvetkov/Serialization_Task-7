package ProgramLogic.Subjects;

import ProgramLogic.Subjects.Confection.Confection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SweetsBox implements Serializable {

    List<Confection> confections;
    double weight;

    transient boolean isExist;

    {
        this.confections = new ArrayList<>();
        isExist = true;
    }

    public SweetsBox() {

    }

    public SweetsBox(List<Confection> confections) {
        this.confections = confections;
    }


    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }


    public List<Confection> getSweets() {
        return confections;
    }

    public void setSweets(List<Confection> confections) {
        this.confections.addAll(confections);
    }

    public void setSweet(Confection confection) {
        this.confections.add(confection);
    }

    public boolean isExist() {
        return isExist;
    }

    @Override
    public String toString() {
        return "SweetsBox{" +
                "confections=" + confections +
                ", weight=" + weight +
                '}';
    }
}

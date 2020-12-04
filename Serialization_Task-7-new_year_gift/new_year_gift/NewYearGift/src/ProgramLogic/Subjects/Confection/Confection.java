package ProgramLogic.Subjects.Confection;

import java.io.Serializable;

public abstract class Confection implements Serializable {

    String name;
    String filling;
    int sugarLvl;
    double weight;

    transient boolean isExist;

    {
        isExist = true;
    }

    public Confection() { }

    public Confection(String name, String filling) {
        this.name = name;
        this.filling = filling;
    }

    public Confection(String name, String filling, int sugarLvl) {
        this.name = name;
        this.filling = filling;
        this.sugarLvl = sugarLvl;
    }

    public Confection(String name, String filling, int sugarLvl, double weight) {
        this.name = name;
        this.filling = filling;
        this.sugarLvl = sugarLvl;
        this.weight = weight;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSugarLvl() {
        return sugarLvl;
    }

    public void setSugarLvl(int sugarLvl) {
        this.sugarLvl = sugarLvl;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }

    public boolean isExist() {
        return isExist;
    }
}

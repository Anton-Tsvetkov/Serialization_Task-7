package ProgramLogic.Subjects.HomeElectrical;

import java.io.Serializable;

public abstract class HomeElectrical implements Serializable {

    String name;
    double consumption;
    boolean power;

    transient boolean isExist;

    {
        isExist = true;
    }

    public HomeElectrical(String name) {
        this.name = name;
        this.power = false;
    }

    public HomeElectrical(String name, double consumption, boolean power) {
        this.name = name;
        this.consumption = consumption;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public boolean isExist() {
        return isExist;
    }

    @Override
    public String toString() {
        return "ElectricalAppliance{" +
                "name='" + name + '\'' +
                ", consumption=" + consumption +
                ", power=" + power +
                '}';
    }
}

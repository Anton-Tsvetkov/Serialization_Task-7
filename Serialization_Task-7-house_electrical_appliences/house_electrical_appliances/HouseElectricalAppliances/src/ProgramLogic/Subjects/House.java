package ProgramLogic.Subjects;

import ProgramLogic.Subjects.HomeElectrical.HomeElectrical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class House implements Serializable {

    List<HomeElectrical> electricalAppliances;
    double consumption;

    transient boolean isExist;

    {
        this.electricalAppliances = new ArrayList<>();
        isExist = true;
    }

    public House() {

    }

    public House(List<HomeElectrical> electricalAppliances) {
        this.electricalAppliances = electricalAppliances;
    }


    public List<HomeElectrical> getElectricalAppliances() {
        return electricalAppliances;
    }

    public void setElectricalAppliances(List<HomeElectrical> electricalAppliances) {
        this.electricalAppliances.addAll(electricalAppliances);
    }
    public void setElectricalAppliances(HomeElectrical electricalAppliances) {
        this.electricalAppliances.add(electricalAppliances);
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public boolean isExist() {
        return isExist;
    }

    @Override
    public String toString() {
        return "House{" +
                "electricalAppliances=" + electricalAppliances +
                ", consumption=" + consumption +
                '}';
    }
}

package ProgramLogic.Subjects.Confection;

import java.math.BigDecimal;

public class Wafer extends Confection {

    public Wafer() {
    }

    public Wafer(String name, String filling) {
        super(name, filling);
    }

    public Wafer(String name, String filling, int sugarLvl) {
        super(name, filling, sugarLvl);
    }

    public Wafer(String name, String filling, int sugarLvl, double weight) {
        super(name, filling, sugarLvl, weight);
    }

    @Override
    public String toString() {
        return "Wafer{" +
                "name='" + name + '\'' +
                ", filling='" + filling + '\'' +
                ", sugarLvl=" + sugarLvl +
                ", weight=" + weight +
                '}';
    }
}

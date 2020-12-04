package ProgramLogic.Subjects.Confection;


import java.math.BigDecimal;

public class Chocolate extends Confection {

    public Chocolate() {
    }

    public Chocolate(String name, String filling) {
        super(name, filling);
    }

    public Chocolate(String name, String filling, int sugarLvl) {
        super(name, filling, sugarLvl);
    }

    public Chocolate(String name, String filling, int sugarLvl, double weight) {
        super(name, filling, sugarLvl, weight);
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "name='" + name + '\'' +
                ", filling='" + filling + '\'' +
                ", sugarLvl=" + sugarLvl +
                ", weight=" + weight +
                '}';
    }
}

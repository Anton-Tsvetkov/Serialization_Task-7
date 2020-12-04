package ProgramLogic.Subjects.Confection;


import java.math.BigDecimal;

public class Lollipop extends Confection {

    public Lollipop() {
    }

    public Lollipop(String name, String filling) {
        super(name, filling);
    }

    public Lollipop(String name, String filling, int sugarLvl) {
        super(name, filling, sugarLvl);
    }

    public Lollipop(String name, String filling, int sugarLvl, double weight) {
        super(name, filling, sugarLvl, weight);
    }

    @Override
    public String toString() {
        return "Lollipop{" +
                "name='" + name + '\'' +
                ", filling='" + filling + '\'' +
                ", sugarLvl=" + sugarLvl +
                ", weight=" + weight +
                '}';
    }
}

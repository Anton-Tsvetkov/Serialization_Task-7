package ProgramLogic.Subjects.Confection;

public class Candy extends Confection{
    public Candy() {
    }

    public Candy(String name, String filling) {
        super(name, filling);
    }

    public Candy(String name, String filling, int sugarLvl) {
        super(name, filling, sugarLvl);
    }

    public Candy(String name, String filling, int sugarLvl, double weight) {
        super(name, filling, sugarLvl, weight);
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", filling='" + filling + '\'' +
                ", sugarLvl=" + sugarLvl +
                ", weight=" + weight +
                '}';
    }
}

package ProgramLogic.Subjects.HomeElectrical;

public class Appliances extends HomeElectrical {
    public Appliances(String name) {
        super(name);
    }

    public Appliances(String name, double consumption, boolean power) {
        super(name, consumption, power);
    }

    @Override
    public String toString() {
        return "Appliances{" +
                "name='" + name + '\'' +
                ", consumption=" + consumption +
                ", power=" + power +
                '}';
    }
}

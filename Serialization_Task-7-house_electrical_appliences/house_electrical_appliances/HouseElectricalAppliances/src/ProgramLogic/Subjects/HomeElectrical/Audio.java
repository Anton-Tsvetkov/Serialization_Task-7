package ProgramLogic.Subjects.HomeElectrical;

public class Audio extends HomeElectrical {
    public Audio(String name) {
        super(name);
    }

    public Audio(String name, double consumption, boolean power) {
        super(name, consumption, power);
    }

    @Override
    public String toString() {
        return "Audio{" +
                "name='" + name + '\'' +
                ", consumption=" + consumption +
                ", power=" + power +
                '}';
    }
}

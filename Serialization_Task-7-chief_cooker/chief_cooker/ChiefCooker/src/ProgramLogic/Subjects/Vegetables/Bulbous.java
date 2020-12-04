package ProgramLogic.Subjects.Vegetables;

public class Bulbous extends Vegetable {  // луковичные


    public Bulbous() {
    }

    public Bulbous(String name, double weight) {
        super(name, weight);
    }

    public Bulbous(String name, double weight, int calorie) {
        super(name, weight, calorie);
    }

    @Override
    public String toString() {
        return "Bulbous{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", calorie=" + calorie +
                '}';
    }
}
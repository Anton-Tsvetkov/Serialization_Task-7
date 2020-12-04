package ProgramLogic.Subjects.Vegetables;

public class Leafy extends Vegetable {  // листовые


    public Leafy() {
    }

    public Leafy(String name, double weight) {
        super(name, weight);
    }

    public Leafy(String name, double weight, int calorie) {
        super(name, weight, calorie);
    }

    @Override
    public String toString() {
        return "Leafy{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", calorie=" + calorie +
                '}';
    }
}

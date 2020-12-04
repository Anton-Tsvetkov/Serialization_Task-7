package ProgramLogic.Subjects.Vegetables;

public class Flowering extends Vegetable{    // цветковые


    public Flowering() {
    }

    public Flowering(String name, double weight) {
        super(name, weight);
    }

    public Flowering(String name, double weight, int calorie) {
        super(name, weight, calorie);
    }

    @Override
    public String toString() {
        return "Flowering{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", calorie=" + calorie +
                '}';
    }
}

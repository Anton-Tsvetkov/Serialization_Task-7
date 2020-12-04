package ProgramLogic.Subjects.Vegetables;


public class Roots extends Vegetable {   // корнеплоды

    public Roots() {
    }

    public Roots(String name, double weight) {
        super(name, weight);
    }

    public Roots(String name, double weight, int calorie) {
        super(name, weight, calorie);
    }

    @Override
    public String toString() {
        return "Roots{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", calorie=" + calorie +
                '}';
    }
}

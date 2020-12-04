package ProgramLogic.Subjects.Vegetables;


public class Fruit extends Vegetable {  // плодовые


    public Fruit() {
    }

    public Fruit(String name, double weight) {
        super(name, weight);
    }

    public Fruit(String name, double weight, int calorie) {
        super(name, weight, calorie);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", calorie=" + calorie +
                '}';
    }
}

package ProgramLogic.Subjects.Accessorys;

import java.math.BigDecimal;

public class Pot extends Accessory{

    public Pot(){}

    public Pot(String name, String color, BigDecimal price) {
        super(name, color, price);
    }

    @Override
    public String toString() {
        return "Pot{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}

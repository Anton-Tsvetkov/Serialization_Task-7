package ProgramLogic.Subjects.Accessorys;

import java.math.BigDecimal;

public class Basket extends Accessory{

    public Basket(){}

    public Basket(String name, String color, BigDecimal price) {
        super(name, color, price);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}

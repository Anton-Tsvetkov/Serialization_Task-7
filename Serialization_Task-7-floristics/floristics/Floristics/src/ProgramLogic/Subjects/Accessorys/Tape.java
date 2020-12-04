package ProgramLogic.Subjects.Accessorys;


import java.math.BigDecimal;

public class Tape extends Accessory{

    public Tape(){}

    public Tape(String name, String color, BigDecimal price) {
        super(name, color, price);
    }

    @Override
    public String toString() {
        return "Tape{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}

package ProgramLogic.Subjects.Accessorys;


import java.math.BigDecimal;

public class WrappingPaper extends Accessory{

    public WrappingPaper(){}

    public WrappingPaper(String name, String color, BigDecimal price) {
        super(name, color, price);
    }

    @Override
    public String toString() {
        return "WrappingPaper{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}

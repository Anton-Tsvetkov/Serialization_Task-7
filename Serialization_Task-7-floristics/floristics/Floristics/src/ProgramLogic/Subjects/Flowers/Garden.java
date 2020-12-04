package ProgramLogic.Subjects.Flowers;


import java.math.BigDecimal;

public class Garden extends Flower {

    public Garden(){}

    public Garden(String name, String color, BigDecimal price) {
        super(name, color, price);
    }

    public Garden(String name, String color, BigDecimal price, int freshnessStateLvl) {
        super(name, color, price, freshnessStateLvl);
    }

    public Garden(String name, String color, BigDecimal price, int freshnessStateLvl, double stemLength) {
        super(name, color, price, freshnessStateLvl, stemLength);
    }

    @Override
    public String toString() {
        return "Garden{" +
                "name='" + name + '\'' +
                ", freshnessState='" + freshnessStateLvl + '\'' +
                ", price=" + price +
                ", stemLength=" + stemLength +
                '}';
    }
}

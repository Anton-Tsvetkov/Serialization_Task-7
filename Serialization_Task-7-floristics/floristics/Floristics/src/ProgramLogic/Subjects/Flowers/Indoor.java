package ProgramLogic.Subjects.Flowers;


import java.math.BigDecimal;

public class Indoor extends Flower {

    public Indoor(){}

    public Indoor(String name, String color, BigDecimal price) {
        super(name, color, price);
    }

    public Indoor(String name, String color, BigDecimal price, int freshnessStateLvl) {
        super(name, color, price, freshnessStateLvl);
    }

    public Indoor(String name, String color, BigDecimal price, int freshnessStateLvl, double stemLength) {
        super(name, color, price, freshnessStateLvl, stemLength);
    }

    @Override
    public String toString() {
        return "Indoor{" +
                "name='" + name + '\'' +
                ", freshnessState='" + freshnessStateLvl + '\'' +
                ", price=" + price +
                ", stemLength=" + stemLength +
                '}';
    }
}

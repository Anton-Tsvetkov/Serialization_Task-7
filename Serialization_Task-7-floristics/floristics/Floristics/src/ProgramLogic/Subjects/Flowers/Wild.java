package ProgramLogic.Subjects.Flowers;

import java.math.BigDecimal;

public class Wild extends Flower {

    public Wild(){}

    public Wild(String name, String color, BigDecimal price) {
        super(name, color, price);
    }

    public Wild(String name, String color, BigDecimal price, int freshnessStateLvl) {
        super(name, color, price, freshnessStateLvl);
    }

    public Wild(String name, String color, BigDecimal price, int freshnessStateLvl, double stemLength) {
        super(name, color, price, freshnessStateLvl, stemLength);
    }

    @Override
    public String toString() {
        return "Wild{" +
                "name='" + name + '\'' +
                ", freshnessState='" + freshnessStateLvl + '\'' +
                ", price=" + price +
                ", stemLength=" + stemLength +
                '}';
    }
}

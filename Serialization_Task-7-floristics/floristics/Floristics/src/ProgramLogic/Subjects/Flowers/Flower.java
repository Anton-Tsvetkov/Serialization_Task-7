package ProgramLogic.Subjects.Flowers;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Flower implements Serializable {

    String name;
    String color;
    BigDecimal price;
    int freshnessStateLvl;
    double stemLength;

    transient boolean isExist;

    {
        isExist = true;
    }

    public Flower() { }

    public Flower(String name, String color, BigDecimal price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public Flower(String name, String color, BigDecimal price, int freshnessStateLvl) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.freshnessStateLvl = freshnessStateLvl;
    }

    public Flower(String name, String color, BigDecimal price, int freshnessStateLvl, double stemLength) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.freshnessStateLvl = freshnessStateLvl;
        this.stemLength = stemLength;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFreshnessStateLvl() {
        return freshnessStateLvl;
    }

    public void setFreshnessStateLvl(int freshnessStateLvl) {
        this.freshnessStateLvl = freshnessStateLvl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getStemLength() {
        return stemLength;
    }

    public void setStemLength(double stemLength) {
        this.stemLength = stemLength;
    }

    public boolean isExist() {
        return isExist;
    }
}

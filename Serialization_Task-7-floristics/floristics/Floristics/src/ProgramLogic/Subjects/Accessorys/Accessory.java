package ProgramLogic.Subjects.Accessorys;

import java.io.Serializable;
import java.math.BigDecimal;

abstract public class Accessory implements Serializable {

    String name;
    String color;
    BigDecimal price;

    transient boolean isExist;

    {
        isExist = true;
    }

    public Accessory(){}

    public Accessory(String name, String color, BigDecimal price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isExist() {
        return isExist;
    }
}

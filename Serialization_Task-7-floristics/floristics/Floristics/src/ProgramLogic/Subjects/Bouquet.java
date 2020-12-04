package ProgramLogic.Subjects;

import ProgramLogic.Subjects.Accessorys.*;
import ProgramLogic.Subjects.Flowers.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bouquet implements Serializable {

    List<Flower> flowers;
    List<Accessory> accessories;
    BigDecimal cost;

    transient boolean isExist;

    {
        this.accessories = new ArrayList<>();
        this.flowers = new ArrayList<>();
        isExist = true;
    }

    public Bouquet() {

    }

    public Bouquet(List<Flower> flowers, List<Accessory> accessories) {
        this.flowers = flowers;
        this.accessories = accessories;
    }

    public Bouquet(List<Flower> flowers) {
        this.flowers = flowers;
    }


    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }


    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers.addAll(flowers);
    }

    public void setFlower(Flower flower) {
        this.flowers.add(flower);
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories.addAll(accessories);
    }

    public void setAccessory(Accessory accessory) {
        this.accessories.add(accessory);
    }

    public boolean isExist() {
        return isExist;
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "flowers=" + flowers +
                ", accessories=" + accessories +
                ", cost=" + cost +
                '}';
    }
}

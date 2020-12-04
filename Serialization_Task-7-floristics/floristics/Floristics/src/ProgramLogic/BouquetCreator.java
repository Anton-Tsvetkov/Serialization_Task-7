package ProgramLogic;

import ProgramLogic.Subjects.Bouquet;
import ProgramLogic.Subjects.Flowers.*;
import ProgramLogic.Subjects.Accessorys.*;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class BouquetCreator {

    Florist florist;
    Designer designer;
    Logician logician;

    public BouquetCreator() {
        this.florist = new Florist();
        this.designer = new Designer();
        this.logician = new Logician();
    }

    public void calculateСost(Bouquet bouquet) {
        logician.calculateСost(bouquet);
    }

    public void addAccessories(Bouquet bouquet, Accessory... accessories) {
        designer.addAccessories(bouquet, accessories);
    }

    public void addAccessories(Bouquet bouquet, Accessory accessory, int amount) {
        designer.addAccessories(bouquet, accessory, amount);
    }

    public void sortByFreshness(Bouquet bouquet) {
        logician.SortByFreshness(bouquet);
    }

    public Bouquet addFlowers(Bouquet bouquet, Flower... flowers) {
        return florist.addFlowers(bouquet, flowers);
    }

    public Bouquet addFlowers(Bouquet bouquet, Flower flower, int amount) {
        return florist.addFlowers(bouquet, flower, amount);
    }

    public Flower getFlowerByStemLengthInterval(Bouquet bouquet, double from, double to) {
        return logician.getFlowerByStemLengthInterval(bouquet, from, to);
    }


    public void removeFlower(Bouquet bouquet, String name, int amount){
        florist.removeFlower(bouquet, name, amount);
    }

    public void removeAccessory(Bouquet bouquet, String name, int amount){
        designer.removeAccessory(bouquet, name, amount);
    }

    private class Logician {

        private Flower getFlowerByStemLengthInterval(Bouquet bouquet, double from, double to) {
            if (bouquet.isExist()) {
                for (Flower flower : bouquet.getFlowers()) {
                    if (flower.getStemLength() >= from && flower.getStemLength() <= to) {
                        return flower;
                    }
                }
            } else System.out.println((char) 27 + "[31mBouquet not found");
            return bouquet.getFlowers().get(0);
        }

        private void SortByFreshness(Bouquet bouquet) {
            if (bouquet.isExist()) {
                List<Flower> flowers = bouquet.getFlowers();
                flowers.sort(Comparator.comparingInt(Flower::getFreshnessStateLvl));
            } else System.out.println((char) 27 + "[31mBouquet not found");
        }

        private void calculateСost(Bouquet bouquet) {
            if (bouquet.isExist()) {
                BigDecimal cost = new BigDecimal("0.0");
                List<Flower> flowers = bouquet.getFlowers();
                List<Accessory> accessories = bouquet.getAccessories();

                for (Flower flower : flowers) {
                    if (flower.isExist()) cost = cost.add(flower.getPrice());
                    else System.out.println("Flower not found");
                }
                for (Accessory accessory : accessories) {
                    if (accessory.isExist()) cost = cost.add(accessory.getPrice());
                    else System.out.println("Accessory not found");
                }
                bouquet.setCost(cost);
            } else System.out.println((char) 27 + "[31mBouquet not found");
        }
    }

    private class Designer {
        private void addAccessories(Bouquet bouquet, Accessory... accessories) {
            if (bouquet.isExist()) {
                for (Accessory accessory : accessories) {
                    if (accessory.isExist()) bouquet.setAccessory(accessory);
                    else System.out.println("Accessory not found");
                }
            } else System.out.println((char) 27 + "[31mBouquet not found");
        }

        private void addAccessories(Bouquet bouquet, Accessory accessory, int amount) {
            if (bouquet.isExist()) {
                for (int i = 0; i < amount; i++) {
                    if (accessory.isExist()) bouquet.setAccessory(accessory);
                    else System.out.println((char) 27 + "Accessory not found");
                }
            } else System.out.println((char) 27 + "[31mBouquet not found");
        }


        private void removeAccessory(Bouquet bouquet, String name, int amount){
            if (bouquet.isExist()) {
                while (amount > 0) {
                    for (Accessory accessory : bouquet.getAccessories()) {
                        if (accessory.getName().equalsIgnoreCase(name)) {
                            bouquet.getAccessories().remove(accessory);
                            amount--;
                        }
                    }
                }
            } else System.out.println("Bouquet not found");
        }
    }

    private class Florist {

        private Bouquet addFlowers(Bouquet bouquet, Flower... flowers) {
            if (bouquet.isExist()) {
                for (Flower flower : flowers) {
                    if (flower.isExist()) bouquet.setFlower(flower);
                    else System.out.println("Flower not found");
                }
            } else System.out.println((char) 27 + "[31mBouquet not found");
            return bouquet;
        }

        private Bouquet addFlowers(Bouquet bouquet, Flower flower, int amount) {
            if (bouquet.isExist()) {
                for (int i = 0; i < amount; i++) {
                    if (flower.isExist()) bouquet.setFlower(flower);
                    else System.out.println("Flower not found");
                }
            } else System.out.println((char) 27 + "[31mBouquet not found");
            return bouquet;
        }


        private void removeFlower(Bouquet bouquet, String name, int amount){
            if (bouquet.isExist()) {
                while (amount > 0) {
                    for (Flower flower : bouquet.getFlowers()) {
                        if (flower.getName().equalsIgnoreCase(name)) {
                            bouquet.getFlowers().remove(flower);
                            amount--;
                        }
                    }
                }
            } else System.out.println("Bouquet not found");
        }
    }
}

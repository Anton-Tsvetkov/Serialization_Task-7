package ProgramLogic;

import ProgramLogic.Subjects.Accessorys.*;
import ProgramLogic.Subjects.Bouquet;
import ProgramLogic.Subjects.Flowers.Flower;
import ProgramLogic.Subjects.Flowers.Garden;
import ProgramLogic.Subjects.Flowers.Indoor;
import ProgramLogic.Subjects.Flowers.Wild;

import java.math.BigDecimal;

public class InputProcessing {

    public static boolean generalQuestion(String answer) {
        answer = answer.trim().toLowerCase();
        return answer.contains("y");
    }

    public static void addFlowerByParam(Bouquet bouquet, String type, String params, String amount) {

        params = params.
                trim().
                toLowerCase().
                replaceAll(" ", "");
        String[] parameters = params.split(",");

        String name = "Not found";
        String color = "Not found";
        BigDecimal price = new BigDecimal("0.0");
        int freshnessStateLvl = 0;
        double stemLength = 0.0;
        int quantity = 0;


        try {
            name = parameters[0];
            color = parameters[1];
            price = new BigDecimal(parameters[2]);
            freshnessStateLvl = Integer.parseInt(parameters[3]);
            stemLength = Double.parseDouble(parameters[4]);
            quantity = Integer.parseInt(amount);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

        if (bouquet.isExist()) {
            Flower flower;
            switch (type) {
                case "garden" -> {
                    flower = new Garden(name, color, price, freshnessStateLvl, stemLength);
                    new BouquetCreator().addFlowers(bouquet, flower, quantity);
                    new Connector().writeObject(flower);
                }
                case "indoor" -> {
                    flower = new Indoor(name, color, price, freshnessStateLvl, stemLength);
                    new BouquetCreator().addFlowers(bouquet, flower, quantity);
                    new Connector().writeObject(flower);
                }
                case "wild" -> {
                    flower = new Wild(name, color, price, freshnessStateLvl, stemLength);
                    new BouquetCreator().addFlowers(bouquet, flower, quantity);
                    new Connector().writeObject(flower);
                }
                default -> System.out.println("Flower " + type + " not found");
            }
        } else System.out.println((char) 27 + "[31mAccessory not found");
    }

    public static void removeFlowersByParam(Bouquet bouquet, String name, String amount) {
        int quantity = 0;
        name = name.trim().toLowerCase();

        try {
            quantity = Integer.parseInt(amount);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }


        if (bouquet.isExist()) {
            for (Flower flower : bouquet.getFlowers()) {
                if (flower.getName().equalsIgnoreCase(name)) {
                    new BouquetCreator().removeFlower(bouquet, name, quantity);
                }
            }
        } else System.out.println((char) 27 + "[31mSalad not found");
    }


    public static void addAccessoryByParam(Bouquet bouquet, String type, String params, String amount) {
        params = params.
                trim().
                toLowerCase().
                replaceAll(" ", "");
        String[] parameters = params.split(",");


        String name = "Not found";
        String color = "Not found";
        BigDecimal price = new BigDecimal("0.0");
        int quantity = 0;

        try {
            name = parameters[0];
            color = parameters[1];
            price = new BigDecimal(parameters[2]);
            quantity = Integer.parseInt(amount);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

        if (bouquet.isExist()) {
            Accessory accessory;
            switch (type) {
                case "basket" -> {
                    accessory = new Basket(name, color, price);
                    new BouquetCreator().addAccessories(bouquet, accessory, quantity);
                    new Connector().writeObject("basket", accessory);
                }
                case "pot" -> {
                    accessory = new Pot(name, color, price);
                    new BouquetCreator().addAccessories(bouquet, accessory, quantity);
                    new Connector().writeObject("pot", accessory);
                }
                case "tape" -> {
                    accessory = new Tape(name, color, price);
                    new BouquetCreator().addAccessories(bouquet, accessory, quantity);
                    new Connector().writeObject("tape", accessory);
                }
                case "wrappingpaper" -> {
                    accessory = new WrappingPaper(name, color, price);
                    new BouquetCreator().addAccessories(bouquet, accessory, quantity);
                    new Connector().writeObject("wrappingPaper", accessory);
                }
                default -> System.out.println("Accessory " + type + " not found");
            }
        } else System.out.println((char) 27 + "[31mAccessory not found");
    }

    public static void removeAccessoryByParam(Bouquet bouquet, String name, String amount) {

        int quantity = 0;
        name = name.trim().toLowerCase();

        try {
            quantity = Integer.parseInt(amount);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

        if (bouquet.isExist()) {
            for (Accessory accessory : bouquet.getAccessories()) {
                if (accessory.getName().equalsIgnoreCase(name)) {
                    new BouquetCreator().removeAccessory(bouquet, name, quantity);
                }
            }
        } else System.out.println((char) 27 + "[31mSalad not found");
    }

}

package ProgramLogic;

import ProgramLogic.Subjects.Salad;
import ProgramLogic.Subjects.Vegetables.*;

import java.util.List;

public class InputProcessing {

    public static boolean generalQuestion(String answer) {
        answer = answer.trim().toLowerCase();
        return answer.contains("y");
    }

    public static void addVegsByParam(Salad salad, String type, String params, String amount) {

        params = params.
                trim().
                toLowerCase().
                replaceAll(" ", "");
        String[] parameters = params.split(",");

        String name = "Not found";
        double weight = 0.0;
        int calorie = 0;
        int quantity = 0;

        try {
            name = parameters[0];
            weight = Double.parseDouble(parameters[1]);
            calorie = Integer.parseInt(parameters[2]);
            quantity = Integer.parseInt(amount);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

        Vegetable vegetable;
        if (salad.isExist()) {
            switch (type) {
                case "roots" -> {
                    vegetable = new Roots(name, weight, calorie);
                    new SaladCreator().addVegetables(salad, vegetable, quantity);
                    new Connector().writeObject("roots", vegetable);
                }
                case "bulbous" -> {
                    vegetable = new Bulbous(name, weight, calorie);
                    new SaladCreator().addVegetables(salad, vegetable, quantity);
                    new Connector().writeObject("bulbous", vegetable);
                }
                case "flowering" -> {
                    vegetable = new Flowering(name, weight, calorie);
                    new SaladCreator().addVegetables(salad, vegetable, quantity);
                    new Connector().writeObject("flowering", vegetable);
                }
                case "fruit" -> {
                    vegetable = new Fruit(name, weight, calorie);
                    new SaladCreator().addVegetables(salad, vegetable, quantity);
                    new Connector().writeObject("fruit", vegetable);
                }
                case "leafy" -> {
                    vegetable = new Leafy(name, weight, calorie);
                    new SaladCreator().addVegetables(salad, vegetable, quantity);
                    new Connector().writeObject("leafy", vegetable);
                }
                default -> System.out.println("Vegetable " + type + " not found");
            }
        } else System.out.println((char) 27 + "[31mSalad not found");

    }

    public static void removeVegsByParam(Salad salad, String name, String amount) {

        int quantity = 0;
        name = name.trim().toLowerCase();

        try {
            quantity = Integer.parseInt(amount);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

        if (salad.isExist()) {
            for(Vegetable vegetable : salad.getVegetables()){
                if(vegetable.getName().equalsIgnoreCase(name)){
                    new SaladCreator().removeVegetables(salad, name, quantity);
                }
            }
        } else System.out.println((char) 27 + "[31mSalad not found");

    }
}

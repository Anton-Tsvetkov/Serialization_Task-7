package ProgramLogic;

import ProgramLogic.Subjects.Confection.*;
import ProgramLogic.Subjects.SweetsBox;

import java.math.BigDecimal;

public class InputProcessing {

    public static boolean generalQuestion(String answer) {
        answer = answer.trim().toLowerCase();
        return answer.contains("y");
    }

    public static void addSweetByParam(SweetsBox sweetsBox, String type, String params, String amount) {

        params = params.
                trim().
                toLowerCase().
                replaceAll(" ", "");
        String[] parameters = params.split(",");

        String name = "Not found";
        String filling = "Not found";
        int suragLvl = 0;
        double weight = 0.0;
        int quantity = 0;

        try {
            name = parameters[0];
            filling = parameters[1];
            suragLvl = Integer.parseInt(parameters[2]);
            weight = Integer.parseInt(parameters[3]);
            quantity = Integer.parseInt(amount);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

        Confection confection;
        if (sweetsBox.isExist()) {
            switch (type) {
                case "wafer" -> {
                    confection = new Wafer(name, filling, suragLvl, weight);
                    new BoxCreator().addSweets(sweetsBox, confection, quantity);
                    new Connector().writeObject("wafer", confection);
                }
                case "chocolate" -> {
                    confection = new Chocolate(name, filling, suragLvl, weight);
                    new BoxCreator().addSweets(sweetsBox, confection, quantity);
                    new Connector().writeObject("chocolate", confection);
                }
                case "lollipop" -> {
                    confection = new Lollipop(name, filling, suragLvl, weight);
                    new BoxCreator().addSweets(sweetsBox, confection, quantity);
                    new Connector().writeObject("lollipop", confection);
                }
                case "candy" -> {
                    confection = new Candy(name, filling, suragLvl, weight);
                    new BoxCreator().addSweets(sweetsBox, confection, quantity);
                    new Connector().writeObject("candy", confection);
                }
                default -> System.out.println("Confection " + type + " not found");
            }
        } else System.out.println((char) 27 + "[31mSweetsBox not found");
    }
}
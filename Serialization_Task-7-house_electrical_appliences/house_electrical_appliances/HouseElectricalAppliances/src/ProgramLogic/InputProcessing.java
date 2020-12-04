package ProgramLogic;

import ProgramLogic.Subjects.HomeElectrical.*;
import ProgramLogic.Subjects.House;

public class InputProcessing {

    public static boolean generalQuestion(String answer) {
        answer = answer.trim().toLowerCase();
        switch (answer){
            case "on", "y", "yes", "true" -> {
                return true;
            }
        }
        return answer.contains("y");
    }

    public static void addSweetByParam(House house, String type, String params, String amount) {

        params = params.
                trim().
                toLowerCase().
                replaceAll(" ", "");
        String[] parameters = params.split(",");

        String name = "Not found";
        double сonsumption = 0.0;
        boolean power = false;
        int quantity = 0;

        try {
            name = parameters[0];
            сonsumption = Double.parseDouble(parameters[1]);
            power = generalQuestion(parameters[2]);
            quantity = Integer.parseInt(amount);
        } catch (ClassCastException ex){
            ex.printStackTrace();
        }


        HomeElectrical electricalAppliance;
        if(house.isExist()) {
            switch (type) {
                case "video" -> {
                    electricalAppliance = new Video(name, сonsumption, power);
                    new ElectricalPanel().addElectraAppliances(house, electricalAppliance, quantity);
                    new Connector().writeObject("video", electricalAppliance);
                }
                case "audio" -> {
                    electricalAppliance = new Audio(name, сonsumption, power);
                    new ElectricalPanel().addElectraAppliances(house, electricalAppliance, quantity);
                    new Connector().writeObject("audio", electricalAppliance);
                }
                case "appliances" -> {
                    electricalAppliance = new Appliances(name, сonsumption, power);
                    new ElectricalPanel().addElectraAppliances(house, electricalAppliance, quantity);
                    new Connector().writeObject("appliances", electricalAppliance);
                }
                default -> System.out.println("Appliances " + type + " not found");
            }
        } else System.out.println((char) 27 + "[31mAppliances not found");
    }
}
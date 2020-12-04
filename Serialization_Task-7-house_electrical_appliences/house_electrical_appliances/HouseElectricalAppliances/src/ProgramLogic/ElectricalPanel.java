package ProgramLogic;

import ProgramLogic.Subjects.House;
import ProgramLogic.Subjects.HomeElectrical.HomeElectrical;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ElectricalPanel {

    Electrician electrician;
    Logician logician;

    public ElectricalPanel() {
        this.electrician = new Electrician();
        this.logician = new Logician();
    }

    public void calculateConsumption(House house) {
        logician.calculateConsumption(house);
    }

    public void sortByConsumption(House house) {
        logician.sortByConsumption(house);
    }

    public House addElectraAppliances(House house, HomeElectrical... electricalAppliances) {
        return electrician.addElectraApp(house, electricalAppliances);
    }

    public House addElectraAppliances(House house, HomeElectrical electricalAppliance, int amount) {
        return electrician.addElectraApp(house, electricalAppliance, amount);
    }

    public HomeElectrical getAppByConsumptionInterval(House house, double from, double to) {
        return logician.getAppByConsumptionInterval(house, from, to);
    }

    public List<HomeElectrical> getONorOFFApp(House house, boolean power) {
        return logician.getONorOFFApp(house, power);
    }


    public void removeAppliances(House house, String name, int amount){
        electrician.removeAppliances(house, name, amount);
    }

    private class Logician {

        private HomeElectrical getAppByConsumptionInterval(House house, double from, double to) {
            if (house.isExist()) {
                for (HomeElectrical electricalAppliance : house.getElectricalAppliances()) {
                    if (electricalAppliance.isExist()) {
                        if (electricalAppliance.getConsumption() >= from && electricalAppliance.getConsumption() <= to) {
                            return electricalAppliance;
                        }
                    } else System.out.println("Electrical appliance not found");
                }
            } else System.out.println((char) 27 + "[31mHouse not found");
            return house.getElectricalAppliances().get(0);
        }

        private List<HomeElectrical> getONorOFFApp(House house, boolean power) {
            List<HomeElectrical> homeElectrics = new ArrayList<>();
            if (house.isExist()) {
                for (HomeElectrical electricalAppliance : house.getElectricalAppliances()) {
                    if (electricalAppliance.isExist()) {
                        if (electricalAppliance.isPower()) {
                            homeElectrics.add(electricalAppliance);
                        }
                    } else System.out.println("Electrical appliance not found");
                }
            } else System.out.println((char) 27 + "[31mHouse not found");
            return homeElectrics;
        }

        private void sortByConsumption(House house) {
            if (house.isExist()) {
                List<HomeElectrical> electricalAppliances = house.getElectricalAppliances();
                electricalAppliances.sort(Comparator.comparingDouble(HomeElectrical::getConsumption));
            } else System.out.println((char) 27 + "[31mHouse not found");
        }

        private void calculateConsumption(House house) {
            if (house.isExist()) {
                double calories = 0.0;
                List<HomeElectrical> electricalAppliances = house.getElectricalAppliances();
                for (HomeElectrical electricalAppliance : electricalAppliances) {
                    if (electricalAppliance.isExist()) calories += electricalAppliance.getConsumption();
                    else System.out.println("Electrical appliance not found");
                }
                house.setConsumption(calories);
            } else System.out.println((char) 27 + "[31mHouse not found");
        }
    }

    private class Electrician {

        private House addElectraApp(House house, HomeElectrical... electricalAppliances) {
            if (house.isExist()) {
                for (HomeElectrical electricalAppliance : electricalAppliances) {
                    if (electricalAppliance.isExist()) house.setElectricalAppliances(electricalAppliance);
                    else System.out.println("Electrical appliance not found");
                }
            } else System.out.println((char) 27 + "[31mHouse not found");
            return house;
        }

        private House addElectraApp(House house, HomeElectrical electricalAppliance, int amount) {
            if (house.isExist()) {
                for (int i = 0; i < amount; i++) {
                    if (electricalAppliance.isExist()) house.setElectricalAppliances(electricalAppliance);
                    else System.out.println("Electrical appliance not found");
                }
            } else System.out.println((char) 27 + "[31mHouse not found");
            return house;
        }


        private void removeAppliances(House house, String name, int amount){
            if (house.isExist()) {
                while (amount > 0) {
                    for (HomeElectrical homeElectrical : house.getElectricalAppliances()) {
                        if (homeElectrical.getName().equalsIgnoreCase(name)) {
                            house.getElectricalAppliances().remove(homeElectrical);
                            amount--;
                        }
                    }
                }
            } else System.out.println((char) 27 + "[31mHouse not found");
        }
    }
}

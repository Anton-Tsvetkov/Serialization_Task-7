import ProgramLogic.Connector;
import ProgramLogic.InputProcessing;
import ProgramLogic.ElectricalPanel;
import ProgramLogic.Subjects.House;

import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String confParamOrder = "Name, Consumption, Power";
        ElectricalPanel electricalPanel = new ElectricalPanel();
        House house = new House();

        String extractResults = "";
        new Connector().extractObject(house);
        if (house.isExist()) {
            extractResults = "I find a house\n".concat(String.valueOf(house));
        } else {
            extractResults = "House not found";
        }

        String answer = "answer";
        do {
            System.out.println(extractResults);
            if (!extractResults.equalsIgnoreCase("House not found")) {
                System.out.println("Do you want change your house? (y/n)");
                answer = scanner.nextLine();
                if (InputProcessing.generalQuestion(answer)) {
                    System.out.println("""
                            What changes do you want make?
                            a) Add appliances
                            b) Remove appliances
                            (please select the letter)
                            """);
                    answer = scanner.nextLine();
                    answer = answer.
                            trim().
                            toLowerCase().
                            replaceAll("\\)", "");

                    switch (answer) {
                        case "a" -> {
                            do {
                                System.out.println("Please select electrical appliance type: ");
                                System.out.println("""
                                        Appliances
                                        Audio
                                        Video
                                        """);
                                String type = scanner.nextLine();
                                type = type.trim().toLowerCase();
                                System.out.println("Print appliance's parameters in the following order: \n" + confParamOrder);
                                answer = scanner.nextLine();
                                System.out.println("And amount of them (digit): ");
                                String amount = scanner.nextLine();
                                InputProcessing.addSweetByParam(house, type, answer, amount);

                                electricalPanel.calculateConsumption(house);
                                electricalPanel.sortByConsumption(house);
                                new Connector().writeObject(house);
                                System.out.println(house);

                                System.out.println("More electrical appliances? (y/n)");
                                answer = scanner.nextLine();

                            } while (InputProcessing.generalQuestion(answer));
                            new Connector().writeObject(house);
                        }
                        case "b" -> {
                            do {
                                System.out.println("Print appliances's name: ");
                                answer = scanner.nextLine();
                                System.out.println("And amount of them (digit): ");
                                String amount = scanner.nextLine();
                                InputProcessing.removeAppsByParam(house, answer, amount);

                                electricalPanel.calculateConsumption(house);
                                electricalPanel.sortByConsumption(house);
                                new Connector().writeObject(house);
                                System.out.println(house);

                                System.out.println("More appliances? (y/n)");
                                answer = scanner.nextLine();

                            } while (InputProcessing.generalQuestion(answer));
                            new Connector().writeObject(house);
                        }
                    }
                }
            }
            System.out.println("It's electrical time!");
            do {
                System.out.println("Please select electrical appliance type: ");
                System.out.println("""
                        Appliances
                        Audio
                        Video
                        """);
                String type = scanner.nextLine();
                type = type.trim().toLowerCase();
                System.out.println("Print appliance's parameters in the following order: \n" + confParamOrder);
                answer = scanner.nextLine();
                System.out.println("And amount of them (digit): ");
                String amount = scanner.nextLine();
                InputProcessing.addSweetByParam(house, type, answer, amount);

                electricalPanel.calculateConsumption(house);
                electricalPanel.sortByConsumption(house);
                new Connector().writeObject(house);
                System.out.println(house);

                System.out.println("More electrical appliances? (y/n)");
                answer = scanner.nextLine();

            } while (InputProcessing.generalQuestion(answer));

            System.out.println("Do you want find electrical appliance by consumption interval? (y/n)");

            if (InputProcessing.generalQuestion(answer)) {
                try {
                    System.out.print("Print min consumption: ");
                    double from = scanner.nextDouble();
                    System.out.print("and max: ");
                    double to = scanner.nextDouble();
                    System.out.println(electricalPanel.getAppByConsumptionInterval(house, from, to));
                } catch (ClassCastException ex) {
                    ex.printStackTrace();
                }
            }

            System.out.println("Do you want find ON or OFF electrical appliance? (y/n)");

            if (InputProcessing.generalQuestion(answer)) {
                System.out.print("ON or OFF electrical appliance: ");
                System.out.println(electricalPanel.getONorOFFApp(house, InputProcessing.generalQuestion(scanner.nextLine())));
                new Connector().writeObject(house);
            }
        } while (answer.equalsIgnoreCase("exit"));
    }
}

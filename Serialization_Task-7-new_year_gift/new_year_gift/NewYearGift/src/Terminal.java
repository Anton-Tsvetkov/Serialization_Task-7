import ProgramLogic.BoxCreator;
import ProgramLogic.Connector;
import ProgramLogic.InputProcessing;
import ProgramLogic.Subjects.SweetsBox;

import java.util.Random;
import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String confParamOrder = "Name, Filling, SugarLvl, Weight";
        BoxCreator boxCreator = new BoxCreator();
        SweetsBox sweetsBox = new SweetsBox();
        String extractResults = "";
        new Connector().extractObject(sweetsBox);
        if (sweetsBox.isExist()) {
            extractResults = "I find a SweetsBox\n".concat(String.valueOf(sweetsBox));
        } else {
            extractResults = "SweetsBox not found";
        }

        String answer = "answer";
        do {
            System.out.println("Do you want create a sweets box? (y/n)");
            answer = scanner.nextLine();
            if (InputProcessing.generalQuestion(answer)) {
                System.out.println("It's collect the sweets time!");
                do {
                    System.out.println("Please select confection type: ");
                    System.out.println("""
                            Candy
                            Chocolate
                            Lollipop
                            Wafer
                            """);
                    String type = scanner.nextLine();
                    type = type.trim().toLowerCase();
                    System.out.println("Print confection's parameters in the following order: \n" + confParamOrder);
                    answer = scanner.nextLine();
                    System.out.println("And amount of them (digit): ");
                    String amount = scanner.nextLine();
                    InputProcessing.addSweetByParam(sweetsBox, type, answer, amount);

                    boxCreator.calculateWeight(sweetsBox);
                    boxCreator.sortBySugar(sweetsBox);
                    new Connector().writeObject(sweetsBox);
                    System.out.println(sweetsBox);

                    System.out.println("More confections? (y/n)");
                    answer = scanner.nextLine();

                } while (InputProcessing.generalQuestion(answer));
                System.out.println("Do you want find sweet by sugar interval? (y/n)");
                if (InputProcessing.generalQuestion(answer)) {
                    try {
                        System.out.print("Print min sugar: ");
                        double from = scanner.nextDouble();
                        System.out.print("and max: ");
                        double to = scanner.nextDouble();
                        System.out.println(boxCreator.getSweetBySugarInterval(sweetsBox, from, to));
                    } catch (ClassCastException ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                System.out.println("Sorry, but can't do anything else");
            }
        } while (answer.equalsIgnoreCase("exit"));
    }
}

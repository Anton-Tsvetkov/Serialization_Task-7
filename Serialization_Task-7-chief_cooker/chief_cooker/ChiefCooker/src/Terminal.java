import ProgramLogic.Connector;
import ProgramLogic.SaladCreator;
import ProgramLogic.InputProcessing;
import ProgramLogic.Subjects.Salad;

import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String confParamOrder = "Name, Weight, Calories";
        SaladCreator saladCreator = new SaladCreator();
        Salad salad = new Salad();
        String extractResults = "";
        new Connector().extractObject(salad);
        if (salad.isExist()) {
            extractResults = "I find a salad\n".concat(String.valueOf(salad));
        } else {
            extractResults = "Salad not found";
        }

        String answer;
        do {
            System.out.println(extractResults);
            if (!extractResults.equalsIgnoreCase("Salad not found")) {
                System.out.println("Do you want change your salad? (y/n)");
                answer = scanner.nextLine();
                if (InputProcessing.generalQuestion(answer)) {
                    System.out.println("""
                            What changes do you want make?
                            a) Add vegetables
                            b) Remove vegetables
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
                                System.out.println("Please select vegetable type: ");
                                System.out.println("""
                                        Bulbous
                                        Flowering
                                        Fruit
                                        Leafy
                                        Roots
                                        """);
                                String type = scanner.nextLine();
                                type = type.trim().toLowerCase();
                                System.out.println("Print vegetable's parameters in the following order: \n" + confParamOrder);
                                answer = scanner.nextLine();
                                System.out.println("And amount of them (digit): ");
                                String amount = scanner.nextLine();
                                InputProcessing.addVegsByParam(salad, type, answer, amount);

                                saladCreator.calculateCalories(salad);
                                saladCreator.sortByCalorie(salad);
                                new Connector().writeObject(salad);
                                System.out.println(salad);

                                System.out.println("More vegetables? (y/n)");
                                answer = scanner.nextLine();

                            } while (InputProcessing.generalQuestion(answer));
                            new Connector().writeObject(salad);
                        }
                        case "b" -> {
                            do {
                                System.out.println("Please select vegetable type: ");
                                System.out.println("""
                                        Bulbous
                                        Flowering
                                        Fruit
                                        Leafy
                                        Roots
                                        """);
                                String type = scanner.nextLine();
                                type = type.trim().toLowerCase();
                                System.out.println("Print vegetable's name: ");
                                answer = scanner.nextLine();
                                System.out.println("And amount of them (digit): ");
                                String amount = scanner.nextLine();
                                InputProcessing.removeVegsByParam(salad, answer, amount);

                                saladCreator.calculateCalories(salad);
                                saladCreator.sortByCalorie(salad);
                                new Connector().writeObject(salad);
                                System.out.println(salad);

                                System.out.println("More vegetables? (y/n)");
                                answer = scanner.nextLine();

                            } while (InputProcessing.generalQuestion(answer));
                            new Connector().writeObject(salad);
                        }
                    }
                }
            }
            System.out.println("Do you want create a new salad? (y/n)");
            answer = scanner.nextLine();
            if (InputProcessing.generalQuestion(answer)) {
                System.out.println("It's vegetables time!");
                do {
                    System.out.println("Please select vegetable type: ");
                    System.out.println("""
                            Bulbous
                            Flowering
                            Fruit
                            Leafy
                            Roots
                            """);
                    String type = scanner.nextLine();
                    type = type.trim().toLowerCase();
                    System.out.println("Print vegetable's parameters in the following order: \n" + confParamOrder);
                    answer = scanner.nextLine();
                    System.out.println("And amount of them (digit): ");
                    String amount = scanner.nextLine();
                    InputProcessing.addVegsByParam(salad, type, answer, amount);

                    saladCreator.calculateCalories(salad);
                    saladCreator.sortByCalorie(salad);
                    new Connector().writeObject(salad);
                    System.out.println(salad);

                    System.out.println("More vegetables? (y/n)");
                    answer = scanner.nextLine();

                } while (InputProcessing.generalQuestion(answer));
                System.out.println("Do you want find vegetable by calorie interval? (y/n)");
                if (InputProcessing.generalQuestion(answer)) {
                    try {
                        System.out.print("Print min calories: ");
                        double from = scanner.nextDouble();
                        System.out.print("and max: ");
                        double to = scanner.nextDouble();
                        System.out.println(saladCreator.getVegByCaloriesInterval(salad, from, to));
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

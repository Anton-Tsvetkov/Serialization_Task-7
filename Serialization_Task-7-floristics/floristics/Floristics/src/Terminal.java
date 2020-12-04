import ProgramLogic.BouquetCreator;
import ProgramLogic.Connector;
import ProgramLogic.InputProcessing;
import ProgramLogic.Subjects.Bouquet;

import java.util.Random;
import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowerParamOrder = "Name, Color, Price, Freshness state level, Stem length";
        String accessParamOrder = "Name, Color, Price";
        BouquetCreator bouquetCreator = new BouquetCreator();
        Bouquet bouquet = new Bouquet();
        String extractResults = "";
        new Connector().extractObject(bouquet);
        if (bouquet.isExist()) {
            extractResults = "I find a bouquet\n".concat(String.valueOf(bouquet));
        } else {
            extractResults = "Bouquet not found";
        }

        String answer = "answer";
        do {
            System.out.println(extractResults);
            System.out.println("Do you want create a bouquet? (y/n)");
            answer = scanner.nextLine();
            if (InputProcessing.generalQuestion(answer)) {
                System.out.println("It's collect the bouquet time!");
                do {
                    System.out.println("Please select flower type: ");
                    System.out.println("""
                            Garden
                            Indoor
                            Wild
                            """);
                    String type = scanner.nextLine();
                    type = type.trim().toLowerCase();
                    System.out.println("Print flower's parameters in the following order: \n" + flowerParamOrder);
                    answer = scanner.nextLine();
                    System.out.println("And amount of them (digit): ");
                    String amount = scanner.nextLine();
                    InputProcessing.addFlowerByParam(bouquet, type, answer, amount);

                    bouquetCreator.calculateСost(bouquet);
                    new Connector().writeObject(bouquet);
                    System.out.println(bouquet);

                    System.out.println("More flowers? (y/n)");
                    answer = scanner.nextLine();

                } while (InputProcessing.generalQuestion(answer));

                System.out.println("Do you want add some accessories? (y/n)");
                answer = scanner.nextLine();
                if (InputProcessing.generalQuestion(answer)) {
                    do {
                        System.out.println("Please select accessory type: ");
                        System.out.println("""
                                Basket
                                Pot
                                Tape
                                Wrapped paper
                                """);
                        System.out.println();
                        String type = scanner.nextLine();
                        System.out.println("Print accessory's parameters in the following order: \n" + accessParamOrder);
                        answer = scanner.nextLine();
                        System.out.println("And amount of them: ");
                        String amount = scanner.nextLine();
                        InputProcessing.addAccessoryByParam(bouquet, type, answer, amount);

                        bouquetCreator.calculateСost(bouquet);
                        System.out.println(bouquet);

                        System.out.println("More accessories? (y/n)");
                        answer = scanner.nextLine();

                    } while (InputProcessing.generalQuestion(answer));

                    do {
                        System.out.println("It's all?");
                        System.out.println("Additionally you can...");
                        System.out.println("""
                                a) Sort flowers in a bouquet based on freshness
                                b) Find a flower in a bouquet that matches a given range of stem lengths
                                c) Finish
                                please select the letter          
                                """);

                        bouquetCreator.calculateСost(bouquet);
                        new Connector().writeObject(bouquet);

                        System.out.println(bouquet);

                        answer = scanner.nextLine();
                        answer = answer.
                                trim().
                                toLowerCase().
                                replaceAll("\\)", "");

                        switch (answer) {
                            case "a" -> {
                                bouquetCreator.sortByFreshness(bouquet);
                                System.out.println(bouquet);
                                new Connector().writeObject(bouquet);
                            }
                            case "b" -> {
                                try {
                                System.out.println("Print range of stem lengths: ");
                                System.out.print("min length: ");
                                double from = scanner.nextDouble();
                                System.out.print("max length: ");
                                double to = scanner.nextDouble();
                                System.out.println(bouquetCreator.getFlowerByStemLengthInterval(bouquet, from, to));
                                } catch (ClassCastException ex){
                                    ex.printStackTrace();
                                }
                            }
                        }
                    } while (answer.equalsIgnoreCase("d"));
                } else {
                    switch (new Random().nextInt(5)) {
                        case 0 -> System.out.println("I understand you");
                        case 1 -> System.out.println("I see");
                        case 2 -> System.out.println("No problem");
                        case 3 -> System.out.println("Ok");
                        case 4 -> System.out.println("As you say");
                        default -> System.out.println("As you want");
                    }
                }
            } else {
                System.out.println("Sorry, but can't do anything else");
            }
        } while (answer.equalsIgnoreCase("exit"));
    }
}

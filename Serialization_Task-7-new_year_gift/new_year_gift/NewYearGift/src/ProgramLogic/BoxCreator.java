package ProgramLogic;

import ProgramLogic.Subjects.SweetsBox;
import ProgramLogic.Subjects.Confection.Confection;

import java.util.Comparator;
import java.util.List;

public class BoxCreator {

    Confectioner confectioner;
    Logician logician;

    public BoxCreator() {
        this.confectioner = new Confectioner();
        this.logician = new Logician();
    }

    public void calculateWeight(SweetsBox sweetsBox) {
        logician.calculateWeight(sweetsBox);
    }

    public void sortBySugar(SweetsBox sweetsBox) {
        logician.SortBySugar(sweetsBox);
    }

    public SweetsBox addSweets(SweetsBox sweetsBox, Confection... confections) {
        return confectioner.addSweets(sweetsBox, confections);
    }

    public SweetsBox addSweets(SweetsBox sweetsBox, Confection confection, int amount) {
        return confectioner.addSweets(sweetsBox, confection, amount);
    }

    public Confection getSweetBySugarInterval(SweetsBox sweetsBox, double from, double to) {
        return logician.getSweetBySugarInterval(sweetsBox, from, to);
    }

    public void removeConfections(SweetsBox sweetsBox, String name, int amount){
        confectioner.removeConfections(sweetsBox, name, amount);
    }


    private class Logician {

        private Confection getSweetBySugarInterval(SweetsBox sweetsBox, double from, double to) {
            if (sweetsBox.isExist()) {
                for (Confection confection : sweetsBox.getSweets()) {
                    if (confection.isExist()) {
                        if (confection.getSugarLvl() >= from && confection.getSugarLvl() <= to) {
                            return confection;
                        }
                    } else System.out.println((char) 27 + "[31mConfection not found");
                }
            } else System.out.println((char) 27 + "[31mSweetsBox not found");
            return sweetsBox.getSweets().get(0);
        }

        private void SortBySugar(SweetsBox sweetsBox) {
            if (sweetsBox.isExist()) {
                List<Confection> confections = sweetsBox.getSweets();
                confections.sort(Comparator.comparingInt(Confection::getSugarLvl));
            } else System.out.println((char) 27 + "[31mConfection not found");
        }

        private void calculateWeight(SweetsBox sweetsBox) {

            if (sweetsBox.isExist()) {
                double weight = 0.0;
                List<Confection> confections = sweetsBox.getSweets();

                for (Confection confection : confections) {
                    if (confection.isExist()) weight += confection.getWeight();
                    else System.out.println((char) 27 + "[31mConfection not found");
                }
                sweetsBox.setWeight(weight);
            } else System.out.println((char) 27 + "[31mSweetsBox not found");
        }
    }

    private class Confectioner {

        private SweetsBox addSweets(SweetsBox sweetsBox, Confection... confections) {
            if (sweetsBox.isExist()) {
                for (Confection confection : confections) {
                    if (confection.isExist()) sweetsBox.setSweet(confection);
                    else System.out.println((char) 27 + "[31mConfection not found");
                }
            } else System.out.println((char) 27 + "[31mSweetsBox not found");
            return sweetsBox;
        }

        private SweetsBox addSweets(SweetsBox sweetsBox, Confection confection, int amount) {
            if (sweetsBox.isExist()) {
                for (int i = 0; i < amount; i++) {
                    if (confection.isExist()) sweetsBox.setSweet(confection);
                    else System.out.println((char) 27 + "[31mConfection not found");
                }
            } else System.out.println((char) 27 + "[31mSweetsBox not found");
            return sweetsBox;
        }

        private void removeConfections(SweetsBox sweetsBox, String name, int amount){
            if (sweetsBox.isExist()) {
                while (amount > 0) {
                    for (Confection confection : sweetsBox.getSweets()) {
                        if (confection.getName().equalsIgnoreCase(name)) {
                            sweetsBox.getSweets().remove(confection);
                            amount--;
                        }
                    }
                }
            } else System.out.println((char) 27 + "[31mSweetsBox not found");
        }

    }
}

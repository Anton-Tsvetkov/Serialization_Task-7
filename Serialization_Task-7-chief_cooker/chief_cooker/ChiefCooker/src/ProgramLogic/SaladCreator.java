package ProgramLogic;

import ProgramLogic.Subjects.Vegetables.Vegetable;
import ProgramLogic.Subjects.Salad;

import java.util.Comparator;
import java.util.List;

public class SaladCreator {

    Chef chef;
    Logician logician;

    public SaladCreator() {
        this.chef = new Chef();
        this.logician = new Logician();
    }

    public void calculateCalories(Salad salad) {
        logician.calculateCalorie(salad);
    }

    public void sortByCalorie(Salad salad) {
        logician.SortByCalorie(salad);
    }

    public Salad addVegetables(Salad salad, Vegetable... vegetables) {
        return chef.addVegetables(salad, vegetables);
    }

    public Salad addVegetables(Salad salad, Vegetable vegetable, int amount) {
        return chef.addVegetables(salad, vegetable, amount);
    }

    public Vegetable getVegByCaloriesInterval(Salad salad, double from, double to) {
        return logician.getVegByCaloriesInterval(salad, from, to);
    }

    public void removeVegetables(Salad salad, String name, int amount) {
        chef.removeVegetables(salad, name, amount);
    }


    private class Logician {

        private Vegetable getVegByCaloriesInterval(Salad salad, double from, double to) {
            if (salad.isExist()) {
                for (Vegetable vegetable : salad.getVegetables()) {
                    if (vegetable.isExist()) {
                        if (vegetable.getCalorie() >= from && vegetable.getCalorie() <= to) {
                            return vegetable;
                        }
                    } else System.out.println((char) 27 + "[31mVegetable not found");
                }
            } else System.out.println((char) 27 + "[31mSalad not found");
            return salad.getVegetables().get(0);
        }

        private void SortByCalorie(Salad salad) {
            if (salad.isExist()) {
                List<Vegetable> vegetables = salad.getVegetables();
                vegetables.sort(Comparator.comparingInt(Vegetable::getCalorie));
            } else System.out.println((char) 27 + "[31mSalad not found");
        }

        private void calculateCalorie(Salad salad) {
            if (salad.isExist()) {
                double calories = 0.0;
                List<Vegetable> vegetables = salad.getVegetables();

                for (Vegetable vegetable : vegetables) {
                    calories += vegetable.getCalorie();
                }
                salad.setCalorie(calories);
            } else System.out.println((char) 27 + "[31mSalad not found");
        }
    }

    private class Chef {

        private Salad addVegetables(Salad salad, Vegetable... vegetables) {
            if (salad.isExist()) {
                for (Vegetable vegetable : vegetables) {
                    if (vegetable.isExist()) salad.setVegetable(vegetable);
                    else System.out.println((char) 27 + "[31mVegetable not found");
                }
            } else System.out.println((char) 27 + "[31mSalad not found");
            return salad;
        }

        private Salad addVegetables(Salad salad, Vegetable vegetable, int amount) {
            if (salad.isExist()) {
                for (int i = 0; i < amount; i++) {
                    if (vegetable.isExist()) salad.setVegetable(vegetable);
                    else System.out.println((char) 27 + "[31mVegetable not found");
                }
            } else System.out.println((char) 27 + "[31mSalad not found");
            return salad;
        }


        private void removeVegetables(Salad salad, String name, int amount) {
            if (salad.isExist()) {
                while (amount > 0) {
                    for (Vegetable vegetable : salad.getVegetables()) {
                        if (vegetable.getName().equalsIgnoreCase(name)) {
                            salad.getVegetables().remove(vegetable);
                            amount--;
                        }
                    }
                }
            } else System.out.println((char) 27 + "[31mSalad not found");
        }
    }
}

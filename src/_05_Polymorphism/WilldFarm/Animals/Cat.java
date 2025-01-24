package _05_Polymorphism.WilldFarm.Animals;

import _05_Polymorphism.WilldFarm.Food.Food;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String type, double weight, String livingRegion, String breed) {
        super(animalName, type, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        StringBuilder baseToString = new StringBuilder(super.toString());
        baseToString.insert(baseToString.indexOf(",") + 1, " " + this.breed + ",");

        return baseToString.toString();
    }

}
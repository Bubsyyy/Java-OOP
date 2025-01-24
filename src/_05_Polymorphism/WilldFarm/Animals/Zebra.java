package _05_Polymorphism.WilldFarm.Animals;

import _05_Polymorphism.WilldFarm.Food.Food;
import _05_Polymorphism.WilldFarm.Food.Meat;

public class Zebra extends Mammal {

    public Zebra(String animalName, String type, double weight, String livingRegion) {
        super(animalName, type, weight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

}
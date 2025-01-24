package _05_Polymorphism.WilldFarm.Animals;

import _05_Polymorphism.WilldFarm.Food.Food;
import _05_Polymorphism.WilldFarm.Food.Vegetable;

public class Tiger extends Felime {

    public Tiger(String animalName, String type, double weight, String livingRegion) {
        super(animalName, type, weight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

}

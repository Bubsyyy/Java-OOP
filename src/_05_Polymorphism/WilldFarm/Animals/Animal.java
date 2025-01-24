package _05_Polymorphism.WilldFarm.Animals;

import _05_Polymorphism.WilldFarm.Food.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String type;
    private double weight;
    private int foodEaten;
    private String livingRegion;

    protected Animal(String animalName, String type, double weight, String livingRegion) {
        this.animalName = animalName;
        this.type = type;
        this.weight = weight;
        this.livingRegion = livingRegion;
    }

    protected String getType() {
        return this.type;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]",
                this.type,
                this.animalName,
                formatter.format(this.weight),
                this.livingRegion,
                this.foodEaten);
    }

}
package ru.dexsys;

import lombok.Getter;

@Getter
public class CoffeeMachine {
    private final int WATER_CAPACITY = 2000;
    private final int COFFEE_SEED_CAPACITY = 200;
    private final int CUP_WATER_CAPACITY = 200;
    private final int CUP_COFFEE_SEEDS_CAPACITY = 10;
    private int water; //ml
    private int coffeeSeeds; //g

    public void doOneCupOfCoffee() {
        if (water >= 200 && coffeeSeeds >= 10) {
            water -= CUP_WATER_CAPACITY;
            coffeeSeeds -= CUP_COFFEE_SEEDS_CAPACITY;
            System.out.println("Take your cup of coffee");
        } else if (water < 200) {
            System.err.println("There is not enough water");
        } else {
            System.err.println("There is not enough coffee seeds");
        }
    }

    public void doAnyCupOfCoffee(int count) {
        for (int i = 0; i < count; i++) {
            doOneCupOfCoffee();
        }
    }

    public void addWater(int water) {
        this.water += water;
        if (this.water > WATER_CAPACITY) {
            this.water = WATER_CAPACITY;
            System.err.println("So mach water...");
        }
    }

    public void addCoffeeSeeds(int coffeeSeeds) {
        this.coffeeSeeds += coffeeSeeds;
        if (this.coffeeSeeds > COFFEE_SEED_CAPACITY) {
            this.coffeeSeeds = COFFEE_SEED_CAPACITY;
            System.err.println("So mach coffee seeds...");
        }
    }

    public void showContent() {
        System.out.printf("water - %s ml\ncoffee seeds - %s g", water, coffeeSeeds);
    }
}
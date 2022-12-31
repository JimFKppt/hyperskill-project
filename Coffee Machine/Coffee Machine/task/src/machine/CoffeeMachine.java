package machine;

import java.util.Scanner;

public class CoffeeMachine {

    // supplies
    private int water; // ml
    private int milk; // ml
    private int beans; // g
    private int disposableCups; // cups
    private double money; // $

    public CoffeeMachine() {
        this.water = 0;
        this.milk = 0;
        this.beans = 0;
        this.disposableCups = 0;
        this.money = 0;
    }

    public CoffeeMachine(int water, int milk, int beans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public boolean action() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.next();

        switch (action) {
            case "buy":
                System.out.println();
                buy();
                System.out.println();
                break;
            case "fill":
                System.out.println();
                fill();
                System.out.println();
                break;
            case "take":
                System.out.println();
                take();
                System.out.println();
                break;
            case "remaining":
                System.out.println();
                System.out.println(this.toString());
                System.out.println();
                break;
            case "exit":
                return false;
            default:
                System.out.println();
                break;
        }

        return true;
    }

    void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scanner = new Scanner(System.in);
        String codeOfCoffee = scanner.next();

        switch (codeOfCoffee) {
            case "1":
                Coffee espresso = Coffee.ESPRESSO;
                consume(espresso);
                break;
            case "2":
                Coffee latte = Coffee.LATTE;
                consume(latte);
                break;
            case "3":
                Coffee cappuccino = Coffee.CAPPUCCINO;
                consume(cappuccino);
                break;
            default:
                break;
        }
    }

    void fill() {
        this.water += gainInputForFill("water");
        this.milk += gainInputForFill("milk");
        this.beans += gainInputForFill("beans");
        this.disposableCups += gainInputForFill("cups");
    }

    void take() {
        System.out.println("I gave you $" + (int) this.money);
        this.money = 0;
    }

    private void consume(Coffee coffee) {
        if (!CanMake(coffee)) {
            return;
        }
        this.water -= coffee.getWaterConsumption();
        this.milk -= coffee.getMilkConsumption();
        this.beans -= coffee.getBeansConsumption();
        this.disposableCups -= 1;
        this.money += coffee.getCost();
    }

    private boolean CanMake(Coffee coffee) {
        if (this.water < coffee.getWaterConsumption()) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (this.milk < coffee.getMilkConsumption()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (this.beans < coffee.getBeansConsumption()) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (this.disposableCups <= 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        System.out.println("I have enough resources, making you a coffee!");
        return true;
    }

    private int gainInputForFill(String supply) {
        switch (supply) {
            case "water":
                System.out.println("Write how many ml of water you want to add:");
                break;
            case "milk":
                System.out.println("Write how many ml of milk you want to add:");
                break;
            case "beans":
                System.out.println("Write how many grams of coffee beans you want to add:");
                break;
            case "cups":
                System.out.println("Write how many disposable cups you want to add:");
                break;
            default:
                break;
        }

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    // print machine's state
    @Override
    public String toString() {
        return "The coffee machine has:\n" +
                this.water + " ml of water\n" +
                this.milk + " ml of milk\n" +
                this.beans + " g of coffee beans\n" +
                this.disposableCups + " disposable cups\n" +
                "$" + (int) this.money + " of money";
    }
}

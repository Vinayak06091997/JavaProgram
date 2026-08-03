package DesignPattern;

/*
=========================================
Decorator Pattern
=========================================

Definition:
- Adds new functionality without modifying
  existing class.

Real Time Example:
- Coffee + Milk + Sugar
- Pizza Toppings

Interview Answer:
Decorator wraps an object and adds extra behavior.
=========================================
*/

interface Coffee {
    void make();
}

class BasicCoffee implements Coffee {

    public void make() {
        System.out.println("Basic Coffee");
    }
}

class MilkDecorator implements Coffee {

    private Coffee coffee;

    MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public void make() {
        coffee.make();
        System.out.println("Added Milk");
    }
}

public class Structural_DecoratorPattern {
    public static void main(String[] args) {

        Coffee coffee = new MilkDecorator(new BasicCoffee());

        coffee.make();
    }
}

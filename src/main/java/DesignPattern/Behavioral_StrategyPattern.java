package DesignPattern;

/*
==========================================
Strategy Design Pattern
==========================================

Definition:
- Different algorithms can be selected at runtime.

Real Time Example:
- Payment Methods
- Sorting
- Discount Calculation

Advantages:
- No if-else chain
- Easy to extend
- Follows Open/Closed Principle

Interview Answer:
Different behavior is encapsulated into different classes.

------------------------------------------
*/

interface Payment {
    void pay(int amount);
}

class CreditCardPayment implements Payment {

    public void pay(int amount) {
        System.out.println("Paid using Credit Card : " + amount);
    }
}

class UpiPayment implements Payment {

    public void pay(int amount) {
        System.out.println("Paid using UPI : " + amount);
    }
}

public class Behavioral_StrategyPattern {

    public static void main(String[] args) {

        Payment payment = new UpiPayment();

        payment.pay(500);
    }
}

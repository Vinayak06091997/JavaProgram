package DesignPattern;

/*
=========================================
Adapter Design Pattern
=========================================

Definition:
- Converts one interface into another.
- Makes incompatible classes work together.

Real Time Example:
- Legacy API Integration
- Third-party Library
- Payment Gateway Adapter

Interview Answer:
Adapter acts as a bridge between two incompatible interfaces.
=========================================
*/

interface Charger {
    void charge();
}

class OldCharger {
    public void oldCharge() {
        System.out.println("Charging using old charger");
    }
}

class ChargerAdapter implements Charger {

    private OldCharger oldCharger = new OldCharger();

    public void charge() {
        oldCharger.oldCharge();
    }
}

public class Structural_AdapterPattern {
    public static void main(String[] args) {

        Charger charger = new ChargerAdapter();
        charger.charge();

    }
}

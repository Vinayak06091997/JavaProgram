package DesignPattern;

/*
=========================================
Template Method Pattern
=========================================

Definition:
- Parent class defines algorithm.
- Child class implements specific steps.

Real Time Example:
- Report Generation
- File Processing

Interview Answer:
Common workflow stays same,
specific steps change in subclasses.
=========================================
*/

abstract class Process {

    public final void execute() {
        start();
        process();
        end();
    }

    void start() {
        System.out.println("Start");
    }

    abstract void process();

    void end() {
        System.out.println("End");
    }
}

class PaymentProcess extends Process {

    void process() {
        System.out.println("Processing Payment");
    }
}

public class Behavioral_TemplateMethodPattern {

    public static void main(String[] args) {

        Process p = new PaymentProcess();
        p.execute();

    }
}

package DesignPattern;

/*
=========================================
Command Pattern
=========================================

Definition:
- Encapsulates a request as an object.

Real Time Example:
- Remote Control
- Undo/Redo
- Queue Processing

Interview Answer:
Request becomes an object that can
be executed later.
=========================================
*/

interface Command {
    void execute();
}

class Light {

    void on() {
        System.out.println("Light ON");
    }
}

class LightCommand implements Command {

    private Light light = new Light();

    public void execute() {
        light.on();
    }
}
public class Behavioral_CommandPattern {

    public static void main(String[] args) {

        Command cmd = new LightCommand();

        cmd.execute();

    }
}

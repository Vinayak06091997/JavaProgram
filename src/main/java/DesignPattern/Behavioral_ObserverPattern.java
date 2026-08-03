package DesignPattern;

/*
==========================================
Observer Design Pattern
==========================================

Definition:
- One object notifies multiple dependent objects.

Real Time Example:
- YouTube Subscribers
- Stock Price Updates
- Weather App
- Email Notifications

Advantages:
- Loose coupling
- Automatic notification

Interview Answer:
When one object changes, all observers are informed.

------------------------------------------
*/

interface Observer {
    void update(String message);
}

class User implements Observer {

    private String name;

    User(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received : " + message);
    }
}

public class Behavioral_ObserverPattern {

    public static void main(String[] args) {

        Observer user1 = new User("John");
        Observer user2 = new User("David");

        user1.update("New Video Uploaded");
        user2.update("New Video Uploaded");
    }
}

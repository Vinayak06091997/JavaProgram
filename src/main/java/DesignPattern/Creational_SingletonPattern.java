package DesignPattern;


import java.util.logging.Logger;

/*
==========================================
Singleton Design Pattern
==========================================

Definition:
- Ensures only one object of a class is created.
- Provides a global access point.

Real Time Example:
- Logger
- Database Connection
- Configuration Manager
- Cache

Interview Answer:
Use Singleton when only one instance should exist
throughout the application.

Advantages:
- Saves memory
- Shared object
- Easy access

------------------------------------------
*/
public class Creational_SingletonPattern {

    private final Logger logger = Logger.getLogger(Creational_SingletonPattern.class.getName());
     private static Creational_SingletonPattern instance ;

        // Private constructor prevents object creation
        private Creational_SingletonPattern() {}

        // Global access method
        public static Creational_SingletonPattern getInstance() {
            if (instance == null) {
                instance = new Creational_SingletonPattern();
            }
                return instance;
        }

        public void show() {
            System.out.println("Singleton Object");
        }

        public static void main(String[] args) {

            Creational_SingletonPattern s1 = Creational_SingletonPattern.getInstance();
            Creational_SingletonPattern s2 = Creational_SingletonPattern.getInstance();

            s1.show();

            // true because both references point to same object
            System.out.println(s1 == s2);
        }
    }

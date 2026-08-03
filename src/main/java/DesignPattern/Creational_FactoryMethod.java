package DesignPattern;

/*
==========================================
Factory Design Pattern
==========================================

Definition:
- Factory creates objects instead of using new keyword
  directly in client code.

Real Time Example:
- Payment Gateway
- Notification Service
- Vehicle Creation

Advantages:
- Loose coupling
- Easy to add new objects
- Cleaner code

Interview Answer:
Factory decides which object should be created.
Client doesn't know the creation logic.

------------------------------------------
*/

    interface Animal {
        void sound();
    }

    class Dog implements Animal {

        public void sound() {
            System.out.println("Dog Bark");
        }
    }

    class Cat implements Animal {

        public void sound() {
            System.out.println("Cat Meow");
        }
    }

    class AnimalFactory {

        public Animal getAnimal(String type) {

            if(type.equalsIgnoreCase("dog"))
                return new Dog();

            return new Cat();
        }
    }

    public class Creational_FactoryMethod {

        public static void main(String[] args) {

            AnimalFactory factory = new AnimalFactory();

            Animal animal = factory.getAnimal("dog");

            animal.sound();
        }
    }

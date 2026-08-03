package DesignPattern;

/*
==========================================
Builder Design Pattern
==========================================

Definition:
- Used to create complex objects step by step.

Real Time Example:
- Employee
- User
- Pizza
- Mobile

Advantages:
- Readable code
- Avoids constructor with many parameters

Interview Answer:
Useful when object has many optional fields.

------------------------------------------
*/

class Employee {

    private String name;
    private int age;

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Employee setAge(int age) {
        this.age = age;
        return this;
    }

    public void display() {
        System.out.println(name + " " + age);
    }
}

public class Creational_BuilderPattern {

    public static void main(String[] args) {

        Employee emp = new Employee()
                .setName("Rahul")
                .setAge(30);

        emp.display();
    }
}

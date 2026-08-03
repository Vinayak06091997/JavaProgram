package DesignPattern;

/*
=========================================
Proxy Pattern
=========================================

Definition:
- Controls access to another object.

Real Time Example:
- Security
- Lazy Loading
- Spring AOP

Interview Answer:
Proxy performs checks before calling
the actual object.
=========================================
*/

interface Internet {
    void connect();
}

class RealInternet implements Internet {

    public void connect() {
        System.out.println("Connected");
    }
}

class ProxyInternet implements Internet {

    private RealInternet internet = new RealInternet();

    public void connect() {
        System.out.println("Checking permission...");
        internet.connect();
    }
}

public class Structural_ProxyPattern {
    public static void main(String[] args) {

        Internet internet = new ProxyInternet();
        internet.connect();

    }
}

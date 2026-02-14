package Practice;

import java.util.LinkedList;

public class Demo1 {
     static void main(String[] args) {
        System.out.println("This is Demo1 class in Practice package.");
        LinkedList<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("World");
        System.out.println("LinkedList contents: " + list);
        list.remove();

        System.out.println("LinkedList after removal: " + list);
    }
}

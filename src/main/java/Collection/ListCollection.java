package Collection;

import java.util.*;

public class ListCollection {
     static void main(String[] args) {
//---------------------------- ArrayList------------------------------
        System.out.println("---------------------------- ArrayList------------------------------");
        List<String> arrayList =new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("World");
        System.out.println("ArrayList contents: " + arrayList);
        arrayList.remove("Hello");
        System.out.println("ArrayList after removal: " + arrayList);
        for(String str:arrayList)
        {
           System.out.println(str);
        }


//---------------------------- LinkedList ----------------------------
        System.out.println("---------------------------- LinkedList ----------------------------");
        List<Integer>  linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("LinkedList contents: " + linkedList);
        linkedList.remove(1);
        System.out.println("LinkedList after removal: " + linkedList);
        for(Integer variable:linkedList)
        {
           System.out.println(variable);
        }
//----------------------------- Vector ------------------------------
        System.out.println("----------------------------- Vector ------------------------------");
        List<String> vector=new Vector<>();
        vector.add("vinayak");
        vector.add("Nimbaragi");
        vector.add("MLP");
        System.out.println("Vector contents: " + vector);
        vector.remove("Nimbaragi");
        System.out.println("Vector after removal: " + vector);
        for(String str:vector)        {
           System.out.println(str);
        }

//-----------------------------Stack--------------------------------
        System.out.println("-----------------------------Stack--------------------------------");
        Stack<String> stack = new Stack<>();
        stack.push("vinayak");
        stack.push("Nimbaragi");
        stack.push("MLP");
        System.out.println("stack content:"+stack);
        stack.pop();
        System.out.println("stack after pop:"+stack);
        stack.removeFirst();
        for(String str:stack)
        {
           System.out.println(str);
        }
    }
}

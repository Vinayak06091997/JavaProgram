package Collection;

import java.util.*;

public class QueueCollection {
    public static void main(String[] args) {
// -----------------ArrayDeque-----------------------------------------
        Queue<String> queue = new ArrayDeque<>();
        queue.add("vinayak");
        queue.add("Nimbaragi");
        queue.add("MLP");
        System.out.println("Queue content:" + queue);
        queue.remove();
        System.out.println("Queue after removal:" + queue);
        for (String str : queue) {
            System.out.println(str);
        }
//-----------------------PriorityDeque---------------------------------
        Queue<Integer> queue1=new PriorityQueue<>();
        queue1.add(5);
        queue1.add(2);
        queue1.add(8);
        System.out.println("PriorityQueue content:"+queue1);
        queue1.remove();
        System.out.println("PriorityQueue after removal:"+queue1);
        queue1.add(1);
        System.out.println("PriorityQueue after adding 1:"+queue1);
        queue1.add(0);
        System.out.println("PriorityQueue after adding 0:"+queue1);
    }
}
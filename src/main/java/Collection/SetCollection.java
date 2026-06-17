package Collection;

import java.util.*;

public class SetCollection {
    public static void main(String[] args){

        //-------------------------------HashSet---------------------------------
        System.out.println("-------------------------------Hashset----------------------------------");
        Set<String> set = new HashSet<>();
        set.add("vinayak");
        set.add("Nimbaragi");
        set.add("MLP");
        System.out.println("HashSet content:" + set);



        //-------------------------------LinkedHashSet---------------------------
        System.out.println("-------------------------------LinkedHashSet---------------------------");
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("vinayak");
        linkedHashSet.add("Nimbaragi");
        linkedHashSet.add("MLP");
        System.out.println("LinkedHashSet content:" + linkedHashSet);



        //------------------------------ TreeSet---------------------------------
        System.out.println("-------------------------------TreeSet---------------------------------");
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("vinayak");
        treeSet.add("Nimbaragi");
        treeSet.add("MLP");
        treeSet.add("A");
        System.out.println("TreeSet content:" + treeSet);
    }
}

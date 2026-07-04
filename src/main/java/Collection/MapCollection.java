package Collection;

import java.util.*;

public class MapCollection {

    public static void main(String[] args)
    {
        //--------------------------------HashMap---------------------------------
        System.out.println("----------------------HashMap------------------------");
        Map<String,Integer> hashMap= new HashMap<>();
        hashMap.put("vinayak",4123);
        hashMap.put("MLP",1332);
        hashMap.put("Nimbaragi1",1234);
        hashMap.put("Nimbaragi",01234);
        System.out.println("HashMap content:"+hashMap);

        for(Map.Entry<String,Integer> entry: hashMap.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("problem");
        hashMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(e->{
            System.out.println("Key: "+e.getKey()+" Value: "+e.getValue());
        });

        //--------------------------LinkedHashList-------------------------------------
        System.out.println("----------------------LinkedHashMap------------------------");
        Map<String,Integer> linkedHashMap= new LinkedHashMap<>();
        linkedHashMap.put("vinayak",123);
        linkedHashMap.put("MLP",1332);
        linkedHashMap.put("Nimbaragi",1234);
        System.out.println("LinkedHashMap content:"+linkedHashMap);
        for(Map.Entry<String,Integer> entry:linkedHashMap.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }


        //----------------------------TreeHashMap---------------------------------------
        System.out.println("----------------------TreeHashMap------------------------");
        Map<String,Integer> treeHashMap= new TreeMap<>();
        treeHashMap.put("vinayak",123);
        treeHashMap.put("MLP",1332);
        treeHashMap.put("Nimbaragi",1234);
        treeHashMap.put("A",12345);
        System.out.println("TreeHashMap content:"+treeHashMap);
        for(Map.Entry<String,Integer> entry:treeHashMap.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        //-----------------------------HashTable ----------------------------------------
        System.out.println("-----------------------HashTable------------------------");
        Map<String,Integer> hashTable= new Hashtable<>();
        hashTable.put("vinayak",123);
        hashTable.put("MLP",1332);
        hashTable.put("Nimbaragi",1234);
        System.out.println("HashTable content:"+hashTable);

        //-------------------------------Problems----------------------------------------
        String str="vinayaaankak";
        Map<Character,Integer> frequencyMap=new HashMap<>();
        for(char c:str.toCharArray()){
            frequencyMap.put(c,frequencyMap.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> entry:frequencyMap.entrySet()){
            System.out.println("Character: "+entry.getKey()+" Frequency: "+entry.getValue());
        }
    }
}

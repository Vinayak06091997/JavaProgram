package DSA;

import java.util.HashMap;
import java.util.Map;

public class ImportantProgram {
    public static void main(String[] args){

        //------------------------------------ two sum problem---------------------------------------
        //input num=[2,7,11,15]
        //target =9
        //output[0,1]

        // BFM
        int[] num={2,7,11,15};
        int target=9;
        for(int i=0;i<num.length;i++)
        {
            for(int j=i+1;j< num.length;j++)
            {
                if(num[i]+num[j]==target)
                {
                    System.out.println("["+i+","+j+"]");
                }
            }
        }

        // Optimized solution using HashMap
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<num.length;i++)
        {
            int complement=target-num[i];
            if(map.containsKey(complement))
            {
                System.out.println("["+map.get(complement)+","+i+"]");
            }
            map.put(num[i],i);
        }
    }
}

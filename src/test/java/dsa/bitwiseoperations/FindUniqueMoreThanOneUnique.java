package dsa.bitwiseoperations;

import java.util.*;

public class FindUniqueMoreThanOneUnique {
    public static void main (String [] args) {
        int[] arr = {1, 2, 2, 3, 4, 5, 4, 4, 4, 5};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        System.out.println(map);
        System.out.println(result);
        System.out.println(37 & 4);
    }
}

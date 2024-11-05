package org.algorithm.map;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {

        List<String> groupAnagram = new ArrayList<>();
        groupAnagram.add("eat");
        groupAnagram.add("tea");
        groupAnagram.add("tan");
        groupAnagram.add("ate");
        groupAnagram.add("nat");
        groupAnagram.add("bat");

        Map<String, List<String>> anagramMap = new HashMap<>();


        for (String str : groupAnagram) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);

            anagramMap.putIfAbsent(sorted, new ArrayList<>());
            anagramMap.get(sorted).add(str);
        }
        for (String key : anagramMap.keySet()) {
            System.out.println("Key: " + key + ".......... Value: " + anagramMap.get(key));
        }
        System.out.println();

        System.out.println(anagramMap);

    }
}

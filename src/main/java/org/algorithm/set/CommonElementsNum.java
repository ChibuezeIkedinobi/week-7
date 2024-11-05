package org.algorithm.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonElementsNum {
    public static void main(String[] args) {

        int[] array1 = {1,2,3,4,5};
        int[] array2 = {4,5,6,7,8};

        Set<Integer> set1 = new HashSet<>();
        for (int num1 : array1) {
            set1.add(num1);
        }

        Set<Integer> commonElement = new HashSet<>();
        for (int num2 : array2) {
            if (set1.contains(num2)) {
                commonElement.add(num2);
            }
        }

        System.out.println(commonElement);
    }
}

package org.algorithm.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonElements {
    public static void main(String[] args) {

        String input = "This is a test This test is only a test";

        String[] words = input.split(" ");

        Set<String> unique = new HashSet<>(Arrays.asList(words));

        System.out.println(unique);


    }
}

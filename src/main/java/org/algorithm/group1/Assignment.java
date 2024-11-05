package org.algorithm.group1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment {
    public static void main(String[] args) {

        String input = "barfoothefoobarman";
        String[] words = {"foo", "bar"};

        List<Integer> result = new ArrayList<>();

        int wordCount = words.length;
        int wordLength = words[0].length();
        int totalLength = 6;


        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {  //looping thru foo and bar
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }


        for (int i = 0; i <= input.length() - totalLength; i++) {
            Map<String, Integer> seenWords = new HashMap<>();

            int j = 0;
            while (j < wordCount) {
                int wordStart = i + j * wordLength;
                String word = input.substring(wordStart, wordStart + wordLength);

                if (wordMap.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);

                    if (seenWords.get(word) > wordMap.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }

            if (j == wordCount) {
                result.add(i);
            }
        }

        System.out.println(result);
    }
}



//    Substring with Concatenation of All Words

//    You are given a string s and an array of strings words. All the strings of words are of the same length.

//        A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

//        • For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings.
//        "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
//        Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

//        Example 1:
//        Input: s = "barfoothefoobarman", words = ["foo","bar"]     s = 17
//        Output: [0,9]
//        Explanation:
//        The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
//        The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

//        Example 2:
//        Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//        Output: []
//        Explanation:
//        There is no concatenated substring.

//        Example 3:
//        Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//        Output: [6,9,12]


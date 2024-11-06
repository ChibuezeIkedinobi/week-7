package org.algorithm;


/*•Word Substitution with Synonyms
        •Given a dictionary of synonyms where each entry pairs a word with its synonym

        (e.g., {"happy": "joyful", "sad": "unhappy", "fast": "quick"}), and a sentence,

        replace each word in the sentence with its synonym if it exists in the dictionary.
        If a word has multiple synonyms, choose the one with the shortest length.
       If no synonym is found for a word, keep the word as it is.


        Example 1:
        Input:
        dictionary = {"happy": "joyful", "sad": "unhappy", "fast": "quick"}
        sentence = "I am very happy but sometimes sad"
        Output:
        "I am very joyful but sometimes unhappy"

        Example 2:
        Input:
        dictionary = {"happy": "joyful", "joyful": "happy", "quick": "fast"} sentence = "The fast runner is happy and joyful"
        Output:
        "The quick runner is happy and happy"
*/


import java.util.HashMap;
import java.util.Map;

public class Solutions {

    public String replaceWithSynonyms(Map<String, String> dictionary, String sentence) {

        Map<String, String> map = new HashMap<>(dictionary);

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (map.containsKey(word)) {
                words[i] = map.get(word);
            }
        }

        return String.join(" ", words);
    }
// O(n) time complexity
// O(1)  space complexity
    public static void main(String[] args) {
        Solutions solution = new Solutions();

        Map<String, String> dictionary1 = new HashMap<>();
        dictionary1.put("happy", "joyful");
        dictionary1.put("sad", "unhappy");
        dictionary1.put("fast", "quick");

        String sentence1 = "I am very happy but sometimes sad";
        System.out.println(solution.replaceWithSynonyms(dictionary1, sentence1));


        Map<String, String> dictionary2 = new HashMap<>();
        dictionary2.put("happy", "joyful");
        dictionary2.put("joyful", "happy");
        dictionary2.put("quick", "fast");

        String sentence2 = "The fast runner is happy and joyful";
        System.out.println(solution.replaceWithSynonyms(dictionary2, sentence2));

    }
}






package org.algorithm.weeklyAssesment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Assessment {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> parentSet = new HashSet<>(dictionary);

        String[] texts = sentence.split(" ");

        for (int i = 0; i < texts.length; i++) {
            String t = texts[i];
            String replacement = t;

            for (int j = 1; j <= t.length(); j++) {
                String head = t.substring(0, j);
                if (parentSet.contains(head)) {
                    replacement = head;
                    break;
                }
            }
            texts[i] = replacement;
        }
        return String.join(" ", texts);
    }

    public static void main(String[] args) {
        Assessment solution = new Assessment();

        List<String> dictionary1 = Arrays.asList("run", "walk", "swim");
        String sentence1 = "running walking swimmer are common exercises";
        System.out.println(solution.replaceWords(dictionary1, sentence1));

        List<String> dictionary2 = Arrays.asList("play", "jump", "code");
        String sentence2 = "playing jumped coder is fun";
        System.out.println(solution.replaceWords(dictionary2, sentence2));
    }
}
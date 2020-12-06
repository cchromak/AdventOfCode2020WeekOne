package com.company;

import java.util.*;

public class Questionnaire {

    public int totalYes (List<String> answerList) {
        int count = 0;
        for (String line: answerList) {
            Set<Character> letters = new HashSet<>();
            for (char l: line.substring(0, line.length() - 1).toCharArray()) {
                if (!letters.contains(l)) {
                    letters.add(l);
                }
            }
            count += letters.size();
        }
        return count;
    }

    public int groupYes (List<String> answerList) {
        int count = 0;
        for (String line: answerList) {
            HashMap<Character, Integer> map = new HashMap<>();
            int total = Integer.parseInt(String.valueOf(line.charAt(line.length() - 1)));
            String currLine = line.substring(0, line.length() - 1);
            for (char letter: currLine.toCharArray()) {
                map.put(letter, map.getOrDefault(letter, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (total == entry.getValue()) {
                    count++;
                }
            }
        }
        return count;
    }
}

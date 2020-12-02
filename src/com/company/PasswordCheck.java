package com.company;

import java.util.List;

public class PasswordCheck {

    public int passwordCheckAtIndex (List<String> passwordList) {
        int count = 0;
        for (String password: passwordList) {
            String[] passwordSplit = password.split(" ");
            String[] numbers = passwordSplit[0].split("-");
            char letter = passwordSplit[1].charAt(0);
            String word = passwordSplit[2];
            int low = Integer.parseInt(numbers[0]) - 1;
            int high = Integer.parseInt(numbers[1]) - 1;
            if ((word.charAt(low) == letter && word.charAt(high) != letter) ||
                    (word.charAt(low) != letter && word.charAt(high) == letter)) {
                count++;
            }
        }
        return count;
    }

    public int passwordCheckBetweenIndex (List<String> passwordList) {
        int count = 0;
        for (String password: passwordList) {
            String[] passwordSplit = password.split(" ");
            String[] numbers = passwordSplit[0].split("-");
            int curr = 0;
            for (char l: passwordSplit[2].toCharArray()) {
                if (l == passwordSplit[1].charAt(0)) curr++;
            }
            if (curr >= Integer.parseInt(numbers[0]) && curr <= Integer.parseInt(numbers[1])) count++;
        }
        return count;
    }

}

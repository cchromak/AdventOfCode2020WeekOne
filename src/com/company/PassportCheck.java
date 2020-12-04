package com.company;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PassportCheck {

    public int passportCheckMissingCidOk (List<String> passportList) {
        int count = 0;
        for(String word: passportList) {
            String[] passportArray = word.split( " ");
            Arrays.sort(passportArray);
            if (passportArray.length == 8 || (passportArray.length == 7 && passportArray[1].charAt(0) != 'c')) {
                count++;
            }
        }
        return count;
    }

    public int passportCheck (List<String> passportList) {
        int count = 0;
        String[] eyeColorArray = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
        List<HashMap<String, String>> passportMapList = new LinkedList<>();
        for (String passport: passportList) {
            String[] passportArray = passport.split(" ");
            HashMap<String, String> currentPassport = new HashMap<>();
            for(String data: passportArray) {
                String[] keyValue = data.split(":");
                currentPassport.put(keyValue[0], keyValue[1]);
            }
            passportMapList.add(currentPassport);
        }
        for(HashMap<String, String> passport: passportMapList) {
            int byr = -1;
            int iyr = -1;
            int eyr = -1;
            boolean hcl = false;
            boolean ecl = false;
            boolean pid = false;
            String height = new String();
            int hgtInt = -1;
            String hgtMeasure = new String();
            if (passport.containsKey("byr")) byr = Integer.parseInt(passport.get("byr"));
            if (passport.containsKey("iyr")) iyr = Integer.parseInt(passport.get("iyr"));
            if (passport.containsKey("eyr")) eyr = Integer.parseInt(passport.get("eyr"));
            if (passport.containsKey("hcl")) hcl = passport.get("hcl").charAt(0) == '#' && passport.get("hcl").length() == 7 && passport.get("hcl").matches("^[a-f0-9#]*$");
            if (passport.containsKey("ecl")) ecl = Arrays.asList(eyeColorArray).contains(passport.get("ecl"));
            if (passport.containsKey("pid")) pid = passport.get("pid").length() == 9;
            if (passport.containsKey("hgt")) height = passport.get("hgt");
            if (height.length() > 3) {
                hgtMeasure = height.substring(height.length() - 2);
                hgtInt = Integer.parseInt(height.substring(0, height.length() - 2));
            }
            boolean hgt = false;
            if (hgtMeasure.equals("cm") && hgtInt >= 150 && hgtInt <= 193) {
                hgt = true;
            } else if (hgtMeasure.equals("in") && hgtInt >= 59 && hgtInt <= 76){
                hgt = true;
            }
            if (byr >= 1920 && byr <= 2002 && iyr >= 2010 && iyr <= 2020 &&
                    eyr >= 2020 && eyr <= 2030 && hcl && ecl && pid && hgt) {
                count++;
            }
        }
        return count;
    }
}

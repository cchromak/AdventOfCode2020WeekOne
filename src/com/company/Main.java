package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //day 1
        List<Integer> numberList = new ArrayList<>();
        try {
            File myObj = new File("accountNumbers.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                numberList.add(Integer.parseInt(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Integer[] numberArray = new Integer[numberList.size()];
        numberArray = numberList.toArray(numberArray);
        SumOf2020ThenProduct twoSum = new SumOf2020ThenProduct();
        SumOf2020ThenProduct threeSum = new SumOf2020ThenProduct();
        System.out.println("==== Day 1 ==== Week 1 ====");
        System.out.println("Two sum answer: " + twoSum.SumOf2020ThenProduct(numberArray, 2020));
        System.out.println("Three sum answer: " + threeSum.SumOf2020ThenProduct3Sum(numberArray, 2020));
        System.out.println("===========================");


//        day 2
        List<String> passwordList = new LinkedList<>();
        try {
            File myObj = new File("passwords.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                passwordList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("==== Day 2 ==== Week 1 ====");
        PasswordCheck check = new PasswordCheck();
        System.out.println("Valid pw between index: " + check.passwordCheckBetweenIndex(passwordList));
        System.out.println("Valid pw at exactly one index: " + check.passwordCheckAtIndex(passwordList));
        System.out.println("===========================");

//        day3

        List<char[]> hillList = new LinkedList<>();
        try {
            File myObj = new File("TreeHill.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                hillList.add(data.toCharArray());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        TreeHill oneDownThreeRight = new TreeHill();
        System.out.println("==== Day 3 ==== Week 1 ====");
        System.out.println("Tree hit 1 slope count: " + oneDownThreeRight.oneDownThreeRightTreeCount(hillList));
        System.out.println("Tree hit 5 slopes product count: " + oneDownThreeRight.productOfAllSlopes(hillList));
        System.out.println("===========================");


        List<String> passportsList = new LinkedList<>();
        try {
            File myObj = new File("passports.txt");
            Scanner myReader = new Scanner(myObj);
            String dataCompleted = new String();
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              if (data.length() != 0) {
                  dataCompleted += data;
              } else {
                  passportsList.add(dataCompleted.trim());
                  dataCompleted = "";
              }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

//        PassportCheck passportCheck = new PassportCheck();
//        System.out.println("==== Day 4 ==== Week 1 ====");
//        System.out.println("Easy Passport Check Valid Count: " + passportCheck.passportCheckMissingCidOk(passportsList));
//        System.out.println("Hard Passport Check Valid Count: " + passportCheck.passportCheck(passportsList));
//        System.out.println("===========================");

//        Day 5
        List<String> planeSeatList = new LinkedList<>();
        try {
            File myObj = new File("planeseats.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                planeSeatList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        PlaneSeat planeSeat = new PlaneSeat();
        System.out.println("==== Day 5 ==== Week 1 ====");
        System.out.println("The largest seat ID: " + planeSeat.planeSeatHighestId(planeSeatList));
        System.out.println("Your seat ID: " + planeSeat.findYourSeat(planeSeatList));
        System.out.println("===========================");

//        Day 6
        List<String> answerList = new LinkedList<>();
        try {
            File myObj = new File("answer.txt");
            Scanner myReader = new Scanner(myObj);
            String dataCompleted = new String();
            int count = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.length() != 0) {
                    count++;
                    dataCompleted += data;
                } else {
                    dataCompleted.trim();
                    dataCompleted += Integer.toString(count);
                    answerList.add(dataCompleted);
                    dataCompleted = "";
                    count = 0;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Questionnaire question = new Questionnaire();
        System.out.println("==== Day 6 ==== Week 1 ====");
        System.out.println("Number of yes' per group: " + question.totalYes(answerList));
        System.out.println("Number of group yes: " + question.groupYes(answerList));
        System.out.println("===========================");


    }



}


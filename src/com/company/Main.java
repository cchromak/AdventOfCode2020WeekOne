package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
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

    }

}


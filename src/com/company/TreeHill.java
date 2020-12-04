package com.company;

import java.util.List;

public class TreeHill {

    public int oneDownThreeRightTreeCount (List<char[]> treeList) {
        int count = 0;
        int rightIndex = 3;
        int matrixWidth = treeList.get(0).length;
        for (int i = 1; i < treeList.size() ; i++) {
            if (treeList.get(i)[rightIndex] == '#') {
                count++;
            }
            rightIndex += 3;
            rightIndex %= matrixWidth;
        }

        return count;
    }

    public long productOfAllSlopes (List<char[]> treeList) {
        long countOne = 0;
        long countTwo = 0;
        long countThree = 0;
        long countFour = 0;
        long countFive = 0;
        int rightIndexOne = 1;
        int rightIndexTwo = 3;
        int rightIndexThree = 5;
        int rightIndexFour = 7;
        int rightIndexFive = 1;
        int matrixWidth = treeList.get(0).length;
        for (int i = 1; i < treeList.size() ; i++) {
            if (treeList.get(i)[rightIndexOne] == '#') {
                countOne++;
            }
            if (treeList.get(i)[rightIndexTwo] == '#') {
                countTwo++;
            }
            if (treeList.get(i)[rightIndexThree] == '#') {
                countThree++;
            }
            if (treeList.get(i)[rightIndexFour] == '#') {
                countFour++;
            }
            rightIndexOne += 1;
            rightIndexOne %= matrixWidth;
            rightIndexTwo += 3;
            rightIndexTwo %= matrixWidth;
            rightIndexThree += 5;
            rightIndexThree %= matrixWidth;
            rightIndexFour += 7;
            rightIndexFour %= matrixWidth;

        }

        for (int i = 2; i < treeList.size() ; i += 2) {
            if (treeList.get(i)[rightIndexFive] == '#') {
                countFive++;
            }
            rightIndexFive += 1;
            rightIndexFive %= matrixWidth;
        }

        return countOne * countTwo * countThree * countFour * countFive;
    }
}

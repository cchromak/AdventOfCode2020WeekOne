package com.company;

import java.util.List;

public class PlaneSeat {

    public int planeSeatHighestId (List<String> planeSeatList) {
        int largestId = 0;
        for(String seat: planeSeatList) {
            int leftPoint = 0, rightPoint = 127;
            int leftColumn = 0, rightColumn = 7;
            for (int i = 0; i <= 6; i++){
                if (seat.charAt(i) == 'F') {
                    rightPoint -= ((rightPoint - leftPoint) / 2 + 1);

                } else {
                    leftPoint += ((rightPoint - leftPoint) / 2 + 1);
                }
            }
            for (int i = 7; i <= 9; i++) {
                if (seat.charAt(i) == 'L') {
                    rightColumn -= ((rightColumn - leftColumn) / 2 + 1);
                } else {
                    leftColumn += ((rightColumn - leftColumn) / 2 + 1);
                }
            }
            int currId = leftPoint * 8 + leftColumn;
            if (currId >  largestId) {
                largestId = currId;
            }
        }
        return largestId;
    }

    public int findYourSeat (List<String> planeSeatList) {
        int[] seatArray = new int[953];
        for(String seat: planeSeatList) {
            int leftPoint = 0, rightPoint = 127;
            int leftColumn = 0, rightColumn = 7;
            for (int i = 0; i <= 6; i++){
                if (seat.charAt(i) == 'F') {
                    rightPoint -= ((rightPoint - leftPoint) / 2 + 1);

                } else {
                    leftPoint += ((rightPoint - leftPoint) / 2 + 1);
                }
            }
            for (int i = 7; i <= 9; i++) {
                if (seat.charAt(i) == 'L') {
                    rightColumn -= ((rightColumn - leftColumn) / 2 + 1);
                } else {
                    leftColumn += ((rightColumn - leftColumn) / 2 + 1);
                }
            }
            int currId = leftPoint * 8 + leftColumn;
            seatArray[currId - 1]++;
        }

        for (int i = 0; i < seatArray.length - 2; i++) {
            int b = i + 1, c = b + 1;
            if (seatArray[i] == 1 && seatArray[b] == 0 && seatArray[c] == 1) {
                return b + 1;
            }
        }
        return -1;
    }
}

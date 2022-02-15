import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    public int minArea(char[][] image, int x, int y) {
        // write your code here
        int n = image.length;
        int m = image[0].length;

        int up = checkAllClear(image, 0, false) ? findLast(0, x, image, false) : -1;
        /*
        int low = findLast(x, n - 1, image, false);
        int left = checkAllClear(image, 0, true) ? findLast(0, y, image, true) : -1;
        int right = findLast(y, m - 1, image, true);
        System.out.print(up + " " + low+ " "+ left+ " "+ right+" \n");

         */

        return 0;//(low - up) * (right - left);
    }

    private int findLast(int start, int end, char[][] image,  boolean CoR) {
        boolean sample = checkAllClear(image, start, CoR);
        System.out.println("Checking sample: "+sample);
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (checkAllClear(image, mid, CoR)== sample) {
                System.out.println("star "+start + " = mid "+mid);
                start = mid;

            }
            else {
                System.out.println("end "+end + " = mid "+mid);
                end = mid;
            }
        }
        System.out.println("Checking end "+end + " with sample: "+(checkAllClear(image, end, CoR) == sample));
        if (checkAllClear(image, end, CoR) == sample) {
            System.out.println("Returning end: "+end);
            return end;
        }
        System.out.println("Returning start: "+start);
        return start;

    }
    //CoR in this file means a column of array or a row of array is foucsed on
    private char getValue(int index, int i, boolean CoR, char[][] image) {
        return CoR ? image[i][index] : image[index][i];
    }

    private boolean checkAllClear(char[][] image, int index, boolean CoR) {
        //char sample = getValue(index, 0, CoR, image);
        int maxLength = CoR ? image.length : image[0].length;
        for (int i = 0; i < maxLength; i++) {
            //if (index == 6) System.out.println("i now: "+i);
            if (getValue(index, i, CoR, image) != '0') {
                return false;
            }
        }
        return true;


    }
}
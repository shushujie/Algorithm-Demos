import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // write your code here
        int upper = FindUpperBoundary(0, x, image);
        int lower = FindLowerBoundary(x, image.length - 1, image);
        int left = FindLeftBoundary(0, y, image);
        int right =FindrightBoundary(y, image[0].length - 1, image);
        System.out.println(upper);
        System.out.println(lower);
        System.out.println(left);
        System.out.println(right);

        int area = (lower - upper + 1) * (right - left + 1);
        return area;
    }

    public int FindUpperBoundary(int S, int E, char[][] image) {
        int start = S;
        int end = E;
        boolean val;


        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            val = Rowreader(image, mid);

            if (val == true) {
                end = mid;
            }

            else {start = mid;}

        }
        return Rowreader(image, start) ? start : end;
    }

    public int FindLowerBoundary(int S, int E, char[][] image) {
        int start = S;
        int end = E;
        boolean val;


        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            val = Rowreader(image, mid);

            if (val == true) {
                start = mid;
            }

            else {end = mid;}

        }
        return Rowreader(image, end) ? end : start;
    }

    public int FindLeftBoundary(int S, int E, char[][] image) {
        int start = S;
        int end = E;
        boolean val;


        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            val = Colreader(image, mid);

            if (val == true) {
                end = mid;
            }

            else {start = mid;}

        }
        return Colreader(image, start) ? start : end;
    }

    public int FindrightBoundary(int S, int E, char[][] image) {
        int start = S;
        int end = E;
        boolean val;


        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            val = Colreader(image, mid);

            if (val == true) {
                start = mid;
            }

            else {end = mid;}

        }
        return Colreader(image, end) ? end : start;
    }


















    public boolean Rowreader(char[][] image, int CurX) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[CurX][i] == '1') {
                return true;
            }
        }

        return false;

    }
    public boolean Colreader(char[][] image, int CurY) {
        System.out.println("printing current CurY: " + CurY);
        for (int i = 0; i < image.length; i++) {
            if (image[i][CurY] == '1') {
                return true;
            }
        }

        return false;

    }


}
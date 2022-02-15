import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        //exception when A is not valid
        if (A == null || A.length == 0) {
            return -1;
        }
        //using binary search. Though I can find the rotation point I'm using one time bs to slove
        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int middle = start + (end - start) / 2;
            System.out.println("now middle: "+middle);

            if (A[middle] >= A[start]) {
                System.out.println("now A[start]: "+A[start]  + " = A[middle]: "+A[middle]);
                if (A[start] <= target && target <= A[middle] ) {
                    end = middle;
                    System.out.println("now end: "+ end + " = middle: "+middle);
                }

                else {
                    start = middle;
                    System.out.println("now start: "+ start + " = middle: "+middle);
                }
            }

            else {
                if (A[middle] <= target && target <= A[end] ) {
                    start = middle;
                }

                else {
                    end = middle;
                }
            }
        }
        System.out.println(start);
        System.out.println(end);


        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;

    }
}
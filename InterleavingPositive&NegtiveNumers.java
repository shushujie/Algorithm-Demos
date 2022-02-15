import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        // write your code here
        int pos = 0, neg = 0;
        for (int a : A) {
            if (a > 0) {
                pos++;
            }
        }
        neg = A.length - pos;
        int flag = 1;
        if (pos < neg) {
            flag = -1;
        }
        System.out.println("The flag is : " + flag);
        int left = 0, right = A.length - 1;
        while (left <= right) {
            while (left <= right && (A[left] * flag) > 0) {
                left++;
            }
            while (left <= right && (A[right] * flag) < 0) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }

        System.out.println("This is after partition: "+ Arrays.toString(A));

        interleave(A);

    }

    private void interleave(int[] A) {
        int left = 1, right = A.length - 1;
        if (A.length % 2 == 0) {
            right = A.length - 2;
        }

        while (left <  right ) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left += 2;
            right-= 2;
        }
    }


}
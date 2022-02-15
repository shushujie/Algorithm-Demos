import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void moveZeroes(int[] nums) {
        System.out.println("This is the beginning: "+ Arrays.toString(nums));
        int left = 0, right = 0;
       // int cnt = 0;

        while (right < nums.length) {


            if (nums[right] != 0 ) {
                System.out.println("This is the current: "+ Arrays.toString(nums));
                if (left != right) nums[left] = nums[right];
                left++;

            }
            right++;


        }

        for (left = left; left < nums.length; left++) {
            nums[left] = 0;
        }


    }
}
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public int removeDuplicates(int[] nums) {
        System.out.println(Arrays.toString(nums));
        if (nums.length == 0) return 0;

        int count = 0;
        int j = 1;
        int i = 0;
        while (i < nums.length) {


            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }

            if (j >= nums.length) {
                break;
            }
            i++;

            nums[i] = nums[j];
            System.out.println(Arrays.toString(nums));
            count++;


        }

        return count + 1;
    }
}
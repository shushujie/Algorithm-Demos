import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] twoends = {-1, -1};
        if (nums == null || nums.length == 0) return twoends;
        twoends[0] = findOneEnd(nums, target, true);
        if (nums[ twoends[0] ]!= target) {
            return new int[] {-1, -1};
        }
        twoends[1] = findOneEnd(nums, target, false);
        return twoends;
    }

    private int findOneEnd(int[] nums, int target, boolean leftEnd) {
        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
                System.out.println("moving start, now start is "+ start);
            }
            else if (nums[mid] > target) {
                end = mid;
                System.out.println("moving end");
            }
            else {
                if (leftEnd) {
                    end = mid;
                    System.out.println("found! and moving start, now start is " + start);

                }
                else {
                    start = mid;
                    System.out.println("found! and moving end");

                }
            }
        }

        if (leftEnd) {
            System.out.println("returning leftmost position");
            return (nums[start] == target) ? start : end;
        }
        else {
            System.out.println("returning rightmost position");
            return (nums[end] == target) ? end : start;
        }



    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int a = 0; a < nums.length; a++) {
            System.out.println("Processing 3 sum of a = : "+ a);
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }

            for (int b = a + 1; b < nums.length; b++) {
                System.out.println("Processing 3 sum of b = : "+b);
                if (b > (a + 1) && nums[b] == nums[b - 1]) {
                    continue;
                }

                TwoSum(nums, a, b, target - (nums[a] + nums[b]), ans);
            }
        }

        return ans;
    }
    private void TwoSum(int[] nums, int a, int b, int target2, List<List<Integer>> ans) {
        System.out.println("Processing two sum: ");

        int left = b + 1, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            System.out.println("This time two sum is: "+ sum);
            if (sum < target2) {left++;}
            else if (sum > target2) {right--;}
            else {
                List<Integer> quadruple = new ArrayList<>();
                quadruple.add(nums[a]);
                quadruple.add(nums[b]);
                quadruple.add(nums[left]);
                quadruple.add(nums[right]);
                ans.add(quadruple);
                left++;
                right--;
                while (left < right && nums[left - 1] == nums[left]) {
                    left++;
                }
                while (left < right && nums[right + 1] == nums[right] ) {
                    right--;
                }
            }
        }



    }
}

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }

        List<Integer> tempElementList = new ArrayList<>();
        dfs(nums, 0, tempElementList, ans);

        return ans;
    }
    //write dfs to find all subsets
    public void dfs(int[] nums,
                    int index,
                    List<Integer> tempElementList,
                    List<List<Integer>> ans) {
        //System.out.println("nums has length: "+ nums.length);
        System.out.println("Now index is: "+ index);

        if (index == nums.length ) {
            System.out.println("Now adding: "+ tempElementList);
            ans.add(new ArrayList<Integer>(tempElementList) );
            System.out.println("And the ans becomes: "+ ans);
            return;
        }

        //递归的拆解
        tempElementList.add(nums[index]);
        System.out.println("Now index-sub1 is: "+ index);
        dfs(nums, index + 1, tempElementList, ans );

        //tempElementList.add(nums[index]);
        tempElementList.remove(tempElementList.size() - 1);
        System.out.println("Now index-sub2 is: "+ index);
        dfs(nums, index + 1, tempElementList, ans );

    }
}
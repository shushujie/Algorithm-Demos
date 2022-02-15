class Solution {
    public int[] longestPalindrome(int[] s) {
        int[] nums = s;
        // write your code here
        Quicksort(nums, 0, nums.length - 1);

        return nums ;

    }




    private void Quicksort(int[] nums, int start, int end) {

        if(start >= end) return;

        int pivot = nums[(start + end)/2];
        int left = start, right = end;

        while (left <= right) {
            while (left <= right && nums[left] < pivot ) {
                left++;
            }

            while (left <= right && nums[right] > pivot) {
                right--;
            }

            if(left <= right) {
                int temp;
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }

        Quicksort(nums, start, right);
        Quicksort(nums, left, end);


    }



}
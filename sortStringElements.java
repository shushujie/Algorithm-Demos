import java.util.Arrays;

class Solution {
    public char[] longestPalindrome(char[] s) {
        char[] cArray = s;
        // write your code here
        System.out.println(cArray.length);

        quicksort(cArray, 0, cArray.length - 1);

        return cArray ;

    }




    private void quicksort(char[] cArray, int start, int end) {
        if (start >= end) return;

        int left = start, right = end;


        int mid = (start + end) / 2;
        char pivot = cArray[mid];
        if (start == 0 && end == cArray.length - 1) {
            System.out.println("before while loop, mid is "+mid +", and pivot is "+pivot );
        }

        while (left <= right) {
            while(left <= right && cArray[left] < pivot){
                left++;
                if (start == 0 && end == cArray.length - 1) {
                    System.out.println("Now in the loop, mid is: "+mid + " and the char at mid is: " + cArray[mid]);
                }
            }
            while (left <= right && cArray[right] > pivot) {
                right--;
            }
             if (left <= right) {
                 char temp;
                 temp = cArray[left];
                 cArray[left] = cArray[right];
                 cArray[right] = temp;

                 left++;
                 right--;
             }
        }
        quicksort(cArray,start, right);
        quicksort(cArray,left, end);



    }


}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int targetID = 0;
        List<Integer> ans = new ArrayList<>();
        if (arr.length <= k){
            for (int i = 0; i < arr.length; i++) {
                ans.add(arr[i]);
            }
            return  ans;
        }

        //find target element
        targetID = findClosetElement(arr, x);

        //find k nums around target

        int lSide = targetID - 1, rSide = targetID + 1;

        for (int i = 1; i < k; i++) {
            if (lSide < 0) {
                lSide = -1;
                break;
            }
            if (rSide > arr.length - 1) {
                lSide = arr.length - k -1;
                break;
            }

            if ( Math.abs(arr[lSide] - x) <= Math.abs(arr[rSide] - x)) {
                System.out.println("picked on the left at "+ lSide+" And the element is " + arr[lSide]);

                lSide--;
            }
            else {
                System.out.println("picked on the right at "+ rSide+" And the element is " + arr[rSide]);

                rSide++;
            }
        }


        for (int i = 1; i <= k; i++) {
            lSide++;
            ans.add(arr[lSide]);
        }
        return ans;
    }













    private int findClosetElement(int[] arr, int x) {
        int start = 0, end = arr.length - 1;
        int targetID = 0;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > x) {
                end = mid;
            }
            else if (arr[mid] <= x) {
                start = mid;
            }
        }

        if (start == end - 1) {
            if (Math.abs(arr[start] - x) <= Math.abs(arr[end] - x)) {
                targetID = start;
            }
            else {
                targetID = end;
            }

        }
        System.out.println("This is tarID: "+ targetID+" And the element is " + arr[targetID]);
        return targetID;

    }

    //private boolean LeftIsCloser(int[] arr, int k, int x) {

    //}


}
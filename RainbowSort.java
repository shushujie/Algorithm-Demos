import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        System.out.println("Now : "+ Arrays.toString(colors));
        // 时间复杂度分析
        // K=1 --> O(1)
        // K=2 --> O(N)
        // K=3 --> O(N)
        // K=N --> O(NlgN)
        // 时间复杂度为O(NlgK)
        // Quick Sort + Merge Sort
        if(colors == null || colors.length==0)
            return;

        int N = colors.length;
        rainbowSort(colors, 0, N-1, 1, k);
    }

    private void rainbowSort(int []colors, int left, int right, int colorS, int colorE){
        if(colorS == colorE)
            return;

        if(left >= right)
            return;

        int colorM = colorS+(colorE-colorS)/2;
        int l = left;
        int r = right;

        while(l<=r){
            while(l<=r && colors[l]<colorM){
                l++;
                System.out.println("Now left++ after: "+ Arrays.toString(colors));
            }
            while(l<=r && colors[r]>colorM){
                r--;
                System.out.println("Now right-- after: "+ Arrays.toString(colors));
            }
            if(l<=r){
                // swap
                int temp = colors[l];
                colors[l] = colors[r];
                colors[r] = temp;
                l++;
                r--;
                System.out.println("Now swap after: "+ Arrays.toString(colors));
            }
        }

        rainbowSort(colors, left, r, colorS, colorM);
        rainbowSort(colors, l, right, colorM+1, colorE);
    }
}
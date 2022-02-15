import java.util.*;


public class example
{
    public static void main(String args[]){




    /*  Solution sl =  new Solution();
      boolean ha;
      ha = sl.validPalindrome(mystring);
      System.out.println(ha);*/

        int[][] array= {
                {1, 5},
                {13, 15},
                {12, 16},
                {11, 85} };

        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }

    }

}


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public void duplicateZeros(int[] arr) {
        int countZeroes = 0;
        int totalZeroes = 0;
        int extraZeroes = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                totalZeroes++;
            }

        }
        for (int i = 0; i + countZeroes < n - 1; i++) {
            if (arr[i] == 0) {
                if (i + countZeroes == n - 1) {

                    break;

                }
                countZeroes++;
            }
        }
        extraZeroes = totalZeroes - countZeroes;
        System.out.println("Total Number of 0es is : "+ totalZeroes);
        System.out.println("Duplication Number of 0es is : "+ countZeroes);
        System.out.println("Extra Number of 0es is : "+ extraZeroes);
        int steps = 0;
        int overlooksteps = 0;




        int index = n - 1 - countZeroes;
        int j = n - 1;
        for (index = index; index >= 0; index--) {

            arr[j] = arr[index];
            System.out.println("Now moving : "+ index + "th " + arr[index ] + " to " + j + "th. " + arr[j] + "." );
            if(arr[index] == 0) {

                if (index < n - 1 - countZeroes) {
                    j--;
                    if (j >= 0) {arr[j] = arr[index];
                        System.out.println("Repeating 0 : "+ index + "th " + arr[index ] + " to " + j + "th. " + arr[j] + "." );
                        steps++;
                        System.out.println("Has duplicated: "+ steps + "Zero." );
                    }

                }
                else {
                    overlooksteps++;
                    System.out.println("Over looked: "+ overlooksteps + "Zero." );
                }


            }
            j--;
        }


    }
}
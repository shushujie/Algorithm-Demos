import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    /**
     * @param s: a string
     * @param k: a integer
     * @return: return a integer
     */
    public int characterReplacement(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        int n = s.length();


        //using two pointers

        int left = 0;
        int right = left;
        HashMap<Character, Integer> map = new HashMap<>();

        for (left = 0; left < n; left++) {
            //left must point to the majority char or it should proceed toward lef
            //right keep moving forward to check if the objective substring can still expand: by 1||2
            //by 1, find another majority char or 2, can still replace another char

            char c_left = s.charAt(left);
            int majority = map.getOrDefault(c_left, 0);

            while (right < n && right - left - majority <= k) {//check the length if we have
                //positions to replace, because have the kth char to replace may not be the end of the
                //longest substring
                char c = s.charAt(right);
                map.put(c, map.getOrDefault(c, 0) + 1);
                majority = getMajority(s, left, right, map);

                System.out.println("left now at: "+ left +" And now proceeding right from: " + right +" to: " + (right + 1));
                right++;
            }
            System.out.println("Now majority is: " + majority);



            if (right - left - majority <= k) {

                result = Math.max(right - left, result);
                System.out.println("Now length is: "+ (right - left) + ". And result is: " + result);
            }

            else if (right - left - majority >= k + 1) {
                System.out.println("Now length is: "+ (right - left - 1) + ". And result is: " + result);
                result = Math.max(right - left - 1, result);
            }

            //reduce left character
            map.put(c_left, map.get(c_left) - 1);
            if (right >= n) {
                break;
            }
        }

        return result;

    }

    public int getMajority(String s, int start, int end, HashMap<Character, Integer> map) {
        int index = start;
        int count = 0;
        while (index <= end) {
            char c = s.charAt(index);
            count = Math.max(map.getOrDefault(c, 0), count);
            index++;
        }

        return count;
    }
}
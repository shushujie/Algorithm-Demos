import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;


public class example
{
    public static void main(String args[]){

      Solution sl =  new Solution();
      
      
        String s = "12:40:22AM";
        System.out.println( timeConversion(s) );



    }
    public static String timeConversion(String s) {
        // Write your code here
        int n = s.length();
        String keep = s.substring(2, n - 2);
        String head = s.substring(0, 2);
        String tail = s.substring(n - 2, n);
        String finalStr = "";

        boolean needConv = false;
        if (tail.equals("PM") && !head.equals("12") ) {
            needConv = true;
        }
        if (tail.equals("AM") &&  head.equals("12") ) {
            needConv = true;
        }


        if(needConv) {
            if (head.equals("12")){
                head = "00";}
            else{
                int num = Integer.parseInt(head);
                num += 12;
                //num = num % 24;
                head = Integer.toString(num);
            }
        }

        finalStr = head + keep;
        return finalStr;
    }



}


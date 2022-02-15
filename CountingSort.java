import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;


public class example
{
    public static void main(String args[]){

      Solution sl =  new Solution();
      
      
        String s = "63 25 73 1 98 " +
                "73 56 84 86 57 " +
                "16 83 8 25 81 " +
                "56 9 53 98 67 " +
                "99 12 83 89 80 " +
                "91 39 86 76 85 " +
                "74 39 25 90 59 " +
                "10 94 32 44 3 " +
                "89 30 27 79 46 " +
                "96 27 32 18 21";
        String[] arrTemp = s.split(" ");
        int n = arrTemp.length;

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Integer[] order = new Integer[100];
        for (int i = 0; i < order.length; i++) order[i] = 0;
        System.out.println(order[0]);
        order[0] = 1;
        System.out.println(order[0]);
        for (int a : arr) {
            if (order[a] == null) order[a]= 1;
            else  order[a] = order[a] + 1;
        }

        List<Integer> result = Arrays.asList(order);

        for (int a : result) System.out.println(a);

        //( Arrays.asList(order) ) ;



    }




}


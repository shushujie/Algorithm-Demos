import java.lang.reflect.Array;
import java.util.*;


//Definition for a point.
 class Point {
     int x;
      int y;
      Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
 }


public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        if(points == null || points.length == 0 || k == 0) {
            return new Point[0];
        }

        Comparator<Point> comp = Comparator
                .comparing((Point p) -> getDistance(p, origin))
                .thenComparingInt(p -> p.x)
                .thenComparingInt(p -> p.y);

        int start = 0, end = points.length - 1;


        quickSelect(comp,points, origin, k, start, end);


        Arrays.sort(points, 0, k - 1, comp);

        return Arrays.copyOf(points, k);

    }

    private Point quickSelect(Comparator<Point> comp, Point[] points, Point origin, int k, int start, int end) {
        if(start >= end) {// using k == 1 is wrong, will terminate prematurally
            System.out.println("k is : " +k);

            return points[start];
        }
        Point pivot = points[start + (end - start) / 2];

        int left = start, right = end;

        while (left <= right) {

            while (comp.compare(points[left], pivot) < 0 && left <= right) {
                left++;
            }
            while (comp.compare(points[right], pivot) > 0 && left <= right) {
                right--;
            }

            if(left <= right) {
                Point temp = points[left];
                points[left] = points[right];
                points[right] = temp;
                left++;
                right--;
            }
        }


        if (right + 1 - start >= k) {
            return quickSelect(comp, points, origin, k, start, right);
        }
        if (left + 1 - start <= k) {
            return quickSelect(comp, points, origin, k - (left - start), left, end);
        }

        return points[right + 1];



    }

    private int getDistance(Point p1, Point p2) {
        int distance = (p1.x - p2.x) * (p1.x - p2.x)
                + (p1.y - p2.y) * (p1.y - p2.y);

        return distance;
    }
}
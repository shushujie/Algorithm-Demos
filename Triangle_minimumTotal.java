import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        List<Integer> path = new ArrayList<>();
        int[][] visited = new int[triangle.length][triangle.length];


        int ans = dfs(0, 0, triangle, visited);

        return ans;

    }

    private int dfs(int x, int y, int[][] triangle, int[][] visited ) {//,List<Integer> path
        int levels = triangle.length;


        if(x < levels && visited[x][y] != 0) {
            return visited[x][y];
        }
        if (x == levels) {
            return 0;
        }


        //path.add(triangle[x][y]);
        //System.out.println("Adding ["+x+", " +y + "] = " + triangle[x][y]);
       // visited[x][y] = true;
        int left, right;

        if((x + 1) < levels && visited[x + 1][y] != 0) {
            left = visited[x + 1][y];
        }
        else { left = dfs(x + 1, y,  triangle, visited);
        }

        if((x + 1) < levels && visited[x + 1][y + 1] != 0) {
            right = visited[x + 1][y + 1];
        }
        else {
            right = dfs(x + 1, y + 1, triangle, visited);
        }


        //path.remove(path.size() - 1);

        int ans = Math.min(left, right) + triangle[x][y];
        visited[x][y] = ans;

        return ans;

    }
}
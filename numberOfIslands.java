import java.lang.reflect.Array;
import java.util.*;


public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        //with no need to return the indexes of element, just use HashSet to denote the visited elements.
        int result = 0;


        if (grid == null || grid.length == 0) {
            return result;
        }

        if (grid[0] == null || grid[0].length == 0) {
            return result;
        }
        int m = grid.length; //rows
        int n = grid[0].length; // columns
        System.out.println(" We have m as: " + m + " And n is: " +  n );
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> positionQue = new LinkedList<>();

        //moving matrix
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int start_position = 0; start_position < n * m; start_position++) {
            if (!grid[start_position / n][start_position % n] ||visited.contains(start_position)) {
                System.out.println(start_position / m + "" + start_position % m );
                continue;
            }
            positionQue.offer(start_position);
            visited.add(start_position);
            result++;

            while (!positionQue.isEmpty()) {
                int currentPosition = positionQue.poll();
                int x = currentPosition / n;
                int y = currentPosition % n;

                for(int i = 0; i < dx.length; i++) {
                    int next_x = x + dx[i];
                    int next_y = y + dy[i];
                    int next_position = next_x * n + next_y;

                    if (visited.contains(next_position) || next_x < 0 || next_x >= m || next_y < 0 || next_y >= n || !grid[next_x][next_y] ) {
                        continue;
                    }

                    positionQue.offer(next_position);
                    visited.add(next_position);
                }
            }


        }



        return result;
    }
}
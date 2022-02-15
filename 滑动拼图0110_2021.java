import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    /**
     * @param init_state: the initial state of chessboard
     * @param final_state: the final state of chessboard
     * @return: return an integer, denote the number of minimum moving
     */
    public static int minMoveStep(int[][] init_state, int[][] final_state) {
        // # write your code here
        //do bsf;
        //challenge 1:
        //the state is the bfs node;
        //the state can be represented by a string for sure;
        //Concider to hash visited node, the node is neighther a number or a string;
        //challenge 2:
        //build graph:
        //two neighboring states:
        //
        int rows = init_state.length, cols = init_state[0].length;

        Queue<String> que = new ArrayDeque<>();
        //Set<String> seen = new HashSet<>();
        Map<String, Integer> dist = new HashMap<>();

        String iniS = toString(init_state);
        String finS = toString(final_state);
        if(iniS.equals(finS)) return 0;

        que.offer(iniS);
        dist.put(iniS, 0);


        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int dis = -1;
        while (!que.isEmpty()) {
            String curr = que.poll();
            dis = dist.getOrDefault(curr, 0);

            if (curr.equals(finS)) {
                return dis;
            }


            int[][] matrix = toMtrx(curr, rows, cols);
            Point now0 = find0(matrix);

            for (int p = 0; p < 4; p++) {
                Point next0 = new Point(now0.x + dx[p], now0.y + dy[p] );
                if (next0.x < 0 || next0.x >= rows || next0.y < 0 || next0.y >= cols)
                    continue;

                int[][] newMtrx = new int[matrix.length][];
                for (int i = 0; i < matrix.length; i++) newMtrx[i] = matrix[i].clone();
                swap(now0, next0, newMtrx);
                String newStr = toString(newMtrx);

                if(dist.containsKey(newStr) ) continue;
                if (newStr.equals(finS)) return dist.getOrDefault(curr, 0) + 1;
                System.out.println("distance of "+ (dist.getOrDefault(curr, 0) + 1) + ": ");
                System.out.println("compare: "+newStr +" with final: "+ finS);
                que.add(newStr);
                dist.put(newStr, dist.getOrDefault(curr, 0) + 1);


            }



        }

        return -1;



    }
    public static void swap(Point nowP, Point nextP, int[][] matrix) {
        //int temp = matrix[nowP.x][nowP.y];
        matrix[nowP.x][nowP.y] = matrix[nextP.x][nextP.y];
        matrix[nextP.x][nextP.y] = 0;

    }

    public static Point find0(int[][] matrix) {
        Point ans = new Point(0, 0);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {ans.x = i; ans.y = j;break;}
            }


        }

        return ans;
    }

    public static String toString(int[][] state) {
        String str = "";
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++)
                str += ("" +state[i][j]);
        }
        return str;
    }

    public static int[][] toMtrx(String str, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int id = i * cols + j;
                char c = str.charAt(id);
                matrix[i][j] = c - '0';
            }
        }

        return matrix;
    }
}

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
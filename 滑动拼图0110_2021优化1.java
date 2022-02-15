import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    /**
     * @param init_state: the initial state of chessboard
     * @param final_state: the final state of chessboard
     * @return: return an integer, denote the number of minimum moving
     */
    public int minMoveStep(int[][] init_state, int[][] final_state) {
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
        int attempt = -1;
        while (!que.isEmpty()) {
            String curr = que.poll();
            System.out.println("current state of String: "+curr);
            int now0 = curr.indexOf('0');
            int nowX = now0 / 3, nowY = now0 % 3;
            for (int p = 0; p < 4; p++) {
                int newX = nowX + dx[p], newY = nowY + dy[p];
                int next0 = (newX * 3) + newY;

                if (newX < 0 || newX >= rows || newY < 0 || newY >= cols)
                    continue;

                String newStr = swapinString(now0, next0, curr);
                //for (int i = 0; i < matrix.length; i++) newMtrx[i] = matrix[i].clone();
                if(dist.containsKey(newStr) ) continue;
                attempt++;
                if (attempt > 85000) return -1;
                if (newStr.equals(finS)) return dist.getOrDefault(curr, 0) + 1;
                System.out.println("compare: "+newStr +" with final: "+ finS);
                que.add(newStr);
                dist.put(newStr, dist.getOrDefault(curr, 0) + 1);


            }



        }

        return -1;



    }
    public String swapinString(int now0, int next0, String curr) {

        int oldId = now0;
        int newId = next0;
        int big = oldId, small = newId;
        if (oldId < newId) {big = newId; small = oldId; }

        String pre = curr.substring(0, small);
        String mid = curr.substring(small + 1, big);
        //9 is string.length();
        String post = big + 1 > 9 ? "" : curr.substring(big + 1, 9);

        char Smallid = curr.charAt(small);
        char Bigid = curr.charAt(big);
        return pre + Bigid+ mid + Smallid + post;
        /*public String swapinString(int now0, int next0, String curr) {

        char[] chars = curr.toCharArray();
        chars[now0] = chars[next0];
        chars[next0] = '0';
        return new String(chars);
    }*/
    }

    public void swap(Point nowP, Point nextP, int[][] matrix) {
        matrix[nowP.x][nowP.y] = matrix[nextP.x][nextP.y];
        matrix[nextP.x][nextP.y] = 0;
    }

    public Point find0(int[][] matrix) {
        Point ans = new Point(0, 0);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {ans.x = i; ans.y = j;break;}
            }
        }

        return ans;
    }

    public String toString(int[][] state) {
        String str = "";
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++)
                str += ("" +state[i][j]);
        }
        return str;
    }

    public int[][] toMtrx(String str, int rows, int cols) {
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


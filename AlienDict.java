import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        // Write your code here
        //graph:
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray() ) {

                graph.put(c, new HashSet<Character>());
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            int size = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < size; j++) {
                if (words[i].charAt(j) == words[i + 1].charAt(j)) {
                    continue;
                }

                graph.get(words[i].charAt(j)).add(words[i + 1].charAt(j));
                //System.out.println("graph is getting neighbors in...");
            }

        }



        for (Character keynode : graph.keySet()) {
            indegree.put(keynode, 0);
        }

        int i = 0;
        for (Character keynode : graph.keySet()) {
            for (Character neighbor : graph.get(keynode) ) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
                i++;
                System.out.println("in-degree is getting things in... for the "+ i + "th time");

            }
        }
        for (Character c : indegree.keySet()){
        System.out.println("from the map of in-degree "+ c + " has indegree of " + indegree.get(c));}

        //add 0-indegree nodes

        // bsf

        Queue<Character> que =  new PriorityQueue<>();
        StringBuilder order = new StringBuilder();

        for (Character keynode : indegree.keySet()) {
            if (indegree.get(keynode) == 0) {
                que.offer(keynode);
                System.out.println("que is getting things in...");
                //order.append(keynode);
            }
        }

        while (!que.isEmpty()) {
            Character currentChar = que.poll();
            order.append(currentChar);

            for (Character neighbor : graph.get(currentChar)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    que.offer(neighbor);
                    //order.append(neighbor);
                }
            }


        }

        if (order.length() != indegree.size()) {
            return "";
        }

        return order.toString();

    }
}
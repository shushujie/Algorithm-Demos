import java.lang.reflect.Array;
import java.util.*;
/**

 * Definition of TreeNode:
         * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        //get path for forward and backward iterator
        Stack<TreeNode> forwardPath = getPath(root, target);
        Stack<TreeNode> backwardPath = new Stack<>();
        backwardPath.addAll(forwardPath);
        List<Integer> ans = new ArrayList<>();
        //adjust the last TreeNode element
        if (forwardPath.peek().val < target) {
            moveForward(forwardPath);
        }

        else {
            moveBackward(backwardPath);
        }


        //find k elements:

        for (int i = 1; i <= k; i++) {

            double leftDis = backwardPath.isEmpty() ? Double.MAX_VALUE : target - backwardPath.peek().val;
            double rightDis = forwardPath.isEmpty() ? Double.MAX_VALUE : forwardPath.peek().val - target;
            System.out.println("Now i has value: "+i);
            System.out.println("forward: "+forwardPath );
            System.out.println("backward: "+backwardPath);

            if (leftDis < rightDis) {
                ans.add(backwardPath.peek().val);
                moveBackward(backwardPath);
            }
            else {
                ans.add(forwardPath.peek().val);
                moveForward(forwardPath);
            }

        }

        return ans;

    }

    //getPath;
    public  Stack<TreeNode> getPath(TreeNode root, double target) {
        Stack<TreeNode> result = new Stack<>();
        while (root != null) {
            result.push(root);
            if (root.val >= target) {
                root = root.left;
            }
            else {
                root = root.right;
            }


        }

        return result;
    }

    //moveForwar
    public void moveForward(Stack<TreeNode> path) {
        TreeNode root = path.peek();
        if (root.right != null) {
            root = root.right;
            while (root != null) {
                path.push(root);
                root = root.left;
            }
        }
        else {
            root = path.pop();
            while (!path.isEmpty() && path.peek().left != root) {
                root = path.pop();
            }
        }
    }

    //movetosmaller
    public  void moveBackward(Stack<TreeNode> path){
        TreeNode root = path.peek();
        if (root.left != null) {
            root = root.left;
            while (root != null) {
                path.push(root);
                root = root.right;
            }
        }
        else {
            root = path.pop();
            while (!path.isEmpty() && path.peek().right != root) {
                root = path.pop();
            }
        }
    }


      public static class TreeNode {
          public int val;
          public TreeNode left, right;

          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }
      }





}
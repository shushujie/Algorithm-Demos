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
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    //Using quick select
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        HashMap<TreeNode, Integer> totalNodes = new HashMap<>();
        countNode(root, totalNodes);
        TreeNode ansNode = targeting(root, k, totalNodes);
        return ansNode.val;

    }

    public int countNode(TreeNode root, HashMap<TreeNode, Integer> totalNodes) {
        if (root == null) {
            totalNodes.put(root, 0);
            return 0;

        }

        int leftCount = countNode(root.left, totalNodes);
        int rightCount = countNode(root.right, totalNodes);

        int currentCount = leftCount + rightCount + 1;
        totalNodes.put(root, currentCount);
        return currentCount;

    }


    public TreeNode targeting(TreeNode root, int k, HashMap<TreeNode, Integer> totalNodes) {
        if (root == null) {return new TreeNode(-1);}
        int leftNodes = root.left == null ? 0 : totalNodes.get(root.left);

        if (leftNodes == k - 1) {
            return root;
        }
        if (leftNodes >= k) {
            return targeting(root.left, k, totalNodes);
        }



        return targeting(root.right, k - leftNodes - 1, totalNodes);
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
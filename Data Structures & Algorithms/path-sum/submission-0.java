/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> list =new ArrayList<>();
        return sumPath(root, list, targetSum);

    }

    boolean sumPath(TreeNode root, List<Integer> total,int targetSum) {
        if (root == null ) {
            return false;
        }

        total.add(root.val);

      
        if (root.left == null && root.right == null && total.stream().mapToInt(Integer::intValue).sum() == targetSum ) {
            return true;
        }

        if (sumPath(root.left,total,targetSum)) {
            return true;
        }

        if (sumPath(root.right,total,targetSum)) {
            return true;
        }

        total.remove(total.size()-1);

        return false;
    }
}
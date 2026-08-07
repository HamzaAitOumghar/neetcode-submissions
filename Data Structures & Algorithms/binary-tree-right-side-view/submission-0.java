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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer> right = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Stack<Integer> temp = new Stack<>();

            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {

                TreeNode curr = queue.poll();

                if (curr != null) {
                    temp.push(curr.val);
                    queue.add(curr.left);
                    queue.add(curr.right);
                }

                
            }
            if(!temp.isEmpty()){
               right.add(temp.pop());
            }
        }

        return right;
    }
}

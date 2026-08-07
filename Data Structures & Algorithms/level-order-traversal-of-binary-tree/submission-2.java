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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        bfs(root, result);

        return result;
    }

    public void bfs(TreeNode root, List<List<Integer>> list) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
        
            List<Integer> temp = new ArrayList<>();
            int sizeQueue = queue.size();

            for (int i = 0; i <sizeQueue; i++) {
                TreeNode curr = queue.poll();

                if (curr != null) {
                    temp.add(curr.val);

                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }

            if (!temp.isEmpty()) {
                list.add(temp);
            }

        }
    }
}

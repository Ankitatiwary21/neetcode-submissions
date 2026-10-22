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

        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        que.offer(root);

        while (!que.isEmpty()) {
            int n = que.size();
            TreeNode rightNode = null;

            while (n-- > 0) {
                rightNode = que.poll();

                if (rightNode.left != null) {
                    que.offer(rightNode.left);
                }

                if (rightNode.right != null) {
                    que.offer(rightNode.right);
                }
            }

            result.add(rightNode.val);
        }

        return result;
    }
}

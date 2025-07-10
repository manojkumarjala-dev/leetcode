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
    public int goodNodes(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 1;
        while(q.size()>0){
            int size = q.size();
            while(size-->0){
                TreeNode node = q.poll();
                if(node.left!=null){
                    if(node.left.val>=node.val) ans++;
                    node.left.val = Math.max(node.left.val, node.val);
                    q.offer(node.left);
                }
                if(node.right!=null){
                    if(node.right.val>=node.val) ans++;
                    node.right.val = Math.max(node.right.val,node.val);
                    q.offer(node.right);
                }
            }
        }

        return ans;
        
    }
}
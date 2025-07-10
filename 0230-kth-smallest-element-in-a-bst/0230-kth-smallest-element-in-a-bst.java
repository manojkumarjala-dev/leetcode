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
    public void helper(TreeNode root, int k, int[] val,int[] ans){

        if(root.left!=null){
            helper(root.left,k,val,ans);
        }

        val[0]++;
        if(val[0]==k){
            ans[0] = root.val;
            return;
        }
        
        if(root.right!=null){
            helper(root.right,k,val,ans);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] val = new int[1];
        int[] ans = new int[1];

        val[0] = 0;

        helper(root,k,val,ans);

        return ans[0];

        
    }
}
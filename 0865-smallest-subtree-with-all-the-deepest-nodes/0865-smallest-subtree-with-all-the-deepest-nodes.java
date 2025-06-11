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
public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
    if (root == null) return null;

    if (root == a || root == b) {
        return root;
    }

    TreeNode left = LCA(root.left, a, b);
    TreeNode right = LCA(root.right, a, b);

    if (left != null && right != null) {
        return root;
    }

    if (left != null) return left;
    if (right != null) return right;

    return null;
}


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(q.size()>0){
            int size = q.size();
            while(size-->0){

                TreeNode cur = q.poll();
                map.put(cur,level);
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }

            }
            level++;
        }

        List<TreeNode> deepest = new ArrayList<>();
        for (Map.Entry<TreeNode, Integer> entry : map.entrySet()) {
            if (entry.getValue() == level-1) {
                deepest.add(entry.getKey());
            }
        }

        // compute LCA of all deepest nodes
        TreeNode lca = deepest.get(0);
        for (int i = 1; i < deepest.size(); i++) {
            lca = LCA(root, lca, deepest.get(i));
        }

        return lca;

    }
}
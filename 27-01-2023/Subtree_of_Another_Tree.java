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
    public boolean check(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        System.out.println(p.val+" "+q.val);
        if(p.val!=q.val) return false;
        boolean l = check(p.left,q.left);
        boolean r = check(p.right,q.right);
        if(l && r) return true;
        return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(check(root,subRoot)) return true;
        boolean l = isSubtree(root.left, subRoot);
        boolean r = isSubtree(root.right,subRoot);
        if(l || r) return true;
        return false; 
    }
}

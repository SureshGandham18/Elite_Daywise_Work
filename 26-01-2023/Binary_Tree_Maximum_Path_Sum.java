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
    int max=-100000;
    public int sum(TreeNode root){
        if(root==null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        if(max<(left+right+root.val)) max=left+right+root.val;
        
        return Math.max(0,Math.max(left,right)+root.val);
    }
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.val;
        sum(root);
        return max;
    }
}

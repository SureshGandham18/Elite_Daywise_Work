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
        if(root==null ) return false;
        targetSum -= root.val;
        System.out.println(targetSum);
        if(targetSum==0 && (root.left==null && root.right==null)) return true;
        boolean left=hasPathSum(root.left,targetSum);
        boolean right=hasPathSum(root.right,targetSum);
        if(left||right) return true;
        return false;
    }
}

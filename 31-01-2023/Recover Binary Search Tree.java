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
    TreeNode prev = null;
    TreeNode curr = null;
    TreeNode next = null;
    public void check(TreeNode root){
        if(root==null) return ;
        check(root.left);
        if(curr!=null && root.val<curr.val){
            if(prev==null)
                prev = curr;
            next = root;
        }
        curr = root;
        check(root.right);
        return ;
    }
    public void recoverTree(TreeNode root) {
        check(root);
        System.out.println(prev.val+" "+next.val);
        int temp = prev.val;
        prev.val = next.val;
        next.val = temp;
    }
}

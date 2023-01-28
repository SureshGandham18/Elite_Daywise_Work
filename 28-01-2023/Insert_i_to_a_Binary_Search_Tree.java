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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root==null) return node;
        
        TreeNode parent = null;
        TreeNode curr = root;
        while(curr!=null){
            parent = curr;
            if(val<curr.val) curr = curr.left;
            else curr = curr.right;
        }
        if(val<parent.val) parent.left = node;
        else parent.right = node; 
        return root;
    }
}

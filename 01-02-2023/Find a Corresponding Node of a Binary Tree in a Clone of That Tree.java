/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode res = null;
    public void inorder(TreeNode original,TreeNode cloned,TreeNode target){
        if(original==null) return;
        inorder(original.left,cloned.left,target);
        if(original==target) res = cloned;
        inorder(original.right,cloned.right,target);
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        inorder(original,cloned,target);
        return res;
    }
}

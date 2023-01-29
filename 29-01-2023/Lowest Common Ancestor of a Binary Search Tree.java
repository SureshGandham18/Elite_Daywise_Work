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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        TreeNode curr = root;
        while(curr!=null){
            System.out.println(curr.val+" "+p.val+" "+q.val);
            if(p.val==curr.val || q.val==curr.val) return curr;
            if((p.val<curr.val && q.val>curr.val) || (p.val>curr.val && q.val<curr.val)) return curr;
            else if(p.val<curr.val && q.val<curr.val) curr = curr.left;
            else curr = curr.right;
        }
        return curr;
    }
}

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
    int res = 0;
    public int fun(TreeNode root,int sum){
        if(root==null) return 0;
        sum = sum*10+ root.val;
        if(root.left==null && root.right==null){
            res += sum;
            return sum;
        }
        int l = fun(root.left,sum);
        int r = fun(root.right,sum);      
        return 0;
    }
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        fun(root,sum);
        return res;
    }

}

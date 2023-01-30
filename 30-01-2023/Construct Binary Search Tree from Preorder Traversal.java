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
    public TreeNode build(int[] preorder,int[] curr,int max){
        if(curr[0]==preorder.length||max<preorder[curr[0]]) return null;
        TreeNode node = new TreeNode(preorder[curr[0]]);
        curr[0]++;
        node.left = build(preorder,curr,node.val);
        node.right = build(preorder,curr,max);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int max = Integer.MAX_VALUE;
        int[] curr = {0};
        return build(preorder,curr,max);
    }
}

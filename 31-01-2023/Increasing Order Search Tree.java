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
    ArrayList<Integer> list = new ArrayList<>();
    public void build(TreeNode root) {
        if(root==null) return;
        build(root.left);
        list.add(root.val);
        build(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        build(root);
        TreeNode res = new TreeNode(list.get(0));
        TreeNode r = res;
        for(int i=1;i<list.size();i++){
            res.right = new TreeNode(list.get(i));
            res = res.right;
        }
        return r;
    }
}

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
    public void preorder(TreeNode root){
        if(root == null) return;
        TreeNode res = root;
        list.add(res.val);
        preorder(root.left);
        preorder(root.right);
    }
    public void flatten(TreeNode root) {
        if(root==null) return;
        preorder(root);
        TreeNode node = root;
        node.left = null;
        System.out.println(list);
        for(int i=1;i<list.size();i++){
            node.right = new TreeNode(list.get(i));
            node = node.right;
        }
    }
}

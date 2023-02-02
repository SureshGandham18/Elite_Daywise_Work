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
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public TreeNode build(ArrayList<Integer> list,int s,int e){
        if(e<s) return null;
        int k = (s+e)/2;
        TreeNode node = new TreeNode(list.get(k));
        node.left = build(list,s,k-1);
        node.right = build(list,k+1,e);
        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return build(list,0,list.size()-1);
    }
}

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
class BSTIterator{
    private Stack<TreeNode> stack = new Stack<>();
    boolean reverse = true;
    public BSTIterator(TreeNode root,boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }
    public boolean hasNext(){
        if(!stack.isEmpty()) return true;
        return false;
    }
    public int next(){
        TreeNode temp = stack.pop();
        if(reverse==false) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }    
    public void pushAll(TreeNode root){
        while(root!=null){
            stack.push(root);
            if(reverse==false) root = root.left;
            else root = root.right;
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTIterator left = new BSTIterator(root,false);
        BSTIterator right = new BSTIterator(root,true);
        int i = left.next();
        int j = right.next();
        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k) i=left.next();
            else j=right.next();
        }
        return false;
    }
}

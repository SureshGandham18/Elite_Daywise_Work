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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key && (root.left==null && root.right==null)) return null;
        if(root.val==key){
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
        }
        TreeNode parent = null;
        TreeNode curr = root;
        while(curr!=null){
            if(key==curr.val) break;
            parent = curr;
            if(key<curr.val) curr = curr.left;
            else curr = curr.right;
        }
        if(curr==null) return root;
        else if(curr.left!=null && curr.right!=null){
            TreeNode temp = curr.left;
            parent = curr;
            while(temp.right!=null){
                parent = temp;
                temp = temp.right;
            }
            int data = temp.val;
            temp.val = curr.val;
            curr.val =  data;
            curr = temp;
        }

        if(curr==null) return root;
        System.out.println(curr.val);
        System.out.println(parent.val);
        if(curr.val<parent.val){
            if(curr==parent.left){
                if(curr.left!=null) parent.left = curr.left;
                else parent.left = curr.right;
            }
            else {
                if(curr.left!=null) parent.right = curr.left;
                else parent.right = curr.right;
            }
            return root;
        }
        if(curr.val>parent.val){
            if(curr==parent.right){
                if(curr.left!=null) parent.right = curr.left;
                else parent.right = curr.right;
            }
            else {
                if(curr.left!=null) parent.left = curr.left;
                else parent.left = curr.right;
            }
            return root;
        }
        return root;
        
    }
}

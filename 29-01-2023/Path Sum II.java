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
    List<List<Integer>> res = new ArrayList<>();
    public void check(TreeNode root,ArrayList<Integer> list,int targetSum){
        if(root==null) return ;
        targetSum -= root.val;
        list.add(root.val);
        if(targetSum == 0 && root.left==null && root.right==null){ 
            res.add(list);
            return ;
        }
        check(root.left,new ArrayList<Integer>(list),targetSum);
        check(root.right,new ArrayList<Integer>(list),targetSum);
        return ;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> list = new ArrayList<>();
        check(root,list,targetSum);
        return res;      
    }
}

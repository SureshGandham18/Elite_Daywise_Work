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
    public TreeNode build(int[] nums,int s,int e){
        if(e<s) return null;
        int max = Integer.MIN_VALUE;
        int in = 0 ;
        for(int i=s;i<e+1;i++){
            if(max<nums[i]){
                max=nums[i];
                in=i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = build(nums,s,in-1);
        node.right = build(nums,in+1,e);
        return node;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length-1);   
    }
}

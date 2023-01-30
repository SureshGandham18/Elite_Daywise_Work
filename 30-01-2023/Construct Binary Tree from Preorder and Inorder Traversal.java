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
    // int[] curr = {0};
    public TreeNode construct(int[] preorder, int[] inorder,HashMap<Integer,Integer> inMap, int is,int ie,int[] curr){
        if(curr[0]==preorder.length || ie < is) return null;
        TreeNode node = new TreeNode(preorder[curr[0]]);
        int ip = inMap.get(preorder[curr[0]]);
        curr[0]++;
        node.left = construct(preorder,inorder,inMap,is,ip-1,curr);
        node.right = construct(preorder,inorder,inMap,ip+1,ie,curr);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inMap.put(inorder[i],i);
        int[] curr = {0};
        return construct(preorder,inorder,inMap,0,inorder.length-1,curr);
    }
}

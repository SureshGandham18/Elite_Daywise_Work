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
    ArrayList<String> reslist = new ArrayList<>();
    public String fun(TreeNode root,String list){
        if(root==null) return "";
        list += root.val+"->";
        if(root.left==null && root.right==null){
            reslist.add(list.substring(0,list.length()-2));
            return list;
        }
        System.out.println(list);
        String l = fun(root.left,list);
        System.out.println(list);
        String r = fun(root.right,list);      
        return "";
    }
    public List<String> binaryTreePaths(TreeNode root) {
        String list = "";
        fun(root,list);
        return reslist;
    }
}

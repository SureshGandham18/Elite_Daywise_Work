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
    HashMap<Integer,Integer> map = new HashMap<>();
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        inorder(root.right);
    }
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root);
        // System.out.println(map);
        int max = -1;
        for(Map.Entry<Integer,Integer> i:map.entrySet()){
            // System.out.println(max);
            // System.out.println(i.getValue());
            if(max<i.getValue()){
                max = i.getValue();
                list = new ArrayList<>();
                list.add(i.getKey());
            }
            else if(max==i.getValue())
                list.add(i.getKey());
        }
        // System.out.println(list);
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++) arr[i] = list.get(i);
        return arr;
    }
}

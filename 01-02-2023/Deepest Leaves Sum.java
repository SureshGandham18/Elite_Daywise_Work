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
    public void levelorder(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);
            }
            res.add(list);
        }
    }
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        levelorder(root);
        for(int i=0;i<res.get(res.size()-1).size();i++){
            sum += res.get(res.size()-1).get(i);
        }
        return sum;
    }
}

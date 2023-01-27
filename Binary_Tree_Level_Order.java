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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null) return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode k = queue.poll();
                list.add(k.val);
                if(k.left!=null){
                    queue.offer(k.left);
                }
                if(k.right!=null){
                    queue.offer(k.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}

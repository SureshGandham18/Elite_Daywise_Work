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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Double> list = new ArrayList<>();
        if(root==null) return list;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double avg = 0;
            for(int i=0;i<size;i++){
                TreeNode k = queue.poll();
                avg+=k.val;
                if(k.left!=null){
                    queue.offer(k.left);
                }
                if(k.right!=null){
                    queue.offer(k.right);
                }
            }
            avg = avg/size;
            list.add(avg);
        }
        return list;
    }
}

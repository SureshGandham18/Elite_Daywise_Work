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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> set = new LinkedList<>();
        queue.offer(root);
        set.offer(0);
        int c = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                int value = set.poll();
				if(!map.containsKey(value)){
                    TreeMap<Integer,PriorityQueue<Integer>> tmap = new TreeMap<>();
                    if(!tmap.containsKey(c)){
                        PriorityQueue<Integer> list = new PriorityQueue<>();
                        list.add(temp.val);
                        tmap.put(c,list);
                    }
                    else{
                        tmap.get(c).add(temp.val);
                        tmap.put(c,tmap.get(c));
                    }
                    map.put(value,tmap);
                }
                else{
                    TreeMap<Integer,PriorityQueue<Integer>> curr = map.get(value);
                    if(!curr.containsKey(c)){
                        PriorityQueue<Integer> list = new PriorityQueue<>();
                        list.add(temp.val);
                        curr.put(c,list);
                    }
                    else{
                        curr.get(c).add(temp.val);
                        curr.put(c,curr.get(c));
                    }
                    map.put(value,curr);
                }
                if(temp.left!=null){
                    queue.offer(temp.left);
                    set.offer(value-1);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                    set.offer(value+1);
                }
            }
            c++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> entry : map.entrySet()){
            TreeMap<Integer,PriorityQueue<Integer>> k = entry.getValue();
            list = new ArrayList<>();
            for(Map.Entry<Integer,PriorityQueue<Integer>> i:k.entrySet()){
                PriorityQueue<Integer> priq = i.getValue();
                int size = priq.size();
                for(int j=0;j<size;j++){
                    list.add(priq.poll());
                }
            }
            res.add(list);
        }
        return res;
    }
}

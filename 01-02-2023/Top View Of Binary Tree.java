import java.util.* ;
import java.io.*; 
/*********************************************

    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

*********************************************/


public class Solution {
    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        Queue<Integer> set = new LinkedList<>();
        queue.offer(root);
        set.offer(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                BinaryTreeNode temp = queue.poll();
                int value = set.poll();
                int dup = value;
				if(!map.containsKey(value))
                map.put(value,temp.val);
                if(temp.left!=null){
                    queue.offer(temp.left);
                    value--;
                    set.offer(value);
                }
                value = dup;
                if(temp.right!=null){
                    queue.offer(temp.right);
                    value++;
                    set.offer(value);
                }
            }
        }
		// System.out.println(map);
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
            list.add(entry.getValue());
        return list;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = "";
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return "";
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode k = queue.poll();
                if(k==null) s += "# ";
                else {
                    s+=k.val+" ";
                    if(k.left!=null) queue.offer(k.left);
                    else queue.offer(null);
                    if(k.right!=null) queue.offer(k.right);
                    else queue.offer(null);
                }                
            }
        }
        System.out.println(s);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String arr[] = data.split(" ");
        TreeNode res = new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(res);
        for(int i=1;i<arr.length-1;i=i+2){
            TreeNode k = queue.poll();
            if(!arr[i].equals("#")){
                TreeNode l = new TreeNode(Integer.parseInt(arr[i]));
                k.left = l;
                queue.add(l);
            }
            if(!arr[i+1].equals("#")){
                TreeNode r = new TreeNode(Integer.parseInt(arr[i+1]));
                k.right = r;
                queue.add(r);
            }
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

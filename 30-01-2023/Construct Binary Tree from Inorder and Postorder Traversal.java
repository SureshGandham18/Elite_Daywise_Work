class Solution {
    // int[] curr = {0};
    public TreeNode construct(int[] postorder, int[] inorder,HashMap<Integer,Integer> inMap, int is,int ie,int[] curr){
        if(curr[0]==-1 || ie < is) return null;
        TreeNode node = new TreeNode(postorder[curr[0]]);
        int ip = inMap.get(postorder[curr[0]]);
        curr[0]--;
        node.right = construct(postorder,inorder,inMap,ip+1,ie,curr);
        node.left = construct(postorder,inorder,inMap,is,ip-1,curr);
        
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inMap.put(inorder[i],i);
        int[] curr = {postorder.length-1};
        return construct(postorder,inorder,inMap,0,inorder.length-1,curr);
    }
}

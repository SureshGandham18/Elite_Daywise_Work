class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        Node curr = root;
        int ceil = Integer.MIN_VALUE;
        while(curr!=null){
            if(curr.data==key) return key;
            if(key<curr.data) {
                ceil = curr.data;
                curr = curr.left;
            }
            else curr = curr.right;
        }
        if(ceil==Integer.MIN_VALUE) return -1;
        return ceil;
    }
}

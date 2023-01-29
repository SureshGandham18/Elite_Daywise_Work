import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        int floor = Integer.MAX_VALUE;
        TreeNode<Integer> curr = root;
        while(curr!=null){
            if(curr.data==X) return X;
            if(X>curr.data){
                floor = curr.data;
                curr = curr.right;
            }
            else curr = curr.left;
        }
        return floor;
    }
}

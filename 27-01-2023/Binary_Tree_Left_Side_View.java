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

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null) return list;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode<Integer> k = queue.poll();
                if(i==0)
                    list.add(k.data);
                if(k.left!=null){
                    queue.offer(k.left);
                }
                if(k.right!=null){
                    queue.offer(k.right);
                }
            }
        }
        return list;
    }
}

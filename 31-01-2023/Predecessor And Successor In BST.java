import java.util.* ;
import java.io.*; 
/*************************************************************
    Following is the Binary Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/

import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		ArrayList<Integer> list = new ArrayList<>();
		BinaryTreeNode<Integer> curr = root;
		int s = -1;
		int p = -1;
		while(curr.data!=key){
			if(curr.data>key){
				s = curr.data;
				curr = curr.left;
			}
			else{
				p = curr.data;
				curr = curr.right;
			}
		}
		BinaryTreeNode<Integer> k = curr.right;
		
		while(k!=null){
			s = k.data;
			k = k.left;
		}
		BinaryTreeNode<Integer> l = curr.left;
		while(l!=null){
			p = l.data;
			l = l.right;
		}
		list.add(p);
		list.add(s);
		return list;
	}
}

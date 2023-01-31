/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode build(ArrayList<Integer> list,int i,int j){
        if(i>j) return null;
        int k;
        if((i+j)%2!=0)
            k = ((i+j)/2)+1;
        else k = ((i+j)/2);
        TreeNode res = new TreeNode(list.get(k));
        res.left = build(list,i,k-1);
        res.right = build(list,k+1,j);
        return res;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        
        return build(list,0,list.size()-1);
    }
}

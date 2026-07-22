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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<Integer> arr=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }
        int removeIndex=arr.size()-n;
        if (removeIndex == 0) {
            return head.next;
        }
        temp = head;
        for(int i=0;i<removeIndex-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
}
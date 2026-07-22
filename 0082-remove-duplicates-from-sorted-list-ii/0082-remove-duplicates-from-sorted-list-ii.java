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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
        ListNode result=new ListNode();
        ListNode temp2=result;
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        while(temp!=null){
            map.put(temp.val, map.getOrDefault(temp.val, 0) + 1);
            temp=temp.next;
        }
        for(int num:map.keySet()){
            if(map.get(num)==1){
                temp2.next=new ListNode(num);
                temp2=temp2.next;
            }
        }
        return result.next;
    }
}
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

        if(head == null) return null;
        
        ListNode dummy = new ListNode();

        dummy.next = head;

        ListNode first = head;

        ListNode second = head.next;

        while(first != null && second != null){
            while(second != null && first.val == second.val){
                second = second.next;
            }
            first.next = second;

            first = first.next;
            if(second != null){
               second = second.next; 
            }
            
        }

        return dummy.next;
    }
}
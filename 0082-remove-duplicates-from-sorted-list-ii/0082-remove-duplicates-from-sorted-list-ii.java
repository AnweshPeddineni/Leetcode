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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution{

  ListNode deleteDuplicates(ListNode head) {

      ListNode dummy = new ListNode(0);
      dummy.next = head;

      ListNode prev = dummy;
      ListNode curr = head;

      while (curr != null) {

        // If the current node is a duplicate
        if (curr.next != null && curr.val == curr.next.val) {

          // Move to the last duplicated node
          while (curr.next != null && curr.val == curr.next.val) {
            curr = curr.next;
          }

          // Skip the duplicated nodes
          prev.next = curr.next;
        } else {
          // We have found a unique node
          prev = prev.next;
        }

        // Move to the next node
        curr = curr.next;
      }

      return dummy.next;
  }

}
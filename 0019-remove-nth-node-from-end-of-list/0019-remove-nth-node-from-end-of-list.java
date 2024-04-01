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
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); // Dummy node to handle edge cases
        dummy.next = head; // Connect dummy node to head
        int length = 0; // To store the length of the list
        ListNode first = head; // Pointer to traverse the list and calculate length

        // Calculate the length of the list
        while (first != null) {
            length++;
            first = first.next;
        }

        length -= n; // Adjust length to find the node before the node to remove
        first = dummy; // Reset first to start from dummy node

        // Move first to the node before the node to remove
        while (length > 0) {
            length--;
            first = first.next;
        }

        // Skip the node to remove
        first.next = first.next.next;

        // Return the head of the modified list
        return dummy.next;
    }
}

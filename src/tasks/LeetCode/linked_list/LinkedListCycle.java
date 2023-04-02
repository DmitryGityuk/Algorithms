package tasks.LeetCode.linked_list;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

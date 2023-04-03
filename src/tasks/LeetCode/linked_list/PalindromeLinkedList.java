package tasks.LeetCode.linked_list;

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode secondHalf = getMiddleNode(head);
        ListNode secondHead = reverseList(secondHalf);
        ListNode leftCursor = head;
        ListNode rightCursor = secondHead;
        while (rightCursor != null) {
            if (leftCursor.val != rightCursor.val) {
                reverseList(secondHead);
                return false;
            }
            leftCursor = leftCursor.next;
            rightCursor = rightCursor.next;
        }
        reverseList(secondHead);
        return true;
    }

    private ListNode reverseList(ListNode middle) {
        ListNode prev = null;
        ListNode curr = middle;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }
}

package tasks.LeetCode.linked_list;

/**
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */

import java.util.HashSet;
import java.util.Set;

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
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (!set.contains(temp.val)) {
                set.add(temp.val);
            } else duplicate.add(temp.val);
            temp = temp.next;
        }

        ListNode newNode = new ListNode(-1);
        ListNode newHead = newNode;
        temp = head;

        while (temp != null) {
            if (!duplicate.contains(temp.val)) {
                newNode.next = temp;
                newNode = newNode.next;
            }
            temp = temp.next;
        }
        newNode.next = null;
        return newHead.next;
    }
}

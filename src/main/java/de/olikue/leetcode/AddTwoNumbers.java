package de.olikue.leetcode;

public class AddTwoNumbers {
    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = 0;
        if (l1 != null) {
            value += l1.val;
        }
        if (l2 != null) {
            value += l2.val;
        }
        if (l1.next == null && l2.next == null) {
            if (value > 9) {
                return new ListNode(value % 10, new ListNode(value / 10));
            } else {
                return new ListNode(value);
            }
        }
        if (l1.next == null) {
            if (value > 9) {
                return new ListNode(value % 10, addTwoNumbers(l2.next, new ListNode(value / 10)));
            } else {
                return new ListNode(value, l2.next);
            }
        } else if (l2 != null && l2.next == null) {
            if (value > 9) {
                return new ListNode(value % 10, addTwoNumbers(l1.next, new ListNode(value / 10)));
            }
            return new ListNode(value, l1.next);
        } else {

            if (value > 9) {
                return new ListNode(value % 10, addTwoNumbers(addTwoNumbers(l1.next, new ListNode(value / 10)), l2.next));
            }

            return new ListNode(value, addTwoNumbers(l1.next, l2.next));
        }

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

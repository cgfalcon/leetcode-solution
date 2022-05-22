package org.hellofalcon.leetcode;

/**
 * @author chugang.cg
 * @create - 2022/5/14.
 */
public class SortListNode {

    class ListNode {
        private int val;
        private ListNode next;

        ListNode() { }

        ListNode(int value) { this.val = value; }
        ListNode(int value, ListNode next) { this.val=value; this.next = next;}
    }

    public ListNode sortList(ListNode head) {
        ListNode tmp = head;
        ListNode prev = null;
        ListNode cur = head.next;
        ListNode endNode;

        // find a place to insert
        while (cur != null && tmp.val < cur.val) {
            prev = cur;
            cur = cur.next;
        }

        // insert node
        head = tmp.next;
        tmp.next = cur;
        if (prev != null) {
            prev.next = tmp;
        }

        return head;
    }

}


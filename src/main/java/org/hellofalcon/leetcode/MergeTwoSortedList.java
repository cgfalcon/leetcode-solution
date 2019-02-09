package org.hellofalcon.leetcode;

import org.hellofalcon.leetcode.common.ListNode;

/**
 * 21. Merge Two Sorted Lists
 *
 * @author - chugang.cg
 * @create - 2019/2/9
 */
public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            // append
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return head.next;

    }

    public static void main(String[] args) {
        MergeTwoSortedList mt = new MergeTwoSortedList();

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));


        ListNode listNode = mt.mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }


}

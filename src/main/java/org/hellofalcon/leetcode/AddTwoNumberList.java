package org.hellofalcon.leetcode;

import org.hellofalcon.leetcode.common.ListNode;

/**
 * @author chugang.cg
 * @create - 2022/5/22.
 */
public class AddTwoNumberList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int adder = 0;
        ListNode head = l1;
        ListNode prev = null;

        while (l1 != null && l2 != null) {
            int tmpSum = l1.val + l2.val + adder;
            l1.val = tmpSum % 10;
            adder = tmpSum / 10;

            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }


        if (l1 == null && l2 != null) {
            if (adder == 0) {
                prev.next = l2;
            } else {
                // build an adder node to invoke addTwoNumbers recursively
                ListNode adderNode = new ListNode(adder);
                prev.next = addTwoNumbers(l2, adderNode);
            }

        } else if (l1 != null && l2 == null) {
            if (adder == 0) {
                prev.next = l1;
            } else {
                ListNode adderNode = new ListNode(adder);
                prev.next = addTwoNumbers(l1, adderNode);
            }
        } else {
            // both l1 and l2 is null
            if (adder > 0) {
                // create an empty node for adder
                prev.next = new ListNode(adder);
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(9, new ListNode(9));

        AddTwoNumberList atnl = new AddTwoNumberList();
        ListNode ret = atnl.addTwoNumbers(l1, l2);
        System.out.println(ret);
    }
}

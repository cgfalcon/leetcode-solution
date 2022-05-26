package org.hellofalcon.leetcode;

import org.hellofalcon.leetcode.common.ListNode;

/**
 * @author chugang.cg
 * @create - 2022/5/26.
 */
public class RevertLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode preLeft = null;
        ListNode postRight = head;
        // traverse the whole list to find left and right nodes
        int curPos = 1;
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode preN = null;
        ListNode n = head;
        while(n != null && curPos <= right) {

            if (curPos == left) {
                leftNode = n;
                preLeft = preN;
            }

            if (curPos == right) {
                rightNode = n;
                postRight = n.next;
            }

            // move to next
            preN = n;
            n = n.next;
            curPos++;
        }

        NodePair nodePair = reverseList(leftNode, rightNode);
        if (preLeft != null) {
            preLeft.next = nodePair.head;
        } else {
            head = nodePair.head;
        }
        nodePair.tail.next = postRight;

        return head;
    }

    private NodePair reverseList(ListNode start, ListNode end) {

        ListNode tail = start;
        ListNode cur = start;
        ListNode next = cur.next;
        ListNode tmp = null;

        while (cur != end && next != null) {
            tmp = next.next;
            next.next = cur;

            cur = next;
            next = tmp;
        }

        return new NodePair(cur, tail);
    }

    class NodePair {
        ListNode head;
        ListNode tail;

        public NodePair(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public static void main(String[] args) {
        RevertLinkedListII rll = new RevertLinkedListII();

        ListNode l = new ListNode(3);
        ListNode listNode = rll.reverseBetween(l, 1, 1);
        System.out.println(listNode);
    }

}

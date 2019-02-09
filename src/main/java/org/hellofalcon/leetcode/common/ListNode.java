package org.hellofalcon.leetcode.common;

/**
 * @author - chugang.cg
 * @create - 2019/2/9
 */
public class ListNode {
      public int val;
      public ListNode next;

      public ListNode(int x) {
            val = x;
      }


      public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
      }

      @Override
      public String toString() {
          return "{ " + val + " -> " + (next == null ? "" : next.toString()) + " }";
      }
}

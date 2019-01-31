package org.hellofalcon.leetcode.common;

import org.hellofalcon.leetcode.InvertBinaryTree;

/**
 * @author - chugang.cg
 * @create - 2019/1/31
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }


    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + (left == null ? null : left.toString()) +
                ", right=" + (right == null ? null :  right.toString()) +
                '}';
    }
}

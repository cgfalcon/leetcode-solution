package org.hellofalcon.leetcode;

import org.hellofalcon.leetcode.common.TreeNode;

import java.util.Arrays;

/**
 *
 * 124. Binary Tree Maximum Path Sum
 *
 * Note: a path should be ether a node or a sequence of nodes
 * @author - chugang.cg
 * @create - 2019/2/11
 */
public class BinaryTreeMaxPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int doFindMaxPathSum(TreeNode node) {
        if (node == null) return 0;

        int leftValue = Math.max(doFindMaxPathSum(node.left), 0);
        int rightValue = Math.max(doFindMaxPathSum(node.right), 0);

        int sum = node.val + leftValue + rightValue;

        maxSum = Math.max(sum, maxSum);

        return node.val + Math.max(leftValue, rightValue);
    }

    public int maxPathSum(TreeNode root) {
        doFindMaxPathSum(root);
        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(-2,
                        new TreeNode(1,
                                new TreeNode(-1), null),
                        new TreeNode(3)
                        ),
                new TreeNode(-3,
                        new TreeNode(-2), null));

        BinaryTreeMaxPathSum bs = new BinaryTreeMaxPathSum();
        int i = bs.maxPathSum(root);
        System.out.println(i);
    }
}

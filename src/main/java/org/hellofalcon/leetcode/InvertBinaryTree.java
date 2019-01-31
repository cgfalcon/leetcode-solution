package org.hellofalcon.leetcode;

import org.hellofalcon.leetcode.common.TreeNode;

/**
 * @author - chugang.cg
 * @create - 2019/1/31
 */
public class InvertBinaryTree {



    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode tmp = null;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(29);

        InvertBinaryTree ibt = new InvertBinaryTree();
        ibt.invertTree(treeNode);
    }
}

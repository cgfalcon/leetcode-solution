package org.hellofalcon.leetcode;

import org.hellofalcon.leetcode.common.TreeNode;

/**
 * No.106 from leetcode
 * Construct Binary Tree from Inorder and Postorder Traversal
 *
 * input:
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 *
 * output:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @author - chugang.cg
 * @create - 2019/1/31
 */
public class ConstructBinaryTreeFromTraversal {

    /**
     * One can not define the shape of a binary tree only a in-order traversal or a post-order traversal.
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int iS, int iE, int[] postorder, int pS, int pE) {
        if (iS > iE) {
            return null;
        }

        if(pS > pE) {
            return null;
        }

        int targetIdx = -1;
        for (int i = pE; i >= pS ; i--) {
            int targetVal = postorder[i];
            targetIdx = findInOrderIdx(targetVal, inorder, iS, iE);
            if (targetIdx != -1) {
               break;
            }
        }

        if (targetIdx == -1) {
            return null;
        }


        int val = inorder[targetIdx]; // get the value
        TreeNode root = new TreeNode(val);
        root.left = buildTree(inorder, iS, targetIdx - 1, postorder, pS, pE - 1);
        root.right = buildTree(inorder, targetIdx + 1, iE, postorder, pS, pE - 1);

        return root;
    }

    private int findInOrderIdx(int targetVal, int[] inorder, int iS, int iE) {
        for (int i = iS; i <= iE; i++) {
            if(targetVal == inorder[i]) {
                return i;
            }

        }
        return -1;
    }



    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};

        ConstructBinaryTreeFromTraversal solution = new ConstructBinaryTreeFromTraversal();
        TreeNode treeNode = solution.buildTree(inorder, postorder);
        System.out.println(treeNode);
    }

}

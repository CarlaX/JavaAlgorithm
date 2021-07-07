package com.fzw.week03.question01;

import com.fzw.week03.common.TreeNode;

import java.util.*;

/**
 * @author fzw
 * @description 106. 从中序与后序遍历序列构造二叉树
 * @date 2021-07-07
 **/
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length <= 0) {
            return null;
        }
        int rootValue = postorder[postorder.length - 1];
        TreeNode newRoot = new TreeNode(rootValue);
        int nextRootIndex = this.findElement(inorder, rootValue);
        int leftLength = nextRootIndex;
        if (leftLength > 0) {
            TreeNode leftNode = this.buildTree(Arrays.copyOfRange(inorder, 0, nextRootIndex), Arrays.copyOfRange(postorder, 0, leftLength));
            newRoot.left = leftNode;
        }
        int rightLength = inorder.length - 1 - nextRootIndex;
        if (rightLength > 0) {
            TreeNode rightNode = this.buildTree(Arrays.copyOfRange(inorder, nextRootIndex + 1, inorder.length), Arrays.copyOfRange(postorder, leftLength, postorder.length - 1));
            newRoot.right = rightNode;
        }
        return newRoot;
    }

    private int findElement(int[] array, int ele) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ele) {
                return i;
            }
        }
        return -1;
    }
}

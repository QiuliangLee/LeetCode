package com.lql;

/**
 * @author liqiuliang
 * @create 2022-12-11 5:34
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {

    }
}
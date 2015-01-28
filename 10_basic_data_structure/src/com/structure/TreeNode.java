package com.structure;

/**
 * Created by yuwei on 2015/1/27.
 */
public class TreeNode {
    private int value = 0;
    private TreeNode parents = null;
    private TreeNode left = null;
    private TreeNode right = null;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getParents() {
        return parents;
    }

    public void setParents(TreeNode parents) {
        this.parents = parents;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

}

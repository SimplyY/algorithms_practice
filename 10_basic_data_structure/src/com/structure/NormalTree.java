package com.structure;

/**
 * Created by yuwei on 2015/1/29.
 */
//以先序建树，将原本在数组里以无限孩子的树转换为二叉树
// 约定如果treeArray的某个数字有一个NULL则其没有子树，有两个意味着其没有右兄弟。
public class NormalTree{
    TreeNode root = null ;
    int index = 0;

    private final int NULL = Integer.MIN_VALUE;


    public NormalTree(int[] treeArray){
        index = 0;
        root = new TreeNode();
        TreeNode current = root;
        createTree(current, treeArray);

        System.out.println();
    }


    private void createTree(TreeNode current, int[] treeArray){
        if (treeArray[index] != NULL){
            current.setValue(treeArray[index]);
//            if (treeArray[index] == 7){
//                    int test = 0;
//            }
            index ++;
        }
//对左孩子处理
        if (treeArray[index] != NULL){
            TreeNode child = new TreeNode();
            child.setParents(current);
            current.setLeft(child);

            createTree(child, treeArray);
        }
//对右兄弟处理

        index++;

        while (index <treeArray.length && treeArray[index] != NULL){
            TreeNode brother = new TreeNode();
            brother.setParents(current);
            current.setRight(brother);
            current = current.getRight();
            createTree(current, treeArray);
        }

    }
    public void show(){
        preOrder(root);
        System.out.println();
    }

    private void preOrder(TreeNode current){
        if (current != null){
            System.out.print(current.getValue() + " ");
            preOrder(current.getLeft());
            preOrder(current.getRight());
        }
        else{
            return;
        }
    }

}

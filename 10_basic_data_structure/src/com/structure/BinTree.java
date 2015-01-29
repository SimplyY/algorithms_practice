package com.structure;

/**
 * Created by yuwei on 2015/1/27.
 */
public class BinTree {
    private TreeNode root = null;
    int index = 0;
    private final int NULL = Integer.MIN_VALUE;

    public BinTree(TreeNode root, int index){
        this.root = root;
        this.index = index;
    }

//treeArray中将NULL当做空分支，按先序建树
    public BinTree(int[] treeArray){
        index = 0;
        root = new TreeNode();
        TreeNode current = root;
        createTree(current, treeArray);
        System.out.println();
    }



//记住在建树的时候，要对每个节点的left、right、parents赋值
    private void createTree(TreeNode current, int[] treeArray){
        if (treeArray[index] != NULL){
            current.setValue(treeArray[index]);
            System.out.print(treeArray[index] + " ");
            index ++;

            if (treeArray[index] != NULL){
                current.setLeft(new TreeNode());
                current.getLeft().setParents(current);
                createTree(current.getLeft(), treeArray);
            }
//特别注意：这里的index需要自加1，因为这时已是对right判断
            index++;
            if (treeArray[index] != NULL){
                current.setRight(new TreeNode());
                current.getRight().setParents(current);
                createTree(current.getRight(), treeArray);
            }
        }
        else{
            return;
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

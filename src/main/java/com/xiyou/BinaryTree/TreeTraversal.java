package com.xiyou.BinaryTree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 二叉树遍历
 *
 * @author cc
 * @create 2017-09-22-22:01
 */

public class TreeTraversal {
    public Stack<BinTree> stack = new Stack<BinTree>();
    //非递归先序遍历
    public void pareOrder(BinTree root){
        BinTree p = root;
        while (p != null || stack.empty()) {
            while (p != null) {
                System.out.println(p.getData());
                stack.push(p);
                p = p.getLeft();
            }
            if (!stack.empty()) {
                p = stack.pop();
                p = p.getRight();
            }
        }
    }
    //非递归中序遍历
    public void inOrder(BinTree root){
        BinTree p = root;
        while (p != null || stack.empty()){
           while (p != null){
               stack.push(p);
               p = p.getLeft();
           }
            if (!stack.empty()){
                p = stack.pop();
                System.out.println(p.getData());
                p = p.getRight();
            }
        }
    }
    //非递归后序遍历
    public void postOrder(BinTree root){
        BinTree p = root;
        Set<BinTree> set = new HashSet<BinTree>();
        while (p != null || !stack.empty()){
            while (p != null){
                stack.push(p);
                p = p.getLeft();
            }
            if (p.getRight() != null){
                p = p.getRight();
                stack.push(p);
            }
            if ((!stack.empty()) && (p.getLeft() == null || set.contains(p.getLeft())) && (p.getRight() == null || set.contains(p.getRight()))){
                p = stack.pop();
                System.out.println(p.getData());
                set.add(p);
                p = stack.peek();
            }
        }
    }
}
class BinTree{
    private int data;
    private BinTree left;
    private BinTree right;
    public BinTree(int data, BinTree left, BinTree right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public BinTree getLeft() {
        return left;
    }

    public BinTree getRight() {
        return right;
    }
}

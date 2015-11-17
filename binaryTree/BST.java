package com.binaryTree;

import java.security.PublicKey;

/**
 * Created by Alvin on 15/11/13.
 */
public class BST {
        //二叉树个节点
        private Node root;

         class Node{
            private int data;
            private Node leftChild;
            private Node rightChild;

             public Node(int data)
             {
                 this.data  = data;
                 leftChild = null;
                 rightChild = null;
             }
        }

    public BST(){
        root = null;
    }

    public int size() {
        return size(root);
    }

    public int deep(){
       return deep(root);
    }

    public int min(){
        return min(root).data;
    }

    public void put(int data){
        root = put(root,data);
    }

    public void preOrderBST(){
        preOrderBST(root);
    }

    public void inOrderBST(){
        inOrderBST(root);
    }

    public void postOrderBST(){
        postOrderBST(root);
    }

    public void mirror(){
        mirror(root);
    }

    //打印数据
    public void visit(Node node){
        if(node == null)
            return;
        System.out.println(node.data);
    }

    //返回二叉树的节点数量
    private int size(Node head){
        if(head == null) return 0;
        else return size(head.leftChild)+size(head.rightChild)+1;
    }

    private int deep(Node head){
        if(head == null) return 0;
        int leftdeep = deep(head.leftChild) + 1;
        int rightdeep = deep(head.rightChild) + 1;
    return leftdeep > rightdeep ? leftdeep : rightdeep;
    }

    //找二叉树中的最小数
    private Node min(Node head){
        if(head.leftChild==null)
            return head;
         return min(head.leftChild);
    }

    //插入数据
    private Node put(Node head,int data){
        if(head == null)
            return new Node(data);
        Node cur = head;
        if(cur.data > data) {
            cur.leftChild = put(cur.leftChild, data);
        }else if(cur.data < data) {
            cur.rightChild = put(cur.rightChild, data);
        }else{
            cur.data = data;
        }
        return cur;
    }

    //先序遍历
    private void preOrderBST(Node head){
        if(head == null)
            return;
        visit(head);
        preOrderBST(head.leftChild);
        preOrderBST(head.rightChild);
    }

    //中序遍历
    private void inOrderBST(Node head){
        if(head == null)
            return;
        inOrderBST(head.leftChild);
        visit(head);
        inOrderBST(head.rightChild);
    }

    //后序遍历
    private void postOrderBST(Node head){
        if(head == null)
            return;
        postOrderBST(head.leftChild);
        postOrderBST(head.rightChild);
        visit(head);
    }

    //二叉树的镜像
    private void mirror(Node head){
        if(head == null)
            return;
        Node temp = head.leftChild;
        head.leftChild = head.rightChild;
        head.rightChild = temp;
        mirror(head.leftChild);
        mirror(head.rightChild);
    }

}

package com.Tree;

/**
 * 红黑树
 */
public class RBTree<Key extends Comparable<Key>,Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node{
        //键
        Key key;
        //值
        Value value;
        //左右子树
        Node left,right;
        //节点个数
        int N;
        //由其父节点指向它的链接的颜色
        boolean color;

        Node(Key key,Value value,int N,boolean color){
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    /**
     * 判断该节点是不是红色的
     * @param x
     * @return
     */
    private boolean isRed(Node x){
        if (x == null) return false;
        return x.color == RED;
    }

    private int size(Node x){
        if (x == null) return 0;
        return x.N;
    }

    /**
     * 左旋转
     * @param h
     * @return
     */
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 右旋转
     * @param h
     * @return
     */
    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 颜色转换
     * @param h
     */
    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /**
     * 插入算法，如果找到就更新value，没有找到就插入一个节点
     * @param key
     * @param value
     */
    public void put(Key key,Value value){
        root = put(root,key,value);
        root.color = BLACK;
    }

    private Node put(Node x,Key key,Value value){
        //插入操作，和父节点用红点链接表示
        if (x == null) return new Node(key,value,1, RED);

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left,key,value);
        else if (cmp > 0) x.right = put(x.right,key,value);
        else x.value = value;

        if (isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right)) flipColors(x);

        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }
}

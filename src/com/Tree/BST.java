package com.Tree;

public class BST <Key extends Comparable<Key>,Value>{

    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        private int N;

        public Node(Key key,Value value,int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if (x == null) return 0;
        else return x.N;
    }

    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node x,Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left,key);
        else if (cmp > 0) return get(x.right,key);
        else return x.value;
    }

    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    private Node put(Node x,Key key,Value value){
        if (x == null) return new Node(key,value,1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left,key,value);
        else if (cmp > 0) x.right = put(x.right,key,value);
        else x.value = value;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        if (x.left == null) return x;
        return min(x.left);
    }

    /**
     * 向下取整
     * @param key
     * @return
     */
    public Key floor(Key key){
        Node x = floor(root,key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x,Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        //key位于x左边，向x的左子树进行向下取整
        if (cmp < 0) return floor(x.left,key);
        //右边情况特殊，有可能出现都比key大的节点，先要进行判断
        Node t = floor(x.right,key);
        if (t != null) return t;
        else return x;
    }

    public Key select(int k){
        return select(root,k).key;
    }

    /**
     * 返回排名为k的节点
     * @param x
     * @param k
     * @return
     */
    private Node select(Node x,int k){
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left,k);
        else if (t < k) return select(x.right,k-t-1);
        else return x;
    }

    /**
     * 返回小于x.key的健的数量
     * @param key
     * @return
     */
    public int rank(Key key){
        return rank(root,key);
    }

    /**
     * 返回以x为根节点的子树中小于x.key的健的数量
     * @param x
     * @param key
     * @return
     */
    private int rank(Node x,Key key){
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return size(x.left) + 1 + rank(x.right,key);
        else if (cmp < 0) return rank(x.left,key);
        else return size(x.left);
    }

    /**
     * 删除最小节点后的树
     */
    public void deleteMin(){
        root = deleteMin(root);
    }

    /**
     * 返回以x为根节点的删除最小节点后的树
     * @param x
     * @return
     */
    private Node deleteMin(Node x){
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }

    public void delete(Key key){
        root = delete(root,key);
    }

    private Node delete(Node x,Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) delete(x.right,key);
        else if (cmp < 0) delete(x.left,key);
        else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            Node t = x;
            x = min(x.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
}

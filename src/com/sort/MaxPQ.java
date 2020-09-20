package com.sort;

/**
 * 优先队列
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>> {

    //基于堆的完全二叉树
    private Key[] pq;
    //存储于pq[1...N]中，pq[0]没有使用
    private int N = 0;

    public MaxPQ(int maxN){
        pq =(Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        //从根节点得到最大元素
        Key max = pq[1];
        //将其和最后一个节点交换
        exchange(1,N);
        //防止对象游离
        pq[N+1] = null;
        //恢复堆的有序性
        sink(1);
        return max;
    }

    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i,int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    //由下自上的堆有序化——上浮
    private void swim(int k){
        while (k > 1 && less(k/2,k)){
            exchange(k/2,k);
            k = k/2;
        }
    }

    //由上自下的堆有序化——下沉
    private void sink(int k){
        while (2*k <= N){
            int j = 2*k;
            if (j < N && less(j,j+1)){
                j++;
            }
            if (!less(k,j)){
                break;
            }
            exchange(k,j);
            k = j;
        }
    }
}

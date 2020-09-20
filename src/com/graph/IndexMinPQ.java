package com.graph;

public class IndexMinPQ<Key extends Comparable<Key>> {

    private int N;//PQ中的元素数量
    private int[] pq;//索引二叉堆，由1开始
    private int[] qp;//逆序：qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys;//有优先级之分的元素

    public IndexMinPQ(int maxN){
        keys =(Key[]) new Comparable[maxN+1];
        pq = new int[maxN+1];
        qp = new int[maxN+1];
        for (int i = 0;i <= maxN;i++){
            qp[i] = -1;
        }
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public boolean contains(int k){
        return qp[k] != -1;
    }

    public void insert(int k,Key key){
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1 && less(k/2,k)){
            exch(k/2,k);
            k = k/2;
        }
    }

    private boolean less(int i, int k) {
        return keys[i].compareTo(keys[k]) < 0;
    }

    public Key min(){
        return keys[pq[1]];
    }

    public int delMin(){
        int indexOfMin = pq[1];
        exch(1,N--);
        sink(1);
        keys[pq[N+1]] = null;
        pq[qp[N+1]] = -1;
        return indexOfMin;
    }

    private void sink(int i) {
        while (2*i <= N){
            int j = 2*i;
            if (j < N && less(j,j+1)) j++;
            if (!less(i,j)) break;
            exch(i,j);
            i = j;
        }
    }

    private void exch(int i, int i1) {
        Key t = keys[i];
        keys[i] = keys[i1];
        keys[i1] = t;

        int j = pq[i];
        pq[i] = pq[i1];
        pq[i1] = j;

        qp[pq[i]] = i;
        qp[pq[i1]] = i1;
    }

    public void change(int k,Key key){
        keys[k] = key;
        swim(pq[k]);
        sink(pq[k]);
    }
}

package com.sort;

/**
 * 自底向上的归并排序
 */
public class MergeBU {

    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[a.length];
        for (int sz = 1;sz < N;sz *= 2){
            for (int lo = 0;lo < N - sz;lo += sz + sz){
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
            }
        }
    }

    //将 a[lo...mid] 和 a[mid+1...hi]归并
    public static void merge(Comparable[] a,int lo,int mid,int hi){
        int i = lo,j = mid + 1;
        //将数组a[k]复制到aux[x]上
        for (int k = lo;k <= hi;k++){
            aux[k] = a[k];
        }
        //归并回到a[lo...hi]
        for (int k = lo;k <= hi;k++){
            if (i > mid){
                a[k] = aux[j++];
            }else if (j > hi){
                a[k] = aux[i++];
            }else if (less(aux[j],aux[i])){
                a[k] = aux[j++];
            }else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }
}

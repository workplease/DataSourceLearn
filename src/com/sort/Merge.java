package com.sort;

/**
 * 自顶向下的归并排序
 */
public class Merge {

    //归并所需的辅助数组
    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        //一次性分配空间
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    //将数组a[lo...hi]排序
    private static void sort(Comparable[] a,int lo,int hi){
        if (hi <= lo){
            return;
        }
        int mid = lo + (hi - lo)/2;
        //左半边排序
        sort(a,lo,mid);
        //右半边排序
        sort(a,mid+1,hi);
        //归并结果
        merge(a,lo,mid,hi);
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

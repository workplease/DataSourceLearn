package com.sort;

/**
 * 快速排序
 */
public class Quick {

    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        if (hi <= lo){
            return;
        }
        int j = partition(a,lo,hi);
        //将左半部分a[lo...j-1]排序
        sort(a,lo,j-1);
        //将左半部分a[j...hi]排序
        sort(a,j,hi);
    }

    //快速排列的划分，将数组划分为a[lo...i-1]，a[i]，a[i+1...hi]
    private static int partition(Comparable[] a,int lo,int hi){
        int i = lo,j = hi+1;
        Comparable v = a[lo];
        //扫描左右，检查扫描是否结束并交换元素
        while (true){
            while (less(a[++i],v)){
                if (i == hi) break;
            }
            while (less(v,a[--j])){
                if (j == lo) break;
            }
            if (i >= j) break;
            exchange(a,i,j);
        }
        exchange(a,lo,j);
        return j;
    }

    private static void exchange(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }
}

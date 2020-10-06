package com.sort;

/**
 * 快速排列的改进版本
 */
public class Quick3way {

    private static void sort(Comparable[] a,int lo,int hi){
        if (hi <= lo){
            return;
        }
        int lt = lo,i = lo + 1,gt = hi;
        Comparable v = a[lo];
        while (i <= gt){
            int cmp = a[i].compareTo(v);
            if (cmp < 0){
                exchange(a,lt++,i++);
            }else if (cmp > 0){
                exchange(a,i,gt--);
            }else {
                i++;
            }
        }
        //现在 a[lo...lt-1] < v = a[lt...gt] < a[gt+1...hi] 成立
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    private static void exchange(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

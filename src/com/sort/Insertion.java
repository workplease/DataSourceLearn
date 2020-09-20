package com.sort;

/**
 * 插入排序
 */
public class Insertion {

    public static void sort(Comparable[] a){
        for (int i = 0;i < a.length;i++){
            //将a[j]插入到a[j-1 ... 0]中
            for (int j = i;j > 0 && less(a[j],a[j-1]);j--){
                exchange(a,j,j-1);
            }
        }
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exchange(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        //在单行中打印数组
        for (int i = 0;i < a.length;i++){
            System.out.println(a[i]+" ");
        }
        System.out.println();
    }

    /**
     * 测试数组元素是否有序
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a){
        for (int i = 1;i < a.length;i++){
            if (less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    /**
     * 从第d个字符开始对a[lo]到a[hi]进行排序
     * @param a
     * @param lo
     * @param hi
     * @param d
     */
    public static void sort(String[] a, int lo, int hi, int d) {
        for (int i = lo;i <= hi;i++){
            for (int j = i;j > 0 && less(a[j],a[j-1],d);j--){
                exchange(a,j,j-1);
            }
        }
    }

    private static boolean less(String v,String w,int d){
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }
}

package com.sort;

/**
 * 基本框架，以后的排序函数是以此来修改sort函数，其他函数逻辑相同
 */
public class baseSort {

    public static void sort(Comparable[] a){

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
}

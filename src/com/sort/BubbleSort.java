package com.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0;i < N - 1;i ++){
            for (int j = 0;(j < N - 1 - i) && less(a[j],a[i]);j ++){
                exchange(a,i,j);
            }
            //由于遍历的元素数量逐渐减小，如果有序就不需要继续冒泡
            if (isSorted(a))
                break;
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
}

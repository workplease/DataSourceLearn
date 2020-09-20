package com.sort;

/**
 * 希尔排序
 */
public class Shell {

    public static void sort(Comparable[] a){
        int h = 1;
        while (h < a.length/3){
            h = h*3 + 1;
        }
        while (h >= 1){
            for (int i = 0;i < a.length;i ++){
                //将a[j]插入到a[j-h],a[j-2h],a[j-3h]...中去
                for (int j = i;j > 0 && less(a[j],a[j-h]);j -= h){
                    exchange(a,j,j-h);
                }
            }
            h /= 3;
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

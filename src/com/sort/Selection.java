package com.sort;

/**
 * 选择排序
 */
public class Selection {

    /**
     * 通过两层for循环，每一次找出i后面元素的最小值，并且与i调换顺序，直至顺序正确，默认升序排序
     * @param a
     */
    public static void sort(Comparable[] a){
        for (int i = 0;i < a.length;i++){
            int min = i;
            //将a[i]与a[i+1 ... N]中最小元素交换
            for (int j = i+1;j < a.length;j++){
                if (less(a[j],a[min])){
                    min = j;
                }
            }
            exchange(a,i,min);
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

package com.sort;

/**
 * 堆排序
 */
public class HeapSort {

    public void sort(Comparable[] a){
        int N = a.length;
        //构造堆
        for (int k = N/2;k >= 1;k --){
            sink(a,k,N);
        }
        //通过循环将最大元素 a[1] 到 a[N] 交换并且修复离了堆
        while (N > 1){
            exchange(a,1,N--);
            sink(a,1,N);
        }
    }

    //下沉操作
    private void sink(Comparable[] a, int k, int n) {
        while (2*k <= n){
            int j = 2*k;
            //找出子节点最大的那个
            if (j < n && less(a,j,j+1)){
                j++;
            }
            //最大的子节点小于父节点，不需要交换，跳出循环
            if (!less(a,k,j)){
                break;
            }
            exchange(a,k,j);
            k = j;
        }
    }

    private boolean less(Comparable[] a,int i, int j){
        return a[i].compareTo(a[j]) < 0;
    }

    private void exchange(Comparable[] a,int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

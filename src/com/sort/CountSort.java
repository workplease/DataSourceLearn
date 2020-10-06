package com.sort;

/**
 * 计数排序
 */
public class CountSort {

    public static int[] countSort(int[] array) {
        //1.得到数列的最大值和最小值，并算出差值d
        int max = array[0];
        int min = array[0];

        for (int i= 1; i<array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        //2.创建统计数组并统计对应元素个数
        int[] countArray = new int[d+1];
        for (int i= 0; i<array.length; i++) {
            countArray[array[i]-min]++;
        }
        //3.统计数组做变形，后面的元素等于前面的元素之和
        int sum = 0;
        for (int i= 0;i<countArray.length;i++) {
            sum += countArray[i];
            countArray[i] = sum;
        }
        //4.倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int [] sortedArray = new int [array.length];
        for (int i=array.length- 1;i>= 0;i--) {
            sortedArray[countArray[array[i]-min]- 1]=array[i];
            countArray[array[i]-min]--;
        }
        return sortedArray;
    }
}

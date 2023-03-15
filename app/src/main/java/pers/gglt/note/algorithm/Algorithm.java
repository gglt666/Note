package pers.gglt.note.algorithm;

import org.junit.Test;

public class Algorithm {
    /**
     * 冒泡
     *      思想  1.每一次遍历获取最大/最小值
     *           2.将最大/最小值放在尾部/头部
     *           3.剩下数据重复前两步
     */
    @Test
    public void bubbleSort() {
        int arr[] = {8, 5, 3, 2, 4};
        for (int i = 0; i < arr.length; i++) { //外层循环，遍历次数
            for (int j = 0; j < arr.length - i - 1; j++) {
                //内层循环，升序（如果前一个值比后一个值大，则交换）
                //内层循环一次，获取一个最大值
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

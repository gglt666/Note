package pers.gglt.note.leetcode.array;

//https://www.programmercarl.com
public class Array {
    /**特点*/
    // 下标从0开始
    // 内存空间地址连续 (二维数组在JVM中不连续)

    /**二分查找*/
    // 前提条件: 有序,无重复

    int search(int[] nums, int target) {
        // 避免目标值不在区间内时的多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int leftIndex = 0, rightIndex = nums.length - 1; //定义目标值在左闭右闭的区间里 ([left,right])
        while (leftIndex <= rightIndex) { //由于右闭,需=
            int mid = (leftIndex + rightIndex) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) //mid在目标值左边
                leftIndex = mid + 1; //[1,2,3,(4),7,9,10] -> [7,(9),10] -> [10]
            else if (nums[mid] > target)
                rightIndex = mid - 1;//[1,2,3,(4),7,9,10] -> [1,(2),3] -> [1]
        }
        return -1;
    }

    /**元素移除*/
    int remove(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}

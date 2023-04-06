package pers.gglt.note.leetcode.array;

//https://www.programmercarl.com
public class Array {
    /**特点*/
    // 下标从0开始
    // 内存空间地址连续 (二维数组在JVM中不连续)

    /**二分查找*/
    // 前提条件: 有序,无重复

    int search1(int[] nums, int target) {
        // 避免目标值不在区间内时的多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1; //定义目标值在左闭右闭的区间里 ([left,right])
        while (left <= right) { //由于右闭,需=
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) //mid在目标值左边
                left = mid + 1; //[1,2,3,(4),7,9,10] -> [7,(9),10] -> [10]
            else if (nums[mid] > target)
                right = mid - 1;//[1,2,3,(4),7,9,10] -> [1,(2),3] -> [1]
        }
        return -1;
    }
    int search2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) { //由于右开,无需=
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
        }
        return -1;
    }
}

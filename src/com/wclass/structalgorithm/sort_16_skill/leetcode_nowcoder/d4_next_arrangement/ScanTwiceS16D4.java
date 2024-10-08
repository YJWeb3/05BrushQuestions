package com.wclass.structalgorithm.sort_16_skill.leetcode_nowcoder.d4_next_arrangement;

/**
 * @program: StructAlgorithm
 * @ClassName ScanTwiceS16D4
 * @description:
 * @author: W哥
 * @create: 2024-10-09-08-30
 * @Version 1.0
 **/
public class ScanTwiceS16D4 {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}

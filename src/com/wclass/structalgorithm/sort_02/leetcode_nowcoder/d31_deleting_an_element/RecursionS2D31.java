package com.wclass.structalgorithm.sort_02.leetcode_nowcoder.d31_deleting_an_element;

/**
 * @program: StructAlgorithm
 * @ClassName RecursionS2D31
 * @description:
 * @author: W哥
 * @create: 2024-09-17-19-32
 * @Version 1.0
 **/
public class RecursionS2D31 {

    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int[] pre = new int[n];
        int[] suf = new int[n];

        pre[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            pre[i] = nums[i] != 0 ? pre[i - 1] + 1 : 0;
        }

        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            suf[i] = nums[i] != 0 ? suf[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int preSum = i == 0 ? 0 : pre[i - 1];
            int sufSum = i == n - 1 ? 0 : suf[i + 1];
            ans = Math.max(ans, preSum + sufSum);
        }

        return ans;
    }

}

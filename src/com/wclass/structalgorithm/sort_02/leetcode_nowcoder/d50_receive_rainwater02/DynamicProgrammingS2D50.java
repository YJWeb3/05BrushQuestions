package com.wclass.structalgorithm.sort_02.leetcode_nowcoder.d50_receive_rainwater02;

/**
 * @program: StructAlgorithm
 * @ClassName DynamicProgrammingS2D50
 * @description:
 * @author: W哥
 * @create: 2024-09-19-21-13
 * @Version 1.0
 **/
public class DynamicProgrammingS2D50 {

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

}

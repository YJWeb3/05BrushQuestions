package com.wclass.structalgorithm.sort_02.leetcode_nowcoder.d36_rotate_image;

/**
 * @program: StructAlgorithm
 * @ClassName ReplaceRotationWithFlippingS2D36
 * @description:
 * @author: W哥
 * @create: 2024-09-17-20-16
 * @Version 1.0
 **/
public class ReplaceRotationWithFlippingS2D36 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
package com.wclass.structalgorithm.sort_02.leetcode_nowcoder.d16_compressed_string;

/**
 * @program: StructAlgorithm
 * @ClassName TwoPointersS2D116
 * @description:
 * @author: W哥
 * @create: 2024-09-15-22-41
 * @Version 1.0
 **/
public class TwoPointersS2D116 {

    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

}

package com.wclass.structalgorithm.sort_17_math.leetcode_nowcoder.d7_nth_digit;

/**
 * @program: StructAlgorithm
 * @ClassName BinarySearchS17D7
 * @description:
 * @author: W哥
 * @create: 2024-10-09-09-24
 * @Version 1.0
 **/
public class BinarySearchS17D7 {

    public int findNthDigit(int n) {
        int low = 1, high = 9;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (totalDigits(mid) < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int d = low;
        int prevDigits = totalDigits(d - 1);
        int index = n - prevDigits - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

    public int totalDigits(int length) {
        int digits = 0;
        int curLength = 1, curCount = 9;
        while (curLength <= length) {
            digits += curLength * curCount;
            curLength++;
            curCount *= 10;
        }
        return digits;
    }

}

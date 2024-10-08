package com.wclass.structalgorithm.sort_09_hashtable.leetcode_nowcoder.d3_two_numbers_appear_once_array;

/**
 * @program: StructAlgorithm
 * @ClassName XORS9D3
 * @description:
 * @author: W哥
 * @create: 2024-10-03-23-07
 * @Version 1.0
 **/
public class XORS9D3 {

    public int[] FindNumsAppearOnce (int[] array) {
        int res1 = 0;
        int res2 = 0;
        int temp = 0;
        //遍历数组得到a^b
        for(int i = 0; i < array.length; i++)
            temp ^= array[i];
        int k = 1;
        //找到两个数不相同的第一位
        while((k & temp) == 0)
            k <<= 1;
        for(int i = 0; i < array.length; i++){
            //遍历数组，对每个数分类
            if((k & array[i]) == 0)
                res1 ^= array[i];
            else
                res2 ^= array[i];
        }
        //整理次序
        if(res1 < res2)
            return new int[] {res1, res2};
        else
            return new int[] {res2, res1};
    }

}

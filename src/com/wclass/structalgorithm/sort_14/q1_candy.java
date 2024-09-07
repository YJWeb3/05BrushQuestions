package com.wclass.structalgorithm.sort_14;

/**
 * @program: StructAlgorithm
 * @ClassName q1_candy
 * @description:
 * @author: W哥
 * @create: 2024-09-04-00-17
 * @Version 1.0
 **/
public class q1_candy {

    /*
    * 题目描述：—群孩子做游戏，现在请你根据游戏得分来发糖果，要求如下:
    *  1.每个孩子不管得分多少，起码分到一个糖果。
    *  2.任意两个相邻的孩子之间。得分较多的孩子必须拿多一些糖果。(若相同则无此限制）
    * 给定一个数组αrr代表得分数组，请返回最少需要多少糖果。
    * 要求:时间复杂度为O(n)空间复杂度为O(n)
    **/
    // 方式一：贪心算法
    public int candy (int[] arr) {
        int n = arr.length;
        if(n <= 1)
            return n;
        int[] nums = new int[n];
        //初始化
        for(int i = 0; i < n; i++)
            nums[i] = 1;
        //从左到右遍历
        for(int i = 1; i < arr.length; i++){
            //如果右边在递增，每次增加一个
            if(arr[i] > arr[i - 1])
                nums[i] = nums[i - 1] + 1;
        }
        //记录总糖果数
        int res = nums[arr.length - 1];
        //从右到左遍历
        for(int i = arr.length - 2; i >= 0; i--){
            //如果左边更大但是糖果数更小
            if(arr[i] > arr[i + 1] && nums[i] <= nums[i + 1])
                nums[i] = nums[i + 1] + 1;
            //累加和
            res += nums[i];
        }
        return res;
    }

}

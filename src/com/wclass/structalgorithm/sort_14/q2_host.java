package com.wclass.structalgorithm.sort_14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: StructAlgorithm
 * @ClassName q2_host
 * @description:
 * @author: W哥
 * @create: 2024-09-04-00-21
 * @Version 1.0
 **/
public class q2_host {

    // 方法一：排序+遍历比较（推荐使用）
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        int[] start = new int[n];
        int[] end = new int[n];
        //分别得到活动起始时间
        for(int i = 0; i < n; i++){
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }
        //单独排序
        Arrays.sort(start, 0, start.length);
        Arrays.sort(end, 0, end.length);
        int res = 0;
        int j = 0;
        for(int i = 0; i < n; i++){
            //新开始的节目大于上一轮结束的时间，主持人不变
            if(start[i] >= end[j])
                j++;
            else
                //主持人增加
                res++;
        }
        return res;
    }


    // 方法二：重载排序+大顶堆（扩展思路）
    public int minmumNumberOfHost02 (int n, int[][] startEnd) {
        int A[] = new int[n];
        int k = 0;
        //按列排序，按开始时间递增排
        Arrays.sort(startEnd, new Comparator<Object>() {
            public int compare(Object o1,Object o2) {
                int[] one = (int[]) o1;
                int[] two = (int[]) o2;
                if(one[0]>two[0]) return 1;
                if(one[0]==two[0]) return 0;
                else return -1;
            }
        });
        //小顶堆
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        //可能有负区间
        q.offer(Integer.MIN_VALUE);
        for(int i = 0; i < n; i++){
            //最近的活动结束时间小于当前活动开始时间
            if(q.peek() <= startEnd[i][0])
                q.poll();
            q.offer(startEnd[i][1]);
        }
        //剩余的活动等于主持人数
        return q.size();
    }
}

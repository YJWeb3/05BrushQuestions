package com.wclass.structalgorithm.sort_01.d21_colorful_lights_1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import com.wclass.structalgorithm.sort_01.d0_entity.TreeNode;

/**
 * @program: StructAlgorithm
 * @ClassName BFSS1D21
 * @description:
 * @author: W哥
 * @create: 2024-09-11-21-22
 * @Version 1.0
 **/
public class BFSS1D21 {

    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> d = new ArrayDeque<>();
        if (root != null) d.addLast(root);
        while (!d.isEmpty()) {
            TreeNode t = d.pollFirst();
            list.add(t.val);
            if (t.left != null) d.addLast(t.left);
            if (t.right != null) d.addLast(t.right);
        }
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = list.get(i);
        return ans;
    }
}


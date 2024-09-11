package com.wclass.structalgorithm.sort_01.d24_substructure_judgment;

import com.wclass.structalgorithm.sort_01.d0_entity.TreeNode;

/**
 * @program: StructAlgorithm
 * @ClassName RecursiveS1D24
 * @description:
 * @author: W哥
 * @create: 2024-09-11-21-47
 * @Version 1.0
 **/
public class RecursiveS1D24 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}

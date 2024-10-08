package com.wclass.structalgorithm.zijie;

import java.util.ArrayList;

/**
 * ClassName:d95_Serialize
 * Package:com.yj.nz.zijie
 * Description:描述
 *
 * @Date:2023/2/19 19:48
 * @Author:NieZheng
 * @Version:1.0
 */
public class d95_Serialize {

    class TreeNode{
        public int val;
        public TreeNode left,right;
        public TreeNode(int val){
            this.val = val;
            this.left = this.right = null;
        }
    }

    public String serialize(TreeNode root){
        if (root == null){
            return "{}";
        }

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null){
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        while(queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null){
                sb.append(",#");
            }else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public TreeNode deserialize(String data){
        if (data.equals("{}")){
            return null;
        }
        String[] vals = data.substring(1,data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")){
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild){
                    queue.get(index).left = node;
                }else {
                    queue.get(index).right = node;
                }
                queue.add(node);
        }
            if (!isLeftChild){
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}

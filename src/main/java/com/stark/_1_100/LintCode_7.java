package com.stark._1_100;

import com.stark.entity.TreeNode;

import java.lang.ref.SoftReference;

/**
 * Created by Stark on 2017/9/2.
 * 设计一个算法，并编写代码来序列化和反序列化二叉树。
 * 将树写入一个文件被称为“序列化”，读取文件后重建同样的二叉树被称为“反序列化”。
 */
public class LintCode_7 {

    //序列化 eg{1,2,3,#,#,6,7}
    public String serialize(TreeNode root) {
        if (null == root) return "{}";
        //初始化条件
        int goOn = 1;
        StringBuilder sb = new StringBuilder("{");
        TreeNode[] nodes = new TreeNode[1];
        nodes[0] = root;
        while (goOn > 0) {
            TreeNode[] nextNodes = new TreeNode[nodes.length * 2];
            for (int i = 0; i < nodes.length; i++) {
                if (null == nodes[i]) {
                    nextNodes[i * 2] = null;
                    nextNodes[i * 2 + 1] = null;
                    sb.append("#").append(",");
                } else {
                    sb.append(nodes[i].val).append(",");
                    goOn--;
                    if (nodes[i].left != null) {
                        nextNodes[i * 2] = nodes[i].left;
                        goOn++;
                    } else {
                        nextNodes[i * 2] = null;
                    }
                    if (nodes[i].right != null) {
                        nextNodes[i * 2 + 1] = nodes[i].right;
                        goOn++;
                    } else {
                        nextNodes[i * 2 + 1] = null;
                    }
                    if (goOn <= 0) {
                        break;
                    }
                }
            }
            nodes = nextNodes;
        }
        sb.setCharAt(sb.length() - 1, '}');
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("{}")) return null;
        String replace = data.replace("{", "").replace("}", "");
        String[] split = replace.split(",");
        int len = split.length;
        TreeNode[] nodes = new TreeNode[len];
        nodes[0] = new TreeNode(Integer.parseInt(split[0]));
        for (int i = 0; i < len; i++) {
            TreeNode node = nodes[i];
            if (node == null) continue;
            if (i * 2 + 1 < len && !split[i * 2 + 1].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(split[i * 2 + 1]));
                nodes[i * 2 + 1] = node.left;
            }
            if (i * 2 + 2 < len && !split[i * 2 + 2].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(split[i * 2 + 2]));
                nodes[i * 2 + 2] = node.right;
            }
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        LintCode_7 lintCode_7 = new LintCode_7();

        System.out.println(lintCode_7.serialize(lintCode_7.deserialize("{1,22,3,#,#,6,7}")));
    }
}


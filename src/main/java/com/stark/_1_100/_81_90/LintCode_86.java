package com.stark._1_100._81_90;

import com.stark.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Stark on 2017/10/19.
 * 设计实现一个带有下列属性的二叉查找树的迭代器：
 * 元素按照递增的顺序被访问（比如中序遍历）
 * next()和hasNext()的询问操作要求均摊时间复杂度是O(1)
 */
public class LintCode_86 {

    Queue<TreeNode> queue = new LinkedList<>();

    /*
    * @param root: The root of binary tree.
    */
    public LintCode_86(TreeNode root) {
        // do intialization if necessary
        if (root == null) {
            return;
        }
        solve(queue, root);

    }
    private void solve(Queue<TreeNode> queue, TreeNode root) {
        if (root.left != null) {
            solve(queue, root.left);
        }
        queue.add(root);
        if (root.right != null) {
            solve(queue, root.right);
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !queue.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        return queue.poll();
    }
}

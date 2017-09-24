package com.stark._301_400._361_370;

import com.stark.entity.ExpressionTreeNode;

/**
 * Created by Stark on 2017/9/21.
 * 表达树是一个二叉树的结构，用于衡量特定的表达。所有表达树的叶子都有一个数字字符串值。而所有表达树的非叶子都有另一个操作字符串值。
 * 给定一个表达数组，请构造该表达的表达树，并返回该表达树的根。
 */
public class LintCode_367 {

    public static ExpressionTreeNode build(String[] expression) {
        // write your code here
        int[] prio = new int[expression.length];
        int valiLen = dealPrio(expression, prio);//处理后有效数据的长度
        ExpressionTreeNode treeNode = buildFle(expression, prio, 0, valiLen - 1);
        return treeNode;

    }

    /**
     * @param expression
     * @param prio       符号优先级处理
     */
    public static int dealPrio(String[] expression, int[] prio) {
        int kuohao = 0;//用于括号里面操作符号升级
        for (int i = 0; i < expression.length; i++) {
            if (expression[i].equals("-")) {
                prio[i] = 1 + kuohao;
            } else if (expression[i].equals("+")) {
                prio[i] = 1 + kuohao;
            } else if (expression[i].equals("*")) {
                prio[i] = 2 + kuohao;
            } else if (expression[i].equals("/")) {
                prio[i] = 2 + kuohao;
            } else if (expression[i].equals("(")) {
                kuohao += 2;
                prio[i] = 32767;
            } else if (expression[i].equals(")")) {
                kuohao -= 2;
                prio[i] = 32767;
            } else {
                prio[i] = -32768;
            }
        }
        int j = 0;//对括号进行去除操作
        for (int i = 0; i < expression.length; i++) {
            if (expression[i].equals("(") || expression[i].equals(")")) {
                continue;
            } else {
                expression[j] = expression[i];
                prio[j] = prio[i];
                j++;
            }
        }
        return j;//有小数据的长度
    }

    public static ExpressionTreeNode buildFle(String[] expression, int[] prio, int start, int end) {
        if (start == end)//此时只有有个值的点
        {
            ExpressionTreeNode treeNode = new ExpressionTreeNode(expression[start]);
            return treeNode;
        } else {
            //如果不只是有值
            int prioOpe = Integer.MAX_VALUE;//记录优先级最低的操作符值
            int currentnum = start;//记录最低的优先级操作符位置
            //查找最小级别的操作符
            for (int i = start; i <= end; i++) {
                if (prio[i] != -32768 && prio[i] < prioOpe) {
                    prioOpe = prio[i];
                    currentnum = i;
                }
            }
            //当找到最小的操作符后，以此操作符为根做扩展
            ExpressionTreeNode expressionTreeNode = new ExpressionTreeNode(expression[currentnum]);
            expressionTreeNode.left = buildFle(expression, prio, start, currentnum - 1);
            expressionTreeNode.right = buildFle(expression, prio, currentnum + 1, end);
            return expressionTreeNode;

        }
    }

    public static void main(String[] args) {
        LintCode_367 test = new LintCode_367();
        ExpressionTreeNode build = test.build(new String[]{"2", "*", "6", "-", "(", "23", "+", "7", ")", "/", "(", "1", "+", "2", ")"});
        System.out.println(build);
    }
}

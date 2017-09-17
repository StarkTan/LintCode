package com.stark._201_300._201_210;

/**
 * Created by Stark on 2017/9/17.
 * 单例 是最为最常见的设计模式之一。对于任何时刻，如果某个类只存在且最多存在一个具体的实例，
 * 那么我们称这种设计模式为单例。例如，对于 class Mouse (不是动物的mouse哦)，我们应将其设计为 singleton 模式。
 * <p>
 * 你的任务是设计一个 getInstance 方法，对于给定的类，每次调用 getInstance 时，都可得到同一个实例。
 */
public class LintCode_204 {
    private static LintCode_204 solution = null;
    public static LintCode_204 getInstance() {
        if (solution != null){
            return solution;
        } else {
            synchronized (LintCode_204.class){
                if (solution != null){
                    return solution;
                }else {
                    LintCode_204 instant = new LintCode_204();
                    solution = instant;
                    return solution;
                }
            }
        }
    }
}

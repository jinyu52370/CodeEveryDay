package oj.sword_finger_offer;

import java.util.Stack;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/14 10:08
 *
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 *  输入：
 *      ["CQueue","appendTail","deleteHead","deleteHead"]
 *      [[],[3],[],[]]
 *  输出：
 *      [null,null,3,-1]
 *
 * 示例 2：
 *  输入：
 *      ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 *      [[],[],[5],[2],[],[]]
 *  输出：
 *      [null,-1,null,null,5,2]
 *
 * 提示：
 *  1 <= values <= 10000
 *  最多会对 appendTail、deleteHead 进行 10000 次调用
 */
public class JZ09_用两个栈实现队列 {
    class CQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public CQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void appendTail(int value) {
            s1.push(value);
        }

        public int deleteHead() {
            int s1Size = s1.size(), s2Size = s2.size();
            if (s2Size == 0) {
                if (s1Size == 0) {
                    return -1;
                }
                for (int i = 0; i < s1Size; i++) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }
    }

    public static void main(String[] args) {

    }
}

package interview._2020_09_15;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/15 19:25
 * 字符串有效判断
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一个只包括'(',')','{','}','[',']' 的字符串,判断字符串是否有效。
 *
 * 有效字符串需满足:
 * 1.左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 输入描述
 * 待判断的字符串，多个字符串需换行输入
 *
 * 输出描述
 * 每个字符串的判断结果，多个结果需换行输出
 *
 *
 * 样例输入
 * ()[]{}
 * ([)]
 * {[]}
 * 样例输出
 * true
 * false
 * true
 */
public class 小米Q1 {
    public boolean solution(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        String[] split = str.trim().split("");

        Stack<String> stack = new Stack<>();
        stack.push(split[0]);

        for (int i = 1; i < split.length; i++) {
            if (!stack.isEmpty() && check(stack.peek(), split[i])){
                stack.pop();
            } else {
                stack.push(split[i]);
            }
        }
        return stack.isEmpty();
    }

    private boolean check(String l, String r) {
        if ("(".equals(l)) {
            return ")".equals(r);
        }
        if ("[".equals(l)) {
            return "]".equals(r);
        }
        if ("{".equals(l)) {
            return "}".equals(r);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println(new 小米Q1().solution(sc.nextLine()));
        }
    }
}

package interview._2020_09_15;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/15 19:32
 * 字符串筛选
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一个字符串, 需要去除所有之前曾经出现过的字符，只保留第一次出现的字符
 *
 * 输入描述
 * 输入
 *
 * 输出描述
 * 输出
 *
 *
 * 样例输入
 * hello, welcome to xiaomi
 * 样例输出
 * helo, wcmtxia
 */
public class 小米Q2 {
    public String solution(String str){
        if (str == null || str.length() < 2) {
            return str;
        }
        ArrayList<String> list = new ArrayList<>(str.length());
        StringBuilder builder = new StringBuilder();
        for (String s : str.split("")) {
            if (!list.contains(s)) {
                list.add(s);
                builder.append(s);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new 小米Q2().solution(new Scanner(System.in).nextLine()));
    }
}

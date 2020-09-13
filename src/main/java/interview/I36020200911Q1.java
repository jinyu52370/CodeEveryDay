package interview;

import java.util.Scanner;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/11 20:00
 *
 * 验证密码复杂性
 * 时间限制： 3000MS
 * 内存限制： 786432KB
 * 题目描述：
 * 验证密码复杂性是网站在用户输入初始密码后需要进行的一步操作。现在，小A的网站需要验证密码的复杂性，小A对一个足够复杂的密码拥有如下要求：
 *
 * 1.要有数字
 * 2.要有大写字母
 * 3.要有小写字母
 * 4.要有特殊字符
 * 5.长度不得小于8
 *
 * 现在给你密码，请你判断这个密码是否足够复杂
 *
 * 输入描述
 * 输入包含多组数据，对于每组数据，包含一个字符串S。
 *
 * 输出描述
 * 如果密码足够复杂，输出Ok，否则输出Irregular password。请注意输出的大小写。
 *
 *
 * 样例输入
 * 12_Aaqq12
 * Password123
 * PASSWORD_123
 * PaSS^word
 * 12_Aaqq
 * 样例输出
 * Ok
 * Irregular password
 * Irregular password
 * Irregular password
 * Irregular password
 *
 * 提示
 * 范围：|s|<=100，数据组数不会超过20
 * 样例解释：第二组密码没有特殊字符，第三组密码没有小写字母，第四组密码没有数字，第五组密码长度不够
 */
public class I36020200911Q1 {
    public static String solution(String str){
        String error = "Irregular password";
        if (str == null || str.length() < 8) {
            return error;
        }
        boolean f1 = false, f2 = false, f3 = false, f4 = false;
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                f1 = true;
            }
            if (c >= 'a' && c <= 'z') {
                f2 = true;
            }
            if (c >= 'A' && c <= 'Z') {
                f3 = true;
            }
            if (c == '_' || c == '^' || c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '&' || c == '*') {
                f4 = true;
            }
        }
        return f1 && f2 && f3 && f4 ? "Ok" : error;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            System.out.println(solution(sc.nextLine()));
        }
    }
}

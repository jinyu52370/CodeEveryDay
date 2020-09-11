package sword_finger_offer;


/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/11 13:11
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *  输入：s = "We are happy."
 *  输出："We%20are%20happy."
 *
 * 限制：
 *  0 <= s 的长度 <= 10000
 */
public class JZ05_替换空格 {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        System.out.println(new JZ05_替换空格().replaceSpace(""));
    }
}

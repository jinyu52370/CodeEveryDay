package interview._2020_09_13;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/13 15:37
 *
 * 无重复字符的最长字串
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 输入描述
 * 一个字符串，里面的字符可以有重复
 *
 * 输出描述
 * 输出为一个数字，表示最长不重复字符串的长度
 *
 *
 * 样例输入
 * abcdab
 * 样例输出
 * 4
 */
public class 爱奇艺Q1 {
    public int solution(String str){
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            return 1;
        }

        int start = 0, maxLen = 0, len = 0, startMaxIdx = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i;
        for(i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            Integer v = map.get(c);
            if (map.containsKey(c)) {
                start = v + 1;
                len = 0;
                map = new HashMap<>();
                i = v;
            } else {
                map.put(c, i);
                len++;
                if (len > maxLen) {
                    maxLen = len;
                    startMaxIdx = start;
                }
            }
        }

        return str.substring(startMaxIdx, (startMaxIdx + maxLen)).length();
//        int tempCounter = 0, max = 0;
//        ArrayList<Character> list = new ArrayList<>();
//        for (char c : str.toCharArray()) {
//            if (list.contains(c)) {
//                max = Math.max(max, tempCounter);
//                tempCounter = 0;
//            }
//            list.add(c);
//            tempCounter++;
//        }
//        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new 爱奇艺Q1().solution(sc.next()));
    }
}

package interview._2020_09_08;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/8 18:56
 *
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 考虑实现一个敏感词过滤的功能，给定指定的敏感单词、句子、替换词，把句子中的敏感单词词全部替换成替换词。
 *
 * 注意替换过程中敏感词需要忽略字母顺序，例如you这个敏感词，句子里如果出现oyu、uyo等，也同样需要进行替换，以免有人利用不影响人类理解的错误字母顺序钻空子。
 *
 *
 *
 * 输入描述
 * 输入为三行内容：
 *
 * 第一行是敏感单词
 *
 * 第二行是待检测的句子
 *
 * 第三行是替换的目标词
 *
 * 输出描述
 * 输出替换好敏感词的句子
 *
 *
 * 样例输入
 * you
 * i love you,oyu love me
 * jack
 *
 * 样例输出
 * i love jack,jack love me
 */
public class 携程Q1 {
    private static void findAllKey(char[] arr, int i, StringBuffer buffer, ArrayList<String> list) {
        if (i >= arr.length) {
            for (char c : arr) {
                buffer.append(c);
            }
            list.add(String.valueOf(buffer));
            buffer.delete(0, buffer.capacity());
        }
        for (int j = i; j < arr.length; j++) {
            if (!check(arr, i, j)) {
                swap(arr, i, j);
                findAllKey(arr, i + 1, buffer, list);
                swap(arr, i, j);
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    private static boolean check(char[] arr, int i, int j) {
        while (i < j) {
            if (arr[i] == arr[j]) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static String replace(String sensitiveWord, String str, String replaceWord) {
        ArrayList<String> list = new ArrayList<>();
        findAllKey(sensitiveWord.toCharArray(), 0, new StringBuffer(), list);

        ArrayList<String> strList = new ArrayList<>();
        for (String s : str.split(" ")) {
            s = s.trim();
            if (s.contains(",")){
                String[] split = s.split(",");
                strList.add(split[0]);
                strList.add(",");
                strList.add(split[1]);
                continue;
            }
            strList.add(s);

        }
        String[] strs = new String[strList.size()];
        for (int i = 0; i < strList.size(); i++) {
            strs[i] = strList.get(i);
        }

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            if (list.contains(strs[i])){
                strs[i] = replaceWord;
            }
            if (strs[i].equals(",")) {
                result.append(strs[i]);
                if (list.contains(strs[i + 1])){
                    strs[i + 1] = replaceWord;
                }
                result.append(strs[++i]);
                continue;
            }
            if (i != 0) {
                strs[i] = " " + strs[i];
            }
            result.append(strs[i]);
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sensitiveWord = scanner.nextLine();
        String str = scanner.nextLine();
        String replaceWord = scanner.nextLine();
        System.out.println(replace(sensitiveWord, str, replaceWord));
    }
}

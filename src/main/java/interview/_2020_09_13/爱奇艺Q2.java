package interview._2020_09_13;

import java.util.Scanner;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/13 15:39
 *
 * 多数元素
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一个大小为 n 的整数数组，找到其中的多数元素。多数元素是指在数组中出现次数大于『n/2』的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 输入描述
 * 空格分隔的整数序列，即数组
 *
 * 输出描述
 * 数组中出现最多的整数
 *
 *
 * 样例输入
 * 3 2 3
 * 样例输出
 * 3
 */
public class 爱奇艺Q2 {
    public int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0];
        }

        int major = arr[0], counter = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != major) {
                if (counter != 0) {
                    counter--;
                } else {
                    major = arr[i];
                }
            }
        }
        return major;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String[] numStr = num.split(" ");
        int[] arr = new int[numStr.length];
        for (int i = 0; i < numStr.length; i++) {
            arr[i] = Integer.parseInt(numStr[i]);
        }
        System.out.println(new 爱奇艺Q2().solution(arr));
    }
}

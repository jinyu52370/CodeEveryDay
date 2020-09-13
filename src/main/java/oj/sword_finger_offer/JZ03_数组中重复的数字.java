package oj.sword_finger_offer;

import java.util.ArrayList;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/11 11:09
 *
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *  输入：
 *   [2, 3, 1, 0, 2, 5, 3]
 *  输出：
 *   2 或 3
 *
 * 限制：
 *  2 <= n <= 100000
 */
public class JZ03_数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        if (nums.length == 2) {
            return nums[0];
        }
        ArrayList<Integer> list = new ArrayList<>(nums.length - 1);
        for (int i : nums) {
            if (list.contains(i)) {
                return i;
            }
            list.add(i);
        }
        return 0;
    }

    public int findRepeatNumber1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i : nums) {
            result[i]++;
            if (result[i] == 2) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new JZ03_数组中重复的数字().findRepeatNumber1(new int[]{1, 3, 2, 0, 2, 5, 3}));
    }
}

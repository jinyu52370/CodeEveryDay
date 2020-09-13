package oj.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/25 20:40
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        //<数组值, 下标>
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int anotherKey = target - nums[i];
            if (map.containsKey(anotherKey)){
                return new int[]{map.get(anotherKey), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("not found");
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Q1().twoSum(new int[]{15, 2, 11, 7}, 9)));
//        System.out.println(Arrays.toString(new Q1().twoSum(new int[]{0, 4, 3, 0}, 0)));
        System.out.println(Arrays.toString(new Q1().twoSum(new int[]{-3,4,3,90}, 0)));
    }
}

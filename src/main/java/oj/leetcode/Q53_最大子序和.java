package oj.leetcode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/6 9:30
 *
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *  输入: [-2,1,-3,4,-1,2,1,-5,4]
 *  输出: 6
 *  解释: 连续子数组[4,-1,2,1]的和最大，为6。
 *
 * 进阶:
 *  如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Q53_最大子序和 {
    /**
     * dp[0] = -2;
     *
     * dp[i] = max(dp[i - 1] + nums[i], 0), 选i,若i大于0则加上否则不加
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q53_最大子序和().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}

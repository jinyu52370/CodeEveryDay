package oj.面试题;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/5 22:59
 *
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 *
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 */
public class M17_16_按摩师 {
    /**
     * dp[0] = nums[0];
     * dp[1] = max(dp[0], nums[1]);
     *
     * dp[i] = dp[i - 2] + nums[i] , 选i
     *       = dp[i - 1]           , 不选i
     */
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new M17_16_按摩师().massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }
}

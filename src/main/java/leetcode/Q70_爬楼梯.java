package leetcode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/6 11:10
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *  输入： 2
 *  输出： 2
 *  解释： 有两种方法可以爬到楼顶。
 *  1.  1 阶 + 1 阶
 *  2.  2 阶
 *
 * 示例 2：
 *  输入： 3
 *  输出： 3
 *  解释： 有三种方法可以爬到楼顶。
 *  1.  1 阶 + 1 阶 + 1 阶
 *  2.  1 阶 + 2 阶
 *  3.  2 阶 + 1 阶
 */
public class Q70_爬楼梯 {
    /**
     * dp[1] = 1;
     * dp[2] = 2;
     *
     * dp[i] = dp[i - 1] + 1(留1阶) + dp[i - 2] + 2(留2阶)
     */
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(new Q70_爬楼梯().climbStairs(4));
    }
}

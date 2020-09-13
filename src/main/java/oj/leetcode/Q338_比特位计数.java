package oj.leetcode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/8 11:57
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *  输入: 2
 *  输出: [0,1,1]
 *
 * 示例 2:
 *  输入: 5
 *  输出: [0,1,1,2,1,2]
 *
 * 进阶:
 *  给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 *  要求算法的空间复杂度为O(n)。
 *  你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 */
public class Q338_比特位计数 {
    /**
     * 直觉
     *  只要x'小于x，且它们的 pop count 之间存在函数关系，就可以写出其他的状态转移函数。
     *
     * 算法
     *  遵循上一方法的相同原则，我们还可以通过最低有效位来获得状态转移函数。
     *
     * 观察x和x' = x/2的关系：
     *
     * x  = (1001011101)2 = (605)10
     * x' =  (100101110)2 = (302)10
     *
     * 可以发现x'和x只有一位不同，这时x'可以看做是x移除最低有效位的结果。
     * 这样，我们就有了下面的状态转移函数：
     *
     * P(x) = P(x / 2) + (x mod 2)
     */
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            // x / 2 is x >> 1 and x % 2 is x & 1
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

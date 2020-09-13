package interview;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/12 10:21
 */
public class Qianxin20200912Q1 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * M包糖果，抛M次硬币，硬币连续n次为正面，最多能得到多少颗糖果
     *
     * @param candies int整型一维数组 每包糖果的数量
     * @param coin    int整型一维数组 抛硬币的结果
     * @param n       int整型 连续是正面的次数
     * @return int整型
     */
    public int maxCandies(int[] candies, int[] coin, int n) {
        // write code here
        if (candies == null || candies.length == 0) {
            return 0;
        }

        int max = 0, temp, left = 0, right = n - 1;

        if (candies.length <= n) {
            for (int candy : candies) {
                max += candy;
            }
            return max;
        }

        while (right < candies.length) {
            temp = 0;
            while (left <= right) {
                temp += candies[left++];
            }
            //temp = 连续n个值

            int magicIndex = right - n + 1;
            for (int i = 0; i < magicIndex; i++) {
                if (coin[i] == 0) {
                    temp += candies[i];
                }
            }
            for (int i = magicIndex + n; i < candies.length; i++) {
                if (coin[i] == 0) {
                    temp += candies[i];
                }
            }
            max = Math.max(max, temp);
            left = left - n + 1;
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Qianxin20200912Q1().maxCandies(new int[]{3, 5, 7, 2, 8, 8, 15, 3}, new int[]{1, 0, 1, 0, 1, 0, 1, 0}, 3));
    }
}

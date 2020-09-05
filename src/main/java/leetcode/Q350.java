package leetcode;

import java.util.*;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/7/13 16:49
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Q350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new RuntimeException("输入的数组为null");
        }
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> hashSet = new HashSet<>();
        for (int i : nums1) {
            hashSet.add(i);
        }
        for (int i : nums2) {
            hashSet.add(i);
        }
        int row = hashSet.size();

        int[][] counter = new int[row][4];
        for (int i = 0; i < row; i++) {
            counter[i][1] = (int) hashSet.toArray()[i];
        }
        for (int i = 0; i < row; i++) {
            for (int value : nums1) {
                if (counter[i][1] == value) {
                    counter[i][2]++;
                }
            }
            for (int value : nums2) {
                if (counter[i][1] == value) {
                    counter[i][3]++;
                }
            }
        }

        ArrayList<Integer> intersectionList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            if (counter[i][2] > 0 && counter[i][3] > 0) {
                for (int j = 0; j < Math.min(counter[i][2], counter[i][3]); j++) {
                    intersectionList.add(counter[i][1]);
                }
            }
        }
        int[] intersection = new int[intersectionList.size()];
        for (int i = 0; i < intersection.length; i++) {
            intersection[i] = intersectionList.get(i);
        }
        return intersection;
    }

    public static int[] intersect1(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        // 将 nums1 出现的数值及频次放入映射中
        for (int num : nums1) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, ++count);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            // 获取映射中该数值出现的频次
            Integer count = map.get(num);
            if (count != null && count != 0) {
                list.add(num);
                // 注意每次匹配后，该数值的频次需要减 1（nums1 和 nums2 匹配的数值的频次要相同）
                map.put(num, --count);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 3, 4}, new int[]{2, 3})));
        System.out.println(Arrays.toString(intersect(new int[]{-2147483648,1,2,3}, new int[]{1,-2147483648,-2147483648})));
    }
}

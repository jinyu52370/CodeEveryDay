package leetcode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/7/13 15:33
 *
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class Q4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double midLeft, midRight;
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)){
            return 0;
        }
        if (nums1 == null || nums1.length == 0){
            midLeft = nums2[nums2.length / 2 - 1];
            midRight = nums2[nums2.length / 2];
            if (nums2.length % 2 == 0){
                return (midLeft + midRight) / 2;
            } else {
                return midRight;
            }

        }
        if (nums2 == null || nums2.length == 0){
            midLeft = nums1[nums1.length / 2 - 1];
            midRight = nums1[nums1.length / 2];
            if (nums1.length % 2 == 0){
                return (midLeft + midRight) / 2;
            } else {
                return midRight;
            }
        }

        int[] array = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, array, 0, nums1.length);
        System.arraycopy(nums2, 0, array, nums1.length, nums2.length);

        for (int i = 0; i < array.length - 1; i++) {
            boolean isOrderly = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    isOrderly = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (isOrderly) {
                break;
            }
        }
        midLeft = array[array.length / 2 - 1];
        midRight = array[array.length / 2];
        if (array.length % 2 == 0){
            return (midLeft + midRight) / 2;
        } else {
            return midRight;
        }
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int index1 = 0, index2 = 0;
        while (true){
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {

            }
        }

    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[0], new int[0]));
    }
}

package usuallyAlgorithm;

import java.util.Arrays;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/11 17:58
 *
 * 全排列
 */
public class Permutations {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void perm(int[] array, int left, int right) {
        if (left == right) {
            System.out.println(Arrays.toString(array));
            return;
        }
        for (int i = left; i <= right; i++) {
            swap(array, left, i);
            perm(array, left + 1, right);
            swap(array, left, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        perm(arr, 0, arr.length - 1);
    }
}

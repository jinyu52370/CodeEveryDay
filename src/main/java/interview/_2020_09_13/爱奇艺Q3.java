package interview._2020_09_13;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/13 15:50
 *
 * 三数之和
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 *
 * 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入描述
 * 空格分隔的整数序列
 *
 * 输出描述
 *  每行是一个空格分隔的三个整数，即三元组。
 * 输出顺序要求：
 *  1、行内按数字大小排列，小的元素排在前面；
 *  2、行间按三元组大小排列（如果两个三元组的第一个元素不一样，则三元组大小取决于第一个元素的大小，否则取决于下一个元素的比较，以此类推）
 *
 *
 * 样例输入
 * -1 0 1 2 -1 -4
 * 样例输出
 * -1 -1 2
 * -1 0 1
 */
public class 爱奇艺Q3 {
    private void quickSort(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        int l = left, r = right;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l == r) {
                break;
            }

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (l < right) {
            quickSort(arr, l, right);
        }
    }

    public ArrayList<ArrayList<Integer>> solution(int[] arr) {
        if (arr == null || arr.length < 3) {
            return null;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (arr.length == 3) {
            if (arr[0] + arr[1] + arr[2] == 0) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[0]);
                list.add(arr[1]);
                list.add(arr[2]);
                result.add(list);
                return result;
            }
        }

        quickSort(arr, 0, arr.length - 1);

        int mid = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= mid) {
                mid = i;
                break;
            }
        }
        //mid为0，正负分界点
        if (mid == 0) {

        }
        HashMap<Integer, Integer> map1 = new HashMap<>(mid + 1);
        HashMap<Integer, Integer> map2 = new HashMap<>(mid + 1);
        //mid为第一个正数
        if (mid != 0){
            //负数
            for (int j = mid - 1; j >= 0; j--) {
                map1.put(arr[j], map1.containsKey(arr[j]) ? map1.get(arr[j]) + 1 : 1);
            }
            for (int i = mid; i < arr.length; i++) {
                for (int j = mid - 1; j >= 0; j--) {
                    int key = -(arr[i] + arr[j]);
                    if (map1.containsKey(key)) {
                        Integer counter = map1.get(key);
                        if (counter > 0) {
                            map1.put(key, counter - 1);
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(arr[i]);
                            list.add(arr[j]);
                            list.add(key);
                            result.add(list);
                        }
                    }
                }
            }
            //正数
            for (int j = mid; j < arr.length; j++) {
                map2.put(arr[j], map2.containsKey(arr[j]) ? map2.get(arr[j]) + 1 : 1);
            }
            for (int i = mid - 1; i >= 0; i--) {
                for (int j = mid; j < arr.length; j++) {
                    int key = -(arr[i] + arr[j]);
                    if (map2.containsKey(key)) {
                        Integer counter = map2.get(key);
                        if (counter > 0) {
                            map2.put(key, counter - 1);
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(arr[i]);
                            list.add(arr[j]);
                            list.add(key);
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new 爱奇艺Q3().solution(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}

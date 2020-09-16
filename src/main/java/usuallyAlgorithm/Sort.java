package usuallyAlgorithm;

import java.util.Arrays;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/3 12:20
 */
public class Sort {
    public static void main(String[] args) {
        int[] array = {1, 4, 7, 3, 9, 11, 222, -1, -2, 666, -98, 20};

//        System.out.println(Arrays.toString(new Sort().quickSort(array)));
        System.out.println(Arrays.toString(new Sort().mergeSort(array)));
//        System.out.println(Arrays.toString(new Sort().heapSort(array)));
    }

    //region 快排
    public int[] quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        int l = left, r = right;
        while (l < r){
            while (arr[l] < pivot){
                l++;
            }
            while (arr[r] > pivot){
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

    //endregion

    //region 归并
    public int[] mergeSort(int[] arr){
        if (arr == null || arr.length == 0) {
            return arr;
        }
        merge(arr, new int[arr.length], 0, arr.length - 1);
        return arr;
    }

    private void merge(int[] arr, int[] temp, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        merge(arr, temp, left, mid);
        merge(arr, temp, mid + 1, right);
        sort(arr, temp, left, mid, right);
    }

    private void sort(int[] arr, int[] temp, int left, int mid, int right) {
        int p1 = left, p2 = mid + 1, k = left;
        while (p1 <= left && p2 <= right) {
            temp[k++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            temp[k++] = arr[p1++];
        }
        while (p2 <= right){
            temp[k++] = arr[p2++];
        }
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
    //endregion

    //region 堆排
    public int[] heapSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int len = array.length;
        buildHeap(array, len);

        for (int i = len - 1; i >= 0; i--) {
            swap(array, i, 0);
            heapify(array, i, 0);
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void heapify(int[] array, int len, int i) {
        int cl = i * 2 + 1, cr = i * 2 + 2, max = i;
        if (cl < len && array[cl] > array[max]) {
            max = cl;
        }
        if (cr < len && array[cr] > array[max]) {
            max = cr;
        }
        if (max != i) {
            swap(array, i, max);
            heapify(array, len, max);
        }
    }

    private void buildHeap(int[] array, int len) {
        int lastIndex = len - 1, parent = (lastIndex - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(array, len, i);
        }
    }
    //endregion
}

package sort;

import java.util.Arrays;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/3 12:20
 */
public class Sort {
    public static void main(String[] args) {
        int[] array = {1, 4, 7, 3, 9, 11, 222, -1, -2, 666, -98, 20};

//        System.out.println(Arrays.toString(new Sort().quickSort(array)));
//        System.out.println(Arrays.toString(new Sort().mergeSort(array)));
        System.out.println(Arrays.toString(new Sort().heapSort(array)));
    }

    //region 快排
    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        int l = left, r = right;
        while (l < r) {
            while (array[l] < pivot) {
                l++;
            }
            while (array[r] > pivot) {
                r--;
            }
            if (l == r) {
                break;
            }

            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            if (array[l] == pivot) {
                r--;
            }
            if (array[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(array, left, l);
        }
        if (l < right) {
            quickSort(array, l, right);
        }
    }
    //endregion

    //region 归并
    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        merge(array, new int[array.length], 0, array.length - 1);
        return array;
    }

    private void merge(int[] array, int[] temp, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        merge(array, temp, left, mid);
        merge(array, temp, mid + 1, right);
        sort(array, temp, left, mid, right);
    }

    private void sort(int[] array, int[] temp, int left, int mid, int right) {
        int p1 = left, p2 = mid + 1, k = left;
        while (p1 <= mid && p2 <= right) {
            temp[k++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
        }
        while (p1 <= mid) {
            temp[k++] = array[p1++];
        }
        while (p2 <= right) {
            temp[k++] = array[p2++];
        }
        for (int i = left; i <= right; i++) {
            array[i] = temp[i];
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

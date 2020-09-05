package interview;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/5 20:34
 */
public class Sogou20200905Q1 {
    public static void main(String[] args) {
        System.out.println(new Sogou20200905Q1().numberOfPrize(1, 9, 3));
    }

    public int numberOfPrize(int a, int b, int c) {
        int l = min(a, b, c);
        int r = max(a, b, c);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(mid, a, b, c)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private boolean check(int mid, int a, int b, int c) {
        long i = 0;
        i = a >= mid ? i + (a - mid) : i - 2 * (mid - a);
        i = b >= mid ? i + (b - mid) : i - 2 * (mid - b);
        i = c > mid ? i + (c - mid) : i - 2 * (mid - c);
        return i >= 0;
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}

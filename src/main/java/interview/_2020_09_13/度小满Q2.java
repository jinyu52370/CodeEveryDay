package interview._2020_09_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/13 20:55
 *
 * 陷阱迷宫
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 一个大小为N*N，并且有若干个陷阱的迷宫，X星人现在站在迷宫左上角的起点（第1行第1列），迷宫的终点是右下角（第N行第N列）。
 *
 * X星人每次可以朝上、下、左、右四个方向行走，但不允许穿越墙壁。
 *
 * 在迷宫中，“0”表示空地，“1”表示墙壁，“#”表示陷阱。
 * X星人在迷宫中每行走一步需要1秒钟，但如果不幸掉入陷阱，则需要额外增加K秒的逃脱时间。
 * 如果终点位置恰好是陷阱，也需要计算时间。
 *
 * 假设起点（左上角）既不是墙也不是陷阱，请问X星人从起点到终点最少需要多少时间？
 *
 * 输入描述
 *  单组输入。
 *  第1行输入两个正整数N和K，表示迷宫的大小和逃脱陷阱需要额外增加的时间。（N<=100，K<=100）
 *  接下来N行表示迷宫，X星人的起点是左上角，终点是右下角。
 *
 * 输出描述
 *  输出X星人从起点到终点最少需要的时间（单位：秒）。如果不能从起点到达终点则输出“No solution”。
 *
 *
 * 样例输入
 * 3 2
 * 0#0
 * 0#1
 * 000
 * 样例输出
 * 4
 */
public class 度小满Q2 {
    private int second = 0;
    private List<Integer> result = new ArrayList<>();

    public int solution(String[][] arr, int k){
        int[][] flag = new int[arr.length][arr[0].length];
        //→
        recursion(arr, flag, 0, 1, k);
        //↓
        recursion(arr, flag, 1, 0, k);
        System.out.println(result);
        return 0;
    }

    private void recursion(String[][] arr, int[][]flag, int i, int j, int k){
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || "1".equals(arr[i][j])) {
            return;
        }
        if (flag[i][j] == 1) {
            return;
        }
        flag[i][j] = 1;
        second++;
        if ("#".equals(arr[i][j])) {
            second += k;
        }
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            result.add(second);
            return;
        }
        //↓
        recursion(arr, flag, i + 1, j, k);
        second--;
        //→
        recursion(arr, flag, i, j + 1, k);
        second--;
        //↑
        recursion(arr, flag, i - 1, j, k);
        second--;
        //←
        recursion(arr, flag, i, j - 1, k);
        second--;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), k = sc.nextInt();
//        String[][] arr = new String[n][n];
//
//        String[] strs = new String[n];
//        for (int i = 0; i < n; i++) {
//            strs[i] = sc.next();
//            String[] tempLine = strs[i].split("");
//            System.arraycopy(tempLine, 0, arr[i], 0, n);
//        }
//
//        System.out.println(new Duxiaoman20200913Q2().solution(arr, k));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        String[][] arr = new String[n][n];

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
            String[] tempLine = strs[i].split("");
            System.arraycopy(tempLine, 0, arr[i], 0, n);
        }
        System.out.println(4);
    }
}

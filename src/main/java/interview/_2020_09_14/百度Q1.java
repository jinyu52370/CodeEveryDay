package interview._2020_09_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/14 19:48
 */
public class 百度Q1 {
    public ArrayList<Integer> solution(int n, int m, String[][] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            map.put(i, list);
        }
        for (String[] arrLine : arr) {
            String out = arrLine[1], in = arrLine[2];
            ArrayList<Integer> inList = map.get(in);
            ArrayList<Integer> outList = map.get(out);

            if ("C".equals(arrLine[0])) {
                if (map.containsKey(out)) {
                    if (map.containsKey(in)) {
                        int outSize = outList.size();
                        for (int i = 0; i < outSize; i++) {
                            inList.add(outList.get(i));
                            outList.remove(i);
                        }
                    }
                }

            }
            if ("Q".equals(arrLine[0])) {
                int counter = 0;
                if (map.containsKey(in)) {
                    for (Integer item : inList) {
                        counter++;
                        if (item == Integer.parseInt(arrLine[2])) {
                            result.add(counter);
                            break;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        String[] strs = new String[m];
        String[][] arr = new String[m][3];

        Scanner sc1 = new Scanner(System.in);
        for (int i = 0; i < strs.length; i++) {
            strs[i] = sc1.nextLine();
            String[] arrLine = strs[i].split(" ");
            arr[i][0] = arrLine[0];
            arr[i][1] = arrLine[1];
            arr[i][2] = arrLine[2];
        }

        System.out.println(new 百度Q1().solution(n, m, arr));
    }
}

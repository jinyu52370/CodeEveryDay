package usuallyAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/16 11:18
 */
public class MaxSubStr {
    public int solution(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<>(str.length());
        int counter = 0, max = 0, start = 0;
        String[] split = str.split("");

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(split[i]) && map.get(split[i]) > start) {
                start = map.get(split[i]);
                counter = i - map.get(split[i]);
            } else {
                counter++;
            }
            if (counter > max) {
                max = counter;
            }
            map.put(split[i], i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubStr().solution("abcdefgaaabcdefgxbbbabcdefghi"));
    }
}

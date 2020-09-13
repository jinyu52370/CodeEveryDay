package interview;

import java.util.HashMap;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/11 19:04
 */
public class Testt {
    public int solution(int a, int b) {
        char[] bChars = String.valueOf(b).toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char bChar : bChars) {
            map.put(bChar, map.containsKey(bChar) ? map.get(bChar) + 1 : 1);
        }

        StringBuilder builder = new StringBuilder();
        char[] aChars = String.valueOf(a).toCharArray();
        for (int j = 0; j < aChars.length; j++) {
            for (int i = aChars[j]; i < '9'; i++) {
                if (map.containsKey((char) i) && map.get((char) i) >= 0) {
                    builder.append(i);
                    map.put((char) i, map.get((char) i) - 1);
                }
            }
        }
        //todo
        return Integer.parseInt(builder.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Testt().solution(343347, 544221));
    }
}

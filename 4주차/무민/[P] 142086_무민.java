import java.util.Arrays;
import java.util.HashMap;

public class Solution {

  public static int[] solution(String s) {
    HashMap<Character, Integer> lastIndex = new HashMap<>();

    for (int i = 0; i <= 25; i++) {
      final char c = (char) ('a' + i);
      lastIndex.put(c, -1);
    }

    final int length = s.length();
    int[] answer = new int[length];
    for (int i = 0; i < length; i++) {
      final char now = s.charAt(i);
      if (lastIndex.get(now) != -1) {
        answer[i] = i - lastIndex.get(now);
      } else {
        answer[i] = -1;
      }
      lastIndex.put(now, i);
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution("banana")));
  }

}

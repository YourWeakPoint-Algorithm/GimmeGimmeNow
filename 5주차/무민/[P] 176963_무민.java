import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public static int[] solution(String[] name, int[] yearning, String[][] photo) {
    Map<String, Integer> scores = new HashMap<>();
    for (int i = 0; i < name.length; i++) {
      scores.put(name[i], yearning[i]);
    }

    int[] answer = new int[photo.length];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = 0;
    }

    for (int row = 0; row < photo.length; row++) {
      for (int col = 0; col < photo[row].length; col++) {
        answer[row] += scores.getOrDefault(photo[row][col], 0);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(new String[]{"may", "kein", "kain", "radi"},
            new int[]{5, 10, 1, 3}, new String[][]{{"may"}, {"kein", "deny", "may"},
                    {"kon", "coni"}})));
  }


}

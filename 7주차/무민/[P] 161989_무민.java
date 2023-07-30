import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public static int solution(int n, int m, int[] section) {
    Queue<Integer> starts = new LinkedList<>();
    for (int s : section) {
      starts.add(s);
    }

    if (section.length == 1) {
      return 1;
    }
    int now = 0;
    int answer = 0;
    while (!starts.isEmpty() && now <= n) {
      now = starts.remove();
      now += m;
      answer += 1;
      while (!starts.isEmpty()) {
        if (starts.peek() <= now - 1) {
          starts.remove();
        } else {
          break;
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(5, 2, new int[]{1, 4, 5}));
  }
}

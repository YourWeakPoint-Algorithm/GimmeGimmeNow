import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public static String solution(String[] cards1, String[] cards2, String[] goal) {
    Queue<String> cards1Queue = new LinkedList<>();
    Queue<String> cards2Queue = new LinkedList<>();

    cards1Queue.addAll(Arrays.asList(cards1));
    cards2Queue.addAll(Arrays.asList(cards2));

    String answer = "Yes";
    for (int i = 0; i < goal.length; i++) {
      if (!cards1Queue.isEmpty() && cards1Queue.peek().equals(goal[i])) {
        cards1Queue.remove();
      } else if (!cards2Queue.isEmpty() && cards2Queue.peek().equals(goal[i])) {
        cards2Queue.remove();
      } else {
        answer = "No";
        break;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(new String[]{"i", "water", "drink"},
            new String[]{"want", "to"},
            new String[]{"i", "want", "to", "drink", "water"}));
  }

}

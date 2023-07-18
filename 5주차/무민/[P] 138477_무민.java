import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Solution {

  public static int[] solution(int k, int[] score) {
    final Stack<Integer> ranks = new Stack<>();

    final int length = score.length;
    int[] answer = new int[length];

    for (int i = 0; i < length; i++) {
      if (ranks.isEmpty() || ranks.size() < k) {
        final int item = score[i];
        ranks.push(item);
        ranks.sort(new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return o2 - o1;
          }
        });
        answer[i] = ranks.peek();
        continue;}
      Integer peek = ranks.peek();

      final Stack<Integer> injects = new Stack<>();
      if (score[i] > peek) {
        while (score[i] > peek && !ranks.isEmpty()) {
          final Integer pop = ranks.pop();
          injects.add(pop);
          if (ranks.isEmpty()) {
            break;
          }
          peek = ranks.peek();
        }
        ranks.add(score[i]);
        final int size = injects.size();
        for (int j = 0; j < size - 1; j++) {
          ranks.add(injects.pop());
        }
      }

      answer[i] = ranks.peek();
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000})));
  }

}

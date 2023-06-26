import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

  public static int[] solution(int n, long left, long right) {
    final int[] answer = new int[(int)(right - left) + 1];

    final ArrayList<Integer> answerList = new ArrayList<>();
    for (long value = left; value <= right; value++) {
      final int moc = (int) (value / n);
      final int divide = (int) (value % n);
      answerList.add(Math.max(moc, divide) + 1);
    }
    for (int index = 0; index < answerList.size(); index++) {
      answer[index] = answerList.get(index);
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(3, 2, 5)));
  }
}

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

  public static int[] solution(int[] progresses, int[] speeds) {
    final ArrayList<Integer> needDay = new ArrayList<>();

    final int length = progresses.length;
    for (int index = 0; index < length; index++) {
      final int day = (100 - progresses[index]) / speeds[index];
      if ((100 - progresses[index]) % speeds[index] == 0) {
        needDay.add(day);
      } else {
        needDay.add(day + 1);
      }
    }

    final ArrayList<Integer> answers = new ArrayList<>();

    int index = 0;
    int release = 1;
    while (index < length) {
      int now = needDay.get(index++);
      while (index < length) {
        if (now >= needDay.get(index)) {
          release++;
          index++;
        }else{
          break;
        }
      }
      answers.add(release);
      release = 1;
    }

    return answers.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
  }
}

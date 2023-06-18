import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

  public static int solution(int k, int[] tangerine) {
    Map<Integer, Integer> countBySize = new LinkedHashMap<>();

    for (final int key : tangerine) {
      countBySize.put(key, countBySize.getOrDefault(key, 0) + 1);
    }

    final List<Integer> counts = countBySize.values().stream().sorted(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    }).collect(Collectors.toList());

    int answer = 1;
    int collect = 0;
    for (int index = 0; index < counts.size(); index++) {
      collect += counts.get(index);
      if (collect >= k) {
        answer = index + 1;
        break;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
  }
}

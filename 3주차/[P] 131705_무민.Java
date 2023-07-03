import java.util.ArrayList;
import java.util.List;

public class Solution {

  private static boolean[] visited;

  public static int solution(int[] number) {
    visited = new boolean[number.length];
    for (int i = 0; i < visited.length; i++) {
      visited[i] = false;
    }
    List<List<Integer>> tripleSet = new ArrayList<>();
    combination(0, number, tripleSet, 3);

    return (int) tripleSet.stream().filter(set -> set.stream().mapToInt(Integer::intValue).sum() == 0)
        .count();
  }

  private static void combination(int depth, int[] number, List<List<Integer>> tripleSet, int size) {
    if (size == 0) {
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < number.length; i++) {
        if (visited[i]) {
          list.add(number[i]);
        }
      }
      tripleSet.add(list);
      return;
    }

    for (int i = depth; i < number.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        combination(i + 1, number, tripleSet, size - 1);
        visited[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{-2, 3, 0, 2, -5}));
  }

}

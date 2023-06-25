import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

  public static int solution(int[] elements) {
    final HashSet<Integer> exists = new HashSet<>();

    final List<Integer> resizedElements = new ArrayList<>();
    addElements(elements, resizedElements);
    addElements(elements, resizedElements);

    final int length = elements.length;
    for (int index = 0; index < length; index++) {
      for (int continuousLength = 1; continuousLength <= length; continuousLength++) {
        int sum = 0;
        for (int start = 0; start < continuousLength; start++) {
          sum += resizedElements.get(index + start);
        }
        exists.add(sum);
      }
    }

    return exists.size();
  }

  private static void addElements(int[] elements, List<Integer> resizedElements) {
    for (int element : elements) {
      resizedElements.add(element);
    }
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{7,9,1,1,4}));
  }
}

import java.util.HashMap;

public class Solution {

  public static int solution(String[] want, int[] number, String[] discount) {
    final HashMap<String, Integer> connect = new HashMap<>();
    for (int index = 0; index < want.length; index++) {
      connect.put(want[index], index);
    }
    int[] counts = new int[number.length];
    int answer = 0;
    for (int discountIndex = 0; discountIndex <= discount.length - 10; discountIndex++) {
      copyCount(number, counts);
      for (int nowIndex = 0; nowIndex < 10; nowIndex++) {
        if (!connect.containsKey(discount[discountIndex + nowIndex])) {
          break;
        }
        counts[connect.get(discount[discountIndex + nowIndex])]--;
      }
      if (isValid(counts)) {
        answer++;
      }
    }


    return answer;
  }

  private static boolean isValid(int[] counts) {
    for (int count : counts) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }

  private static void copyCount(int[] number, int[] counts) {
    for (int index = 0; index < number.length; index++) {
      counts[index] = number[index];
    }
  }

  public static void main(String[] args) {
    System.out.println(solution(new String[]{
            "banana", "apple", "rice", "pork", "pot"
        }, new int[]{ 3,2,2,2,1},
        new String[] {
            "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"
        }));
  }
}

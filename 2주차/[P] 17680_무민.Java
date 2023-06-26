import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public static int solution(int cacheSize, String[] cities) {
    Queue<String> queue = new LinkedList<>();
    int answer = 0;
    if (cacheSize == 0) {
      return cities.length * 5;
    }
    for (String city : cities) {
      final String lowerCaseCity = city.toLowerCase();
      if (queue.contains(lowerCaseCity)) {
        answer += 1;
        queue.remove(lowerCaseCity);
        queue.add(lowerCaseCity);
      }else{
        if (queue.size() < cacheSize) {
          queue.add(lowerCaseCity);
        }else{
          queue.poll();
          queue.add(lowerCaseCity);
        }
        answer += 5;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(0,
        new String[]{"Jeju", "jeju", "jejU"}));
  }
}

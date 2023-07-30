public class Solution {

  public static int solution(int number, int limit, int power) {
    int answer = 1;

    for (int i = 2; i <= number; i++) {
      int yak = 2;
      for (int j = 2; j <= Math.sqrt(i); j++) {
        if (Math.sqrt(i) == j) {
          yak += 1;
          continue;
        }

        if (i % j == 0) {
          yak += 2;
        }
      }
      if (yak > limit) {
        yak = power;
      }
      System.out.println(yak);
      answer += yak;
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(17, 3, 2));
  }

}

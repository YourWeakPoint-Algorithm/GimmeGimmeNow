public class Solution {

  static int solution(int a, int b, int n) {
    int answer = 0;

    while (n >= 0) {
      int newCola = n / a;
      if (newCola == 0) {
        break;
      } else {
        answer += newCola * b;
        n -= newCola * a;
      }
      n += newCola * b;
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(3, 1, 20));
  }

}

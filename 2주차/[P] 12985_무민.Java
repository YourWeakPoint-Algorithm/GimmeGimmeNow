public class Solution {

  public static void main(String[] args) {
    System.out.println(solution(8, 4, 7));
  }

  public static int solution(int n, int a, int b)
  {
    int answer = 1;

    if (a > b) {
      int temp = a;
      a = b;
      b = temp;
    }

    while (!isPossible(a, b)) {
      a = getNextNumber(a);
      b = getNextNumber(b);
      answer++;
    }

    return answer;
  }

  private static boolean isPossible(int a, int b) {
    return b - a == 1 && !isEven(a) && isEven(b);
  }

  private static int getNextNumber(int num) {
    return (num - 1) / 2 + 1;
  }

  private static boolean isEven(int num) {
    return num % 2 == 0;
  }

}

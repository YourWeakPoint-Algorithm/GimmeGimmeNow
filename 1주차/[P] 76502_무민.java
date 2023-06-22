import java.util.Stack;

public class Solution {

  public static int solution(String s) {
    int answer = 0;
    final int length = s.length();

    if (length == 1) {
      return 0;
    }
    for (int index = 0; index < length; index++) {
      String rotatedString = s.substring(index, length) + s.substring(0, index);
      final Stack<Character> stack = new Stack<>();

      boolean flag = true;
      for (int rotateIndex = 0; rotateIndex < rotatedString.length(); rotateIndex++) {
        final char now = rotatedString.charAt(rotateIndex);
        if (isStart(now)) {
          stack.push(now);
        } else {
          if (stack.isEmpty()) {
            flag = false;
            break;
          }
          final Character pop = stack.pop();
          if (!isPair(pop, now)) {
            flag = false;
            break;
          }
        }
      }
      if (flag && stack.isEmpty()) {
        answer += 1;
      }
    }
    return answer;
  }

  private static boolean isPair(char pop, Character now) {
    return (pop == '{' && now == '}') || (pop == '[' && now == ']') || (pop == '(' && now == ')');
  }

  private static boolean isStart(char c) {
    return c == '{' || c == '[' || c == '(';
  }

  public static void main(String[] args) {
    System.out.println(solution("{({"));
  }
}

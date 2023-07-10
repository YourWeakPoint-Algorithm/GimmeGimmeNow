public class Solution {

  public static int solution(String t, String p) {
    final int successiveLength = p.length();

    int answer = 0;
    for (int i = 0; i <= t.length() - successiveLength; i++) {
      final String number = t.substring(i, i + successiveLength);
      final Long l = Long.parseLong(number);
      if (l <= Long.parseLong(p)) {
        answer++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution("3141592", "271"));
  }

}

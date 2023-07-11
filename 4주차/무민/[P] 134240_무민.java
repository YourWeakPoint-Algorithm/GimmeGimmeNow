public class Solution {
  public static String solution(int[] food) {
    StringBuilder front = new StringBuilder();
    StringBuilder back = new StringBuilder();

    for (int index = 1; index < food.length; index++) {
      int cnt = food[index];
      if (cnt % 2 != 0) {
        cnt--;
      }
      for (int f = 0; f < cnt / 2; f++) {
        front.append(index);
        back.append(index);
      }
    }

    StringBuilder answer = new StringBuilder();
    answer.append(front);
    answer.append("0");
    for (int i = back.length() - 1; i >= 0; i--) {
      answer.append(back.charAt(i));
    }

    return answer.toString();
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[] {1, 3, 4, 6}));
  }

}

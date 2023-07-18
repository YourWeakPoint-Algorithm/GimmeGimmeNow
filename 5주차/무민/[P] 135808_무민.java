import java.util.Arrays;

public class Solution {

  public static int solution(int k, int m, int[] score) {
    final int[] sortedScore = Arrays.stream(score).sorted().toArray();

    int cnt = 0;
    int answer = 0;
    for (int i = sortedScore.length - 1; i >= 0; i--) {
      cnt++;
      if (cnt == m) {
        answer += sortedScore[i] * m;
        cnt = 0;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(3, 4, new int[]{ 1,2,3,1,2,3,1}));
  }
}

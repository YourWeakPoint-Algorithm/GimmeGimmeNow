class Solution {
  public static String solution(int[] numbers, String hand) {
    int[] left = new int[]{3, 0};
    int[] right = new int[]{3, 2};
    int[][] keyPad = new int[][]{{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};

    StringBuilder answer = new StringBuilder();
    for (int i = 0; i < numbers.length; i++) {
      int number = numbers[i];
      if (isLeft(number))
        answer.append("L");
      else if (isRight(number))
        answer.append("R");
      else{
        int x = keyPad[number][0];
        int y = keyPad[number][1];
        int leftDis = Math.abs(left[0] - x) + Math.abs(left[1] - y);
        int rightDis = Math.abs(right[0] - x) + Math.abs(right[1] - y);
        if (leftDis < rightDis)
          answer.append("L");
        else if (leftDis > rightDis)
          answer.append("R");
        else {
          if (hand.equals("right"))
            answer.append("R");
          else
            answer.append("L");
        }
      }

      if (answer.charAt(i) == 'L') {
        left[0] = keyPad[number][0];
        left[1] = keyPad[number][1];
      } else {
        right[0] = keyPad[number][0];
        right[1] = keyPad[number][1];
      }
    }

    return answer.toString();
  }

  private static boolean isLeft(int number) {
    return number == 1 || number == 4 || number == 7;
  }

  private static boolean isRight(int number) {
    return number == 3 || number == 6 || number == 9;
  }
}

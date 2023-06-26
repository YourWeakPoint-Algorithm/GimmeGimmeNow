import java.util.Stack;

public class Solution {

  public static int[] solution(int[] prices) {
    final Stack<PriceTime> stack = new Stack<>();
    int[] answer = new int[prices.length];

    for (int index = 0; index < prices.length; index++) {
      if (stack.isEmpty()) {
        stack.add(new PriceTime(prices[index], index));
      } else {
        while (!stack.isEmpty()) {
          final PriceTime peek = stack.peek();
          if (prices[index] < peek.price) {
            stack.pop();
            answer[peek.time] = index - peek.time;
          } else {
            break;
          }
        }
        stack.add(new PriceTime(prices[index], index));
      }
    }

    while (!stack.isEmpty()) {
      final PriceTime pop = stack.pop();
      answer[pop.time] = (prices.length - 1) - pop.time;
    }

    return answer;
  }

  public static void main(String[] args) {
    final int[] solution = solution(new int[]{1,2,3,2,3});
    for (int i : solution) {
      System.out.println(i);
    }
  }

}

class PriceTime {
  int price;
  int time;

  public PriceTime(int price, int time) {
    this.price = price;
    this.time = time;
  }
}
